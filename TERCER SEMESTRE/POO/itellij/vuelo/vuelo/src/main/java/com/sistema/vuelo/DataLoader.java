package com.sistema.vuelo;

import com.sistema.vuelo.Model.*;
import com.sistema.vuelo.Repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final CiudadRepository ciudadRepository;
    private final AerolineaRepository aerolineaRepository;
    private final AeropuertoRepository aeropuertoRepository;
    private final AvionRepository avionRepository;
    private final AsientoRepository asientoRepository;
    private final FechaRepository fechaRepository;
    private final PilotoRepository pilotoRepository;
    private final TarifaRepository tarifaRepository;
    private final VueloRepository vueloRepository;
    private final UsuarioRepository usuarioRepository;

    public DataLoader(CiudadRepository ciudadRepository,
                      AerolineaRepository aerolineaRepository,
                      AeropuertoRepository aeropuertoRepository,
                      AvionRepository avionRepository,
                      AsientoRepository asientoRepository,
                      FechaRepository fechaRepository,
                      PilotoRepository pilotoRepository,
                      TarifaRepository tarifaRepository,
                      VueloRepository vueloRepository,
                      UsuarioRepository usuarioRepository) {
        this.ciudadRepository = ciudadRepository;
        this.aerolineaRepository = aerolineaRepository;
        this.aeropuertoRepository = aeropuertoRepository;
        this.avionRepository = avionRepository;
        this.asientoRepository = asientoRepository;
        this.fechaRepository = fechaRepository;
        this.pilotoRepository = pilotoRepository;
        this.tarifaRepository = tarifaRepository;
        this.vueloRepository = vueloRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Solo carga datos si la base está vacía
        if (ciudadRepository.count() > 0) return;

        // Ciudades
        Ciudad mendoza = new Ciudad();
        mendoza.setNombreCuidad("Mendoza");
        ciudadRepository.save(mendoza);

        Ciudad buenosAires = new Ciudad();
        buenosAires.setNombreCuidad("Buenos Aires");
        ciudadRepository.save(buenosAires);

        Ciudad cordoba = new Ciudad();
        cordoba.setNombreCuidad("Córdoba");
        ciudadRepository.save(cordoba);

        // Aeropuertos
        Aeropuerto aerMendoza = new Aeropuerto();
        aerMendoza.setNombreAeropuerto("Aeropuerto El Plumerillo");
        aerMendoza.setCiudad(mendoza);
        aeropuertoRepository.save(aerMendoza);

        Aeropuerto aerEzeiza = new Aeropuerto();
        aerEzeiza.setNombreAeropuerto("Aeropuerto Internacional Ezeiza");
        aerEzeiza.setCiudad(buenosAires);
        aeropuertoRepository.save(aerEzeiza);

        Aeropuerto aerCordoba = new Aeropuerto();
        aerCordoba.setNombreAeropuerto("Aeropuerto Internacional Córdoba");
        aerCordoba.setCiudad(cordoba);
        aeropuertoRepository.save(aerCordoba);

        // Aerolineas
        Aerolinea aerolinea1 = new Aerolinea();
        aerolinea1.setNombreAerolinea("Aerolíneas Argentinas");
        aerolineaRepository.save(aerolinea1);

        Aerolinea aerolinea2 = new Aerolinea();
        aerolinea2.setNombreAerolinea("LATAM");
        aerolineaRepository.save(aerolinea2);

        // Pilotos
        Piloto piloto1 = new Piloto();
        piloto1.setDni(20111222);
        piloto1.setNombre("Carlos");
        piloto1.setApellido("Rodríguez");
        piloto1.setNumeroPiloto(1001);
        pilotoRepository.save(piloto1);

        Piloto piloto2 = new Piloto();
        piloto2.setDni(20333444);
        piloto2.setNombre("Laura");
        piloto2.setApellido("Gómez");
        piloto2.setNumeroPiloto(1002);
        pilotoRepository.save(piloto2);

        // Aviones con asientos
        Avion avion1 = new Avion();
        avion1.setTipoTurbina("Turbofan");
        avion1.setTipoAvion("Boeing 737");

        Asiento a1 = new Asiento();
        a1.setFilaAsiento(1);
        a1.setLetraAsiento('A');
        a1.setClaseAsiento(Clase.BUSINESS);

        Asiento a2 = new Asiento();
        a2.setFilaAsiento(2);
        a2.setLetraAsiento('B');
        a2.setClaseAsiento(Clase.ECONOMY);

        avion1.getAsientos().add(a1);
        avion1.getAsientos().add(a2);
        avionRepository.save(avion1);

        Avion avion2 = new Avion();
        avion2.setTipoTurbina("Turbohélice");
        avion2.setTipoAvion("Airbus A320");

        Asiento a3 = new Asiento();
        a3.setFilaAsiento(1);
        a3.setLetraAsiento('A');
        a3.setClaseAsiento(Clase.TURISTA);

        avion2.getAsientos().add(a3);
        avionRepository.save(avion2);

        // Fechas
        Fecha fecha1 = new Fecha();
        fecha1.setFecha(new java.util.Date());
        fechaRepository.save(fecha1);

        Fecha fecha2 = new Fecha();
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.add(java.util.Calendar.DAY_OF_MONTH, 7);
        fecha2.setFecha(cal.getTime());
        fechaRepository.save(fecha2);

        // Tarifas
        Tarifa tarifa1 = new Tarifa();
        tarifa1.setImpuestoTarifa(21);
        tarifa1.setPrecioTarifa(15000);
        tarifa1.setClaseTarifa(Clase.ECONOMY);
        tarifaRepository.save(tarifa1);

        Tarifa tarifa2 = new Tarifa();
        tarifa2.setImpuestoTarifa(21);
        tarifa2.setPrecioTarifa(35000);
        tarifa2.setClaseTarifa(Clase.BUSINESS);
        tarifaRepository.save(tarifa2);

        // Vuelos
        Vuelo vuelo1 = new Vuelo();
        vuelo1.setNumeroVuelo(101);
        vuelo1.setAerolinea(aerolinea1);
        vuelo1.setPiloto(piloto1);
        vuelo1.setAvion(avion1);
        vuelo1.setFecha(fecha1);
        vuelo1.getAeropuertos().add(aerMendoza);
        vuelo1.getAeropuertos().add(aerEzeiza);
        vuelo1.getTarifas().add(tarifa1);
        vuelo1.getTarifas().add(tarifa2);
        vueloRepository.save(vuelo1);

        Vuelo vuelo2 = new Vuelo();
        vuelo2.setNumeroVuelo(102);
        vuelo2.setAerolinea(aerolinea2);
        vuelo2.setPiloto(piloto2);
        vuelo2.setAvion(avion2);
        vuelo2.setFecha(fecha2);
        vuelo2.getAeropuertos().add(aerMendoza);
        vuelo2.getAeropuertos().add(aerCordoba);
        vuelo2.getTarifas().add(tarifa1);
        vueloRepository.save(vuelo2);

        // Usuarios
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

        System.out.println("Datos de prueba cargados correctamente");
    }
}