package com.sistema.vuelo.Service;


import com.sistema.vuelo.Dto.ReservaDetalleDto;
import com.sistema.vuelo.Model.Reserva;
import com.sistema.vuelo.Model.Tarjeta;
import com.sistema.vuelo.Repository.ReservaRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImpl extends BaseServiceImpl<Reserva, Long> implements ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaServiceImpl(ReservaRepository reservaRepository) {
        super(reservaRepository);
        this.reservaRepository = reservaRepository;
    }

    @Override
    public ReservaDetalleDto getReservaDetalle(Long idReserva) throws Exception {

        try {
            Reserva reserva = reservaRepository.findById(idReserva)
                    .orElseThrow(() -> new Exception("Reserva no encontrada"));

            ReservaDetalleDto dto = new ReservaDetalleDto();

            // Datos del usuario
            dto.setDniUsuario(reserva.getUsuario().getDni());
            dto.setNombreUsuario(reserva.getUsuario().getNombre());
            dto.setApellidoUsuario(reserva.getUsuario().getApellido());

            // Datos de la reserva
            dto.setNumeroReserva(reserva.getNumeroReserva());

            // Datos del vuelo
            dto.setNumeroVuelo(reserva.getVuelo().getNumeroVuelo());
            dto.setNombreAerolinea(reserva.getVuelo().getAerolinea().getNombreAerolinea());

            // Datos de la tarifa
            dto.setPrecioTarifa(reserva.getVuelo().getTarifas().get(0).getPrecioTarifa());

            // Datos del aeropuerto y ciudad destino
            int ultimoAeropuerto = reserva.getVuelo().getAeropuertos().size() - 1;
            dto.setNombreAeropuerto(reserva.getVuelo().getAeropuertos().get(ultimoAeropuerto).getNombreAeropuerto());
            dto.setNombreCiudad(reserva.getVuelo().getAeropuertos().get(ultimoAeropuerto).getCiudad().getNombreCuidad());

            // Datos del asiento
            dto.setNumeroAsiento(reserva.getVuelo().getAvion().getAsientos().get(0).getFilaAsiento());
            dto.setLetraAsiento(reserva.getVuelo().getAvion().getAsientos().get(0).getLetraAsiento());

            // Datos del avión
            dto.setNumeroAvion(reserva.getVuelo().getAvion().getId());
            dto.setTipoTurbina(reserva.getVuelo().getAvion().getTipoTurbina());

            // Datos de la fecha
            dto.setFechaVuelo(reserva.getVuelo().getFecha().getFecha().toString());

            // Datos del pago
            dto.setNumeroPago(reserva.getPago().getNroPago());

            // Datos de la tarjeta
            dto.setNumeroTarjeta(((Tarjeta) reserva.getPago()).getNroTarjeta());
            dto.setTipoTarjeta(((Tarjeta) reserva.getPago()).getTipoTarjeta().toString());

            return dto;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }


    }


}