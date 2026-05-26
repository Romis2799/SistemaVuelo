package com.sistema.vuelo.Service;


import com.sistema.vuelo.Model.Vuelo;
import com.sistema.vuelo.Repository.BaseRepository;
import com.sistema.vuelo.Repository.UsuarioRepository;
import com.sistema.vuelo.Repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VueloServiceImpl extends BaseServiceImpl<Vuelo, Long> implements VueloService {

   public  VueloServiceImpl (VueloRepository vueloRepository) {
       super(vueloRepository);
   }







}
