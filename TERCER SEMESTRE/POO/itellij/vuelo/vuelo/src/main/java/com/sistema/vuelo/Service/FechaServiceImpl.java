package com.sistema.vuelo.Service;


import com.sistema.vuelo.Model.Fecha;
import com.sistema.vuelo.Repository.BaseRepository;
import com.sistema.vuelo.Repository.FechaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FechaServiceImpl extends BaseServiceImpl<Fecha, Long> implements FechaService {



    public FechaServiceImpl(FechaRepository fechaRepository) {
        super(fechaRepository);
    }
}
