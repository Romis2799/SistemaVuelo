package com.sistema.vuelo.Service;


import com.sistema.vuelo.Model.Tarjeta;
import com.sistema.vuelo.Repository.BaseRepository;
import com.sistema.vuelo.Repository.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarjetaServiceImpl extends BaseServiceImpl<Tarjeta,  Long> implements TarjetaService {

   public  TarjetaServiceImpl (TarjetaRepository tarjetaRepository) {
       super(tarjetaRepository);
   }







}
