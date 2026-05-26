package com.sistema.vuelo.Service;


import com.sistema.vuelo.Model.Ciudad;
import com.sistema.vuelo.Repository.BaseRepository;
import com.sistema.vuelo.Repository.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CiudadServiceImpl extends BaseServiceImpl<Ciudad, Long> implements CiudadService {


    public CiudadServiceImpl(CiudadRepository ciudadRepository) {
        super(ciudadRepository);
    }


}
