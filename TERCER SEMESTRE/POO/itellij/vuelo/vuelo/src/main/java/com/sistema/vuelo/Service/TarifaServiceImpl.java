package com.sistema.vuelo.Service;


import com.sistema.vuelo.Model.Tarifa;
import com.sistema.vuelo.Repository.BaseRepository;
import com.sistema.vuelo.Repository.TarifaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarifaServiceImpl extends BaseServiceImpl<Tarifa, Long> implements TarifaService {

    public TarifaServiceImpl (TarifaRepository tarifaRepository) {
            super(tarifaRepository);
    }

}
