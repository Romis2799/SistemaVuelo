package com.sistema.vuelo.Controller;


import com.sistema.vuelo.Model.Reserva;
import com.sistema.vuelo.Service.ReservaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reserva")
@CrossOrigin(origins = "*")
public class ReservaController extends BaseController<Reserva, Long> {

    public ReservaController (ReservaService reservaService) {
        super(reservaService);
    }

}
