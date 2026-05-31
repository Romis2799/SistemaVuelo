package com.sistema.vuelo.Service;

import com.sistema.vuelo.Dto.ConsultaDetalleDto;
import com.sistema.vuelo.Model.Consulta;
import com.sistema.vuelo.Repository.ConsultaRepository;
import org.springframework.stereotype.Service;





@Service
public class ConsultaServiceImpl extends BaseServiceImpl<Consulta, Long> implements ConsultaService{

    private final ConsultaRepository consultaRepository;

    public ConsultaServiceImpl(ConsultaRepository consultaRepository) {
        super(consultaRepository);
        this.consultaRepository = consultaRepository;
    }

    @Override
    public ConsultaDetalleDto getConsultaDetalle(Long idConsulta) throws Exception{
        try{
            Consulta consulta = consultaRepository.findById(idConsulta)
                    .orElseThrow(() -> new Exception("Consulta no encontrada"));


            ConsultaDetalleDto dto = new ConsultaDetalleDto();

            //usuario
            dto.setDni(consulta.getUsuario().getDni());
            dto.setNombre(consulta.getUsuario().getNombre());
            dto.setApellido(consulta.getUsuario().getApellido());

            //consulta
            dto.setNumeroConsulta(consulta.getNumeroConsulta());

            //vuelo
            dto.setNumeroVuelo(consulta.getVuelo().getNumeroVuelo());
            dto.setAerolinea(consulta.getVuelo().getAerolinea().getNombreAerolinea());


            //tarifa
            dto.setClaseTarifa(consulta.getVuelo().getTarifas().get(0).getClaseTarifa().toString());
            dto.setPrecioTarifa(consulta.getVuelo().getTarifas().get(0).getPrecioTarifa());

            //aeropuerto, cuidad
            int ultimoAeropuerto = consulta.getVuelo().getAeropuertos().size() -1;
            dto.setNombreAeropuerto(consulta.getVuelo().getAeropuertos().get(ultimoAeropuerto).getNombreAeropuerto());
            dto.setCuidad(consulta.getVuelo().getAeropuertos().get(ultimoAeropuerto).getCiudad().getNombreCiudad());


            //asiento
            dto.setClaseAsiento(consulta.getVuelo().getAvion().getAsientos().get(0).getClaseAsiento().toString());

            //fecha
            dto.setFechaVuelo(consulta.getVuelo().getFecha().getFecha().toString());

            //piloto
            dto.setNumeroPiloto(consulta.getVuelo().getPiloto().getNumeroPiloto());
            dto.setNombreP(consulta.getVuelo().getPiloto().getNombre());
            dto.setApellidoP(consulta.getVuelo().getPiloto().getApellido());
            dto.setDniP(consulta.getVuelo().getPiloto().getDni());

            //
            return dto;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
