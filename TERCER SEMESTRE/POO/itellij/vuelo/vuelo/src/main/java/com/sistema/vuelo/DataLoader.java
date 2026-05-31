package com.sistema.vuelo;

import com.sistema.vuelo.Model.*;
import com.sistema.vuelo.Repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataLoader implements CommandLineRunner {

    private final CiudadRepository ciudadRepository;
    private final AerolineaRepository aerolineaRepository;
    private final AeropuertoRepository aeropuertoRepository;
    private final AvionRepository avionRepository;
    private final FechaRepository fechaRepository;
    private final PilotoRepository pilotoRepository;
    private final TarifaRepository tarifaRepository;
    private final VueloRepository vueloRepository;
    private final UsuarioRepository usuarioRepository;

    public DataLoader(CiudadRepository ciudadRepository,
                      AerolineaRepository aerolineaRepository,
                      AeropuertoRepository aeropuertoRepository,
                      AvionRepository avionRepository,
                      FechaRepository fechaRepository,
                      PilotoRepository pilotoRepository,
                      TarifaRepository tarifaRepository,
                      VueloRepository vueloRepository,
                      UsuarioRepository usuarioRepository) {
        this.ciudadRepository = ciudadRepository;
        this.aerolineaRepository = aerolineaRepository;
        this.aeropuertoRepository = aeropuertoRepository;
        this.avionRepository = avionRepository;
        this.fechaRepository = fechaRepository;
        this.pilotoRepository = pilotoRepository;
        this.tarifaRepository = tarifaRepository;
        this.vueloRepository = vueloRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (ciudadRepository.count() > 0) return;

        // =====================
        // CIUDADES Y AEROPUERTOS
        // =====================
        String[][] ciudadesYAeropuertos = {
                {"Mendoza", "Aeropuerto El Plumerillo"},
                {"Buenos Aires", "Aeropuerto Internacional Ezeiza"},
                {"Córdoba", "Aeropuerto Internacional Córdoba"},
                {"Rosario", "Aeropuerto Internacional Rosario"},
                {"Salta", "Aeropuerto Internacional Martín Miguel de Güemes"},
                {"Bariloche", "Aeropuerto Internacional Bariloche"},
                {"Tucumán", "Aeropuerto Internacional Tucumán"},
                {"Mar del Plata", "Aeropuerto Internacional Mar del Plata"},
                {"Neuquén", "Aeropuerto Internacional Neuquén"},
                {"Ushuaia", "Aeropuerto Internacional Malvinas Argentinas"}
        };

        List<Aeropuerto> aeropuertos = new ArrayList<>();
        for (String[] par : ciudadesYAeropuertos) {
            Ciudad ciudad = new Ciudad();
            ciudad.setNombreCiudad(par[0]);
            ciudadRepository.save(ciudad);

            Aeropuerto aeropuerto = new Aeropuerto();
            aeropuerto.setNombreAeropuerto(par[1]);
            aeropuerto.setCiudad(ciudad);
            aeropuertoRepository.save(aeropuerto);
            aeropuertos.add(aeropuerto);
        }

        // =====================
        // AEROLINEAS
        // =====================
        String[] nombresAerolineas = {
                "Aerolíneas Argentinas", "LATAM", "Flybondi"
        };
        List<Aerolinea> aerolineas = new ArrayList<>();
        for (String nombre : nombresAerolineas) {
            Aerolinea a = new Aerolinea();
            a.setNombreAerolinea(nombre);
            aerolineaRepository.save(a);
            aerolineas.add(a);
        }

        // =====================
        // AVIONES (uno por aerolinea, 12 asientos cada uno)
        // =====================
        String[] tiposAvion = {"Boeing 737", "Airbus A320", "Embraer E190"};
        String[] tiposTurbina = {"Turbofan CFM56", "Turbofan CFM LEAP", "Turbofan GE CF34"};
        List<Avion> aviones = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Avion avion = new Avion();
            avion.setTipoAvion(tiposAvion[i]);
            avion.setTipoTurbina(tiposTurbina[i]);

            // 4 filas × 3 letras = 12 asientos
            // letra A → BUSINESS, B → ECONOMY, C → TURISTA
            for (int fila = 1; fila <= 4; fila++) {
                Asiento a = new Asiento();
                a.setFilaAsiento(fila);
                a.setLetraAsiento('A');
                a.setClaseAsiento(Clase.BUSINESS);
                avion.getAsientos().add(a);

                Asiento b = new Asiento();
                b.setFilaAsiento(fila);
                b.setLetraAsiento('B');
                b.setClaseAsiento(Clase.ECONOMY);
                avion.getAsientos().add(b);

                Asiento c = new Asiento();
                c.setFilaAsiento(fila);
                c.setLetraAsiento('C');
                c.setClaseAsiento(Clase.TURISTA);
                avion.getAsientos().add(c);
            }
            avionRepository.save(avion);
            aviones.add(avion);
        }

        // =====================
        // TARIFAS (una por clase por aerolinea)
        // =====================
        int[][] precios = {
                {45000, 25000, 15000},  // Aerolíneas Argentinas
                {42000, 22000, 13000},  // LATAM
                {35000, 18000, 10000}   // Flybondi
        };

        List<List<Tarifa>> tarifasPorAerolinea = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            List<Tarifa> tarifas = new ArrayList<>();

            Tarifa tb = new Tarifa();
            tb.setClaseTarifa(Clase.BUSINESS);
            tb.setPrecioTarifa(precios[i][0]);
            tb.setImpuestoTarifa(21);
            tarifaRepository.save(tb);
            tarifas.add(tb);

            Tarifa te = new Tarifa();
            te.setClaseTarifa(Clase.ECONOMY);
            te.setPrecioTarifa(precios[i][1]);
            te.setImpuestoTarifa(21);
            tarifaRepository.save(te);
            tarifas.add(te);

            Tarifa tt = new Tarifa();
            tt.setClaseTarifa(Clase.TURISTA);
            tt.setPrecioTarifa(precios[i][2]);
            tt.setImpuestoTarifa(21);
            tarifaRepository.save(tt);
            tarifas.add(tt);

            tarifasPorAerolinea.add(tarifas);
        }

        // =====================
        // PILOTOS
        // =====================
        String[][] nombresPilotos = {
                {"Carlos", "Rodríguez"}, {"Laura", "Gómez"}, {"Martín", "López"},
                {"Sofía", "Fernández"}, {"Diego", "Martínez"}, {"Ana", "García"},
                {"Pablo", "Pérez"}, {"Lucía", "Torres"}, {"Andrés", "Ramírez"},
                {"Valeria", "Sánchez"}, {"Federico", "Herrera"}, {"Natalia", "Castro"},
                {"Gustavo", "Morales"}, {"Cecilia", "Jiménez"}, {"Roberto", "Díaz"},
                {"Marina", "Ruiz"}, {"Sebastián", "Vargas"}, {"Patricia", "Mendoza"},
                {"Nicolás", "Vega"}, {"Claudia", "Reyes"}
        };

        List<Piloto> pilotos = new ArrayList<>();
        for (int i = 0; i < nombresPilotos.length; i++) {
            Piloto p = new Piloto();
            p.setNombre(nombresPilotos[i][0]);
            p.setApellido(nombresPilotos[i][1]);
            p.setDni(20000000 + (i * 1111111));
            p.setNumeroPiloto(1001 + i);
            pilotoRepository.save(p);
            pilotos.add(p);
        }

        // =====================
        // FECHAS (próximos 30 días)
        // =====================
        List<Fecha> fechas = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        for (int i = 1; i <= 30; i++) {
            cal.setTime(new Date());
            cal.add(Calendar.DAY_OF_MONTH, i);
            Fecha f = new Fecha();
            f.setFecha(cal.getTime());
            fechaRepository.save(f);
            fechas.add(f);
        }

        // =====================
        // VUELOS
        // 10 ciudades × 9 destinos × 3 aerolineas = 270 vuelos
        // =====================
        int numeroVuelo = 1001;
        int pilotoIndex = 0;
        int fechaIndex = 0;

        for (int origen = 0; origen < aeropuertos.size(); origen++) {
            for (int destino = 0; destino < aeropuertos.size(); destino++) {
                if (origen == destino) continue;

                for (int aerolineaIdx = 0; aerolineaIdx < aerolineas.size(); aerolineaIdx++) {
                    Vuelo vuelo = new Vuelo();
                    vuelo.setNumeroVuelo(numeroVuelo++);
                    vuelo.setAerolinea(aerolineas.get(aerolineaIdx));
                    vuelo.setAvion(aviones.get(aerolineaIdx));
                    vuelo.setPiloto(pilotos.get(pilotoIndex % pilotos.size()));
                    vuelo.setFecha(fechas.get(fechaIndex % fechas.size()));
                    vuelo.getAeropuertos().add(aeropuertos.get(origen));
                    vuelo.getAeropuertos().add(aeropuertos.get(destino));
                    vuelo.getTarifas().addAll(tarifasPorAerolinea.get(aerolineaIdx));

                    vueloRepository.save(vuelo);

                    pilotoIndex++;
                    fechaIndex++;
                }
            }
        }

        // =====================
        // USUARIOS DE PRUEBA
        // =====================
        Usuario usuario1 = new Usuario();
        usuario1.setDni(12345678);
        usuario1.setNombre("Ana");
        usuario1.setApellido("García");
        usuario1.setCorreoElectronico("ana@email.com");
        usuario1.setContrasenaUsuario("123456");
        usuario1.setNroUsuario(1);
        usuarioRepository.save(usuario1);

        Usuario usuario2 = new Usuario();
        usuario2.setDni(87654321);
        usuario2.setNombre("Juan");
        usuario2.setApellido("Pérez");
        usuario2.setCorreoElectronico("juan@email.com");
        usuario2.setContrasenaUsuario("123456");
        usuario2.setNroUsuario(2);
        usuarioRepository.save(usuario2);

        System.out.println(" Datos de prueba cargados: " +
                aeropuertos.size() + " aeropuertos, " +
                aerolineas.size() + " aerolíneas, " +
                "270 vuelos, " +
                pilotos.size() + " pilotos, " +
                "3 aviones con 12 asientos c/u");
    }
}