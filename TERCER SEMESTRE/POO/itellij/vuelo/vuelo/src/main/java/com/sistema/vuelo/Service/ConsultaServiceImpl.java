package com.sistema.vuelo.Service;

import com.sistema.vuelo.Model.Consulta;
import com.sistema.vuelo.Repository.BaseRepository;
import com.sistema.vuelo.Repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaServiceImpl extends BaseServiceImpl<Consulta, Long> implements ConsultaService{


    public ConsultaServiceImpl(ConsultaRepository consultaRepository) {
        super(consultaRepository);
    }


}
