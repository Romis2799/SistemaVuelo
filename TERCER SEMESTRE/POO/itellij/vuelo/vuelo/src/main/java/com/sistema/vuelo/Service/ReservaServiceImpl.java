package com.sistema.vuelo.Service;


import com.sistema.vuelo.Model.Reserva;
import com.sistema.vuelo.Repository.BaseRepository;
import com.sistema.vuelo.Repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImpl extends BaseServiceImpl<Reserva, Long> implements ReservaService {

   public ReservaServiceImpl (ReservaRepository reservaRepository) {
       super(reservaRepository);
   }

}
