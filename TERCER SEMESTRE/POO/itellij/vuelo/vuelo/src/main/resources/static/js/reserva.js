const API = 'http://localhost:8080/api';
let usuarioActual = null;
let vueloActual = null;
let todosLosVuelos = [];

// =====================
// PASO 1 — USUARIO
// =====================
async function buscarUsuarioReserva() {
    const dni = document.getElementById('dniReserva').value;

    if (!dni || dni.length < 7) {
        mostrarError('errorPaso1', 'Ingresá un DNI válido');
        return;
    }

    try {
        const response = await fetch(`${API}/usuario`);
        const usuarios = await response.json();
        const usuario = usuarios.find(u => u.dni == dni);

        if (usuario) {
            usuarioActual = usuario;
            document.getElementById('btnBuscar').disabled = true;
            document.getElementById('dniReserva').disabled = true;
            irPaso2();
        } else {
            mostrarSeccion('paso1b');
        }
    } catch (error) {
        mostrarError('errorPaso1', 'Error al conectar con el servidor');
    }
}

async function registrarUsuarioReserva() {
    const dni = document.getElementById('dniReserva').value;
    const nombre = document.getElementById('regNombre').value;
    const apellido = document.getElementById('regApellido').value;
    const email = document.getElementById('regEmail').value;
    const password = document.getElementById('regPassword').value;

    if (!nombre || !apellido || !email || !password) {
        mostrarError('errorRegistroReserva', 'Completá todos los campos');
        return;
    }
    if (password.length < 6) {
        mostrarError('errorRegistroReserva', 'La contraseña debe tener al menos 6 caracteres');
        return;
    }

    const nuevoUsuario = {
        dni: parseInt(dni),
        nombre: nombre,
        apellido: apellido,
        correoElectronico: email,
        contrasenaUsuario: password,
        nroUsuario: Math.floor(Math.random() * 10000)
    };

    try {
        const response = await fetch(`${API}/usuario`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(nuevoUsuario)
        });

        if (response.ok) {
            usuarioActual = await response.json();
            document.getElementById('btnBuscar').disabled = true;
            document.getElementById('dniReserva').disabled = true;
            ocultarSeccion('paso1b');
            irPaso2();
        } else {
            mostrarError('errorRegistroReserva', 'Error al registrar');
        }
    } catch (error) {
        mostrarError('errorRegistroReserva', 'Error al conectar con el servidor');
    }
}

// =====================
// PASO 2 — VUELO
// =====================
async function irPaso2() {
    ocultarSeccion('paso1');
    ocultarSeccion('paso1b');
    mostrarSeccion('paso2');
    activarPaso(2);

    document.getElementById('nombreUsuarioReserva').textContent =
        `${usuarioActual.nombre} ${usuarioActual.apellido}`;

    const response = await fetch(`${API}/vuelo`);
    todosLosVuelos = await response.json();

    const aeropuertos = new Set();
    todosLosVuelos.forEach(v => {
        if (v.aeropuertos && v.aeropuertos.length > 0) {
            aeropuertos.add(JSON.stringify({
                id: v.aeropuertos[0].id,
                nombre: v.aeropuertos[0].nombreAeropuerto
            }));
        }
    });

    const selectOrigen = document.getElementById('selectOrigen');
    selectOrigen.innerHTML = '<option value="">Seleccioná el origen</option>';
    aeropuertos.forEach(a => {
        const aer = JSON.parse(a);
        selectOrigen.innerHTML += `<option value="${aer.id}">${aer.nombre}</option>`;
    });
}

