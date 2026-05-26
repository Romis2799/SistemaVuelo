package com.sistema.vuelo.Service;

import com.sistema.vuelo.Model.Pago;
import com.sistema.vuelo.Repository.BaseRepository;
import com.sistema.vuelo.Repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagoServiceImpl extends BaseServiceImpl<Pago, Long> implements PagoService {


    public PagoServiceImpl(PagoRepository pagoRepository) {
        super(pagoRepository);
    }

}
