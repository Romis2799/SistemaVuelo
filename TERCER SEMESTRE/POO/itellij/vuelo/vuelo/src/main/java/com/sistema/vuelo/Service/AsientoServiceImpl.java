package com.sistema.vuelo.Service;

import com.sistema.vuelo.Model.Asiento;
import com.sistema.vuelo.Repository.AsientoRepository;
import com.sistema.vuelo.Repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsientoServiceImpl extends BaseServiceImpl<Asiento, Long> implements AsientoService  {





    public AsientoServiceImpl(AsientoRepository asientoRepository) {
        super(asientoRepository);
    }


}