function cargarDestinos() {
    const origenId = parseInt(document.getElementById('selectOrigen').value);
    if (!origenId) return;

    const vuelosFiltrados = todosLosVuelos.filter(v =>
        v.aeropuertos && v.aeropuertos[0]?.id === origenId
    );

    const destinos = new Set();
    vuelosFiltrados.forEach(v => {
        const ultimo = v.aeropuertos[v.aeropuertos.length - 1];
        destinos.add(JSON.stringify({ id: ultimo.id, nombre: ultimo.nombreAeropuerto }));
    });

    const selectDestino = document.getElementById('selectDestino');
    selectDestino.innerHTML = '<option value="">Seleccioná el destino</option>';
    destinos.forEach(d => {
        const dest = JSON.parse(d);
        selectDestino.innerHTML += `<option value="${dest.id}">${dest.nombre}</option>`;
    });
    selectDestino.disabled = false;

    document.getElementById('selectVuelo').disabled = true;
    document.getElementById('selectAsiento').disabled = true;
    document.getElementById('selectTarifa').disabled = true;
}

function cargarVuelos() {
    const origenId = parseInt(document.getElementById('selectOrigen').value);
    const destinoId = parseInt(document.getElementById('selectDestino').value);
    if (!destinoId) return;

    const vuelosFiltrados = todosLosVuelos.filter(v =>
        v.aeropuertos &&
        v.aeropuertos[0]?.id === origenId &&
        v.aeropuertos[v.aeropuertos.length - 1]?.id === destinoId
    );

    const selectVuelo = document.getElementById('selectVuelo');
    selectVuelo.innerHTML = '<option value="">Seleccioná el vuelo</option>';
    vuelosFiltrados.forEach(v => {
        selectVuelo.innerHTML += `<option value="${v.id}">Vuelo ${v.numeroVuelo} - ${v.aerolinea?.nombreAerolinea} - ${v.fecha?.fecha}</option>`;
    });
    selectVuelo.disabled = false;
}

function cargarAsientos() {
    const vueloId = parseInt(document.getElementById('selectVuelo').value);
    if (!vueloId) return;

    vueloActual = todosLosVuelos.find(v => v.id === vueloId);
    if (!vueloActual) return;

    // Cargar asientos
    const selectAsiento = document.getElementById('selectAsiento');
    selectAsiento.innerHTML = '<option value="">Seleccioná el asiento</option>';
    if (vueloActual.avion?.asientos) {
        vueloActual.avion.asientos.forEach(a => {
            selectAsiento.innerHTML += `<option value="${a.id}" data-clase="${a.claseAsiento}">Fila ${a.filaAsiento} - ${a.letraAsiento} (${a.claseAsiento})</option>`;
        });
    }
    selectAsiento.disabled = false;

    // Resetear tarifa
    const selectTarifa = document.getElementById('selectTarifa');
    selectTarifa.innerHTML = '<option value="">Primero seleccioná asiento</option>';
    selectTarifa.disabled = true;

    // Cuando cambia el asiento filtrar tarifas por clase
    selectAsiento.onchange = function() {
        const selectedOption = this.options[this.selectedIndex];
        const claseAsiento = selectedOption.dataset.clase;

        if (!claseAsiento) return;

        selectTarifa.innerHTML = '<option value="">Seleccioná la tarifa</option>';
        const tarifasFiltradas = vueloActual.tarifas.filter(t =>
            t.claseTarifa === claseAsiento
        );

        if (tarifasFiltradas.length === 0) {
            selectTarifa.innerHTML += '<option disabled>No hay tarifas para esta clase</option>';
        } else {
            tarifasFiltradas.forEach(t => {
                selectTarifa.innerHTML += `<option value="${t.id}">$${t.precioTarifa} - ${t.claseTarifa}</option>`;
            });
        }
        selectTarifa.disabled = false;
    };
}

function irPaso3() {
    const vuelo = document.getElementById('selectVuelo').value;
    const asiento = document.getElementById('selectAsiento').value;
    const tarifa = document.getElementById('selectTarifa').value;

    if (!vuelo || !asiento || !tarifa) {
        mostrarError('errorPaso2', 'Completá todos los campos');
        return;
    }

    ocultarSeccion('paso2');
    mostrarSeccion('paso3');
    activarPaso(3);
}

function volverPaso2() {
    ocultarSeccion('paso3');
    mostrarSeccion('paso2');
    activarPaso(2);
}

