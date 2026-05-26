package com.sistema.vuelo.Controller;


import com.sistema.vuelo.Model.Tarjeta;
import com.sistema.vuelo.Service.TarjetaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tarjeta")
@CrossOrigin(origins = "*")
public class TarjetaController extends BaseController<Tarjeta, Long> {

    public TarjetaController (TarjetaService tarjetaService) {
        super(tarjetaService);
    }
}
