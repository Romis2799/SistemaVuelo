package com.sistema.vuelo.Service;

import com.sistema.vuelo.Dto.ReservaDetalleDto;
import com.sistema.vuelo.Model.Reserva;

public interface ReservaService extends BaseService<Reserva, Long> {

    ReservaDetalleDto getReservaDetalle(Long id) throws Exception;


}