// =====================
// PASO 3 — PAGO
// =====================
async function confirmarReserva() {
    const nroTarjeta = document.getElementById('nroTarjeta').value;
    const tipoTarjeta = document.getElementById('tipoTarjeta').value;

    if (!nroTarjeta || !tipoTarjeta) {
        mostrarError('errorPaso3', 'Completá los datos de pago');
        return;
    }

    const vueloId = parseInt(document.getElementById('selectVuelo').value);
    const tarifaId = parseInt(document.getElementById('selectTarifa').value);
    const tarifa = vueloActual.tarifas.find(t => t.id === tarifaId);

    const pago = {
        nroTarjeta: parseInt(nroTarjeta),
        tipoTarjeta: tipoTarjeta,
        nroPago: Math.floor(Math.random() * 10000),
        cantidadPago: tarifa?.precioTarifa || 0
    };

    try {
        const pagoRes = await fetch(`${API}/tarjeta`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(pago)
        });

        if (!pagoRes.ok) {
            mostrarError('errorPaso3', 'Error al procesar el pago');
            return;
        }

        const pagoGuardado = await pagoRes.json();

        const nroReserva = Math.floor(Math.random() * 10000);
        const reservaRes = await fetch(
            `${API}/reserva/crear?usuarioId=${usuarioActual.id}&vueloId=${vueloId}&pagoId=${pagoGuardado.id}&numeroReserva=${nroReserva}`,
            { method: 'POST' }
        );

        if (reservaRes.ok) {
            const reservaGuardada = await reservaRes.json();
            mostrarConfirmacion(reservaGuardada);
        } else {
            mostrarError('errorPaso3', 'Error al crear la reserva');
        }
    } catch (error) {
        mostrarError('errorPaso3', 'Error al conectar con el servidor');
    }
}

// =====================
// PASO 4 — CONFIRMACIÓN
// =====================
async function mostrarConfirmacion(reserva) {
    ocultarSeccion('paso3');
    mostrarSeccion('paso4');
    activarPaso(4);

    try {
        const detalleRes = await fetch(`${API}/reserva/detalle/${reserva.id}`);
        const detalle = await detalleRes.json();

        document.getElementById('resumenReserva').innerHTML = `
                <div class="dato-fila">
                    <span class="dato-label">Nro. Reserva</span>
                    <span class="dato-valor">${detalle.numeroReserva}</span>
                </div>
                <div class="dato-fila">
                    <span class="dato-label">Pasajero</span>
                    <span class="dato-valor">${detalle.nombre} ${detalle.apellido}</span>
                </div>
                <div class="dato-fila">
                    <span class="dato-label">DNI</span>
                    <span class="dato-valor">${detalle.dni}</span>
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
                    <span class="dato-valor">Fila ${detalle.numeroAsiento} - ${detalle.letraAsiento}</span>
                </div>
                <div class="dato-fila">
                    <span class="dato-label">Tarifa</span>
                    <span class="dato-valor">$${detalle.precioTarifa}</span>
                </div>
                <div class="dato-fila">
                    <span class="dato-label">Nro. Pago</span>
                    <span class="dato-valor">${detalle.numeroPago}</span>
                </div>
                <div class="dato-fila">
                    <span class="dato-label">Tarjeta</span>
                    <span class="dato-valor">${detalle.numeroTarjeta} - ${detalle.tipoTarjeta}</span>
                </div>
            `;
    } catch (error) {
        document.getElementById('resumenReserva').innerHTML =
            '<p style="color: #e94560;">Error al cargar el detalle.</p>';
    }
}

// =====================
// FUNCIONES AUXILIARES
// =====================
function activarPaso(numero) {
    for (let i = 1; i <= 4; i++) {
        const el = document.getElementById(`pasoIndicador${i}`);
        el.classList.remove('activo', 'completado');
        if (i < numero) el.classList.add('completado');
        if (i === numero) el.classList.add('activo');
    }
}

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