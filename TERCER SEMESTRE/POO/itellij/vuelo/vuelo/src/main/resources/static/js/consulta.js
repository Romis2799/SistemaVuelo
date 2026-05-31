const API = 'http://localhost:8080/api';

async function buscarUsuario() {
    const dni = document.getElementById('inputDni').value;

    // Validación
    if (!dni || dni.trim() === '') {
        mostrarError('errorBusqueda', 'Por favor ingresá un DNI');
        return;
    }
    if (dni.length < 7 || dni.length > 8) {
        mostrarError('errorBusqueda', 'El DNI debe tener entre 7 y 8 dígitos');
        return;
    }

    ocultarError('errorBusqueda');
    ocultarSeccion('resultadoUsuario');
    ocultarSeccion('formNuevoUsuario');

    try {
        // Trae todos los usuarios y busca por DNI
        const response = await fetch(`${API}/usuario`);
        const usuarios = await response.json();
        const usuario = usuarios.find(u => u.dni == dni);

        if (usuario) {
            mostrarUsuario(usuario);
            cargarReservas(usuario.id);
        } else {
            // No encontrado, mostrar formulario de registro
            document.getElementById('nuevoDni').value = dni;
            mostrarSeccion('formNuevoUsuario');
        }
    } catch (error) {
        mostrarError('errorBusqueda', 'Error al conectar con el servidor');
    }
}

function mostrarUsuario(usuario) {
    document.getElementById('usuarioDni').textContent = usuario.dni;
    document.getElementById('usuarioNombre').textContent = usuario.nombre;
    document.getElementById('usuarioApellido').textContent = usuario.apellido;
    document.getElementById('usuarioEmail').textContent = usuario.correoElectronico;
    mostrarSeccion('resultadoUsuario');
}

async function cargarReservas(usuarioId) {
    try {
        const response = await fetch(`${API}/reserva`);
        const reservas = await response.json();
        const reservasUsuario = reservas.filter(r => r.usuario?.id === usuarioId);

        const lista = document.getElementById('listaReservas');

        if (reservasUsuario.length === 0) {
            lista.innerHTML = '<p style="color: #a8a8b3; margin-top: 10px;">No tiene reservas registradas.</p>';
            return;
        }

        lista.innerHTML = '';
        for (const reserva of reservasUsuario) {
            const detalleRes = await fetch(`${API}/reserva/detalle/${reserva.id}`);
            const detalle = await detalleRes.json();

            lista.innerHTML += `
                <div class="resultado visible" style="margin-top: 15px;">
                    <div class="dato-fila">
                        <span class="dato-label">Nro. Reserva</span>
                        <span class="dato-valor">${detalle.numeroReserva}</span>
                    </div>
                    <div class="dato-fila">
                        <span class="dato-label">Vuelo</span>
                        <span class="dato-valor">${detalle.numeroVuelo}</span>
                    </div>
                    <div class="dato-fila">
                        <span class="dato-label">Aerolínea</span>
                        <span class="dato-valor">${detalle.aerolinea}</span>
                    </div>
                    <div class="dato-fila">
                        <span class="dato-label">Destino</span>
                        <span class="dato-valor">${detalle.nombreAeropuerto} - ${detalle.ciudad}</span>
                    </div>
                    <div class="dato-fila">
                        <span class="dato-label">Fecha</span>
                        <span class="dato-valor">${detalle.fechaVuelo}</span>
                    </div>
                    <div class="dato-fila">
                        <span class="dato-label">Asiento</span>
                        <span class="dato-valor">Asiento ${detalle.numeroAsiento} - ${detalle.letraAsiento}</span>
                    </div>
                    <div class="dato-fila">
                        <span class="dato-label">Tarifa</span>
                        <span class="dato-valor">$${detalle.precioTarifa}</span>
                    </div>
                </div>
            `;
        }
    } catch (error) {
        document.getElementById('listaReservas').innerHTML =
            '<p style="color: #e94560;">Error al cargar las reservas.</p>';
    }
}

async function registrarUsuario() {
    const dni = document.getElementById('nuevoDni').value;
    const nombre = document.getElementById('nuevoNombre').value;
    const apellido = document.getElementById('nuevoApellido').value;
    const email = document.getElementById('nuevoEmail').value;
    const password = document.getElementById('nuevoPassword').value;

    // Validaciones
    if (!dni || !nombre || !apellido || !email || !password) {
        mostrarError('errorRegistro', 'Completá todos los campos');
        return;
    }
    if (email.indexOf('@') === -1) {
        mostrarError('errorRegistro', 'El email no es válido');
        return;
    }
    if (password.length < 6) {
        mostrarError('errorRegistro', 'La contraseña debe tener al menos 6 caracteres');
        return;
    }

    ocultarError('errorRegistro');

    const nuevoUsuario = {
        dni: parseInt(dni),
        nombre: nombre,
        apellido: apellido,
        correoElectronico: email,
        contrasenaUsuario: password,
        numeroUsuario: Math.floor(Math.random() * 10000)
    };

    try {
        const response = await fetch(`${API}/usuario`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(nuevoUsuario)
        });

        if (response.ok) {
            const usuario = await response.json();
            mostrarExito('exitoRegistro', '✅ Usuario registrado correctamente');
            ocultarSeccion('formNuevoUsuario');
            mostrarUsuario(usuario);
            cargarReservas(usuario.id);
        } else {
            mostrarError('errorRegistro', 'Error al registrar el usuario');
        }
    } catch (error) {
        mostrarError('errorRegistro', 'Error al conectar con el servidor');
    }
}

// Funciones auxiliares
function mostrarSeccion(id) {
    document.getElementById(id).classList.add('visible');
}
function ocultarSeccion(id) {
    document.getElementById(id).classList.remove('visible');
}
function mostrarError(id, mensaje) {
    const el = document.getElementById(id);
    el.textContent = mensaje;
    el.classList.add('visible');
}
function ocultarError(id) {
    document.getElementById(id).classList.remove('visible');
}
function mostrarExito(id, mensaje) {
    const el = document.getElementById(id);
    el.textContent = mensaje;
    el.classList.add('visible');
}