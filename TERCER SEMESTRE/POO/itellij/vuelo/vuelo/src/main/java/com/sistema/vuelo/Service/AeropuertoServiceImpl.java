package com.sistema.vuelo.Service;


import com.sistema.vuelo.Model.Aeropuerto;
import com.sistema.vuelo.Repository.AeropuertoRepository;
import org.springframework.stereotype.Service;

@Service
public class AeropuertoServiceImpl extends BaseServiceImpl<Aeropuerto, Long> implements AeropuertoService  {



    public AeropuertoServiceImpl(AeropuertoRepository aeropuertoRepository) {
        super(aeropuertoRepository);
    }

}
