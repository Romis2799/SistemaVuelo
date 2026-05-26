package com.sistema.vuelo.Service;


import com.sistema.vuelo.Model.Aerolinea;
import com.sistema.vuelo.Repository.AerolineaRepository;
import com.sistema.vuelo.Repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AerolineaServiceImpl extends BaseServiceImpl<Aerolinea, Long> implements AerolineaService{




    public AerolineaServiceImpl(AerolineaRepository aerolineaRepository) {

        super(aerolineaRepository);
    }


}
