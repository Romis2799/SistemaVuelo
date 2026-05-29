package com.sistema.vuelo.Service;


import com.sistema.vuelo.Dto.ConsultaDetalleDto;
import com.sistema.vuelo.Model.Consulta;

public interface ConsultaService extends BaseService<Consulta, Long> {

    ConsultaDetalleDto getConsultaDetalle(Long id) throws Exception;


}
