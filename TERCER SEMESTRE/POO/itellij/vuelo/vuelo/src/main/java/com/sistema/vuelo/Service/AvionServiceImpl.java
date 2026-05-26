package com.sistema.vuelo.Service;


import com.sistema.vuelo.Model.Avion;
import com.sistema.vuelo.Repository.AvionRepository;
import com.sistema.vuelo.Repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvionServiceImpl extends BaseServiceImpl<Avion, Long> implements AvionService {




    public AvionServiceImpl(AvionRepository avionRepository) {
        super(avionRepository);
    }

}
