package com.sistema.vuelo.Service;


import com.sistema.vuelo.Dto.ConsultaDetalleDto;
import com.sistema.vuelo.Model.Ciudad;
import com.sistema.vuelo.Model.Consulta;
import com.sistema.vuelo.Repository.CiudadRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Service
public class CiudadServiceImpl extends BaseServiceImpl<Ciudad, Long> implements CiudadService {


    public CiudadServiceImpl(CiudadRepository ciudadRepository) {
        super(ciudadRepository);
    }




}
