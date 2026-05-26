package com.sistema.vuelo.Service;


import com.sistema.vuelo.Model.Piloto;
import com.sistema.vuelo.Repository.BaseRepository;
import com.sistema.vuelo.Repository.PilotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PilotoServiceImpl extends BaseServiceImpl<Piloto, Long> implements PilotoService {

    public PilotoServiceImpl (PilotoRepository pilotoRepository) {
        super(pilotoRepository);
    }

}
