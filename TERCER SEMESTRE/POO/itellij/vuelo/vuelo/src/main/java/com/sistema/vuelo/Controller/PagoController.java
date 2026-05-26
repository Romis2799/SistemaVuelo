package com.sistema.vuelo.Controller;


import com.sistema.vuelo.Model.Pago;
import com.sistema.vuelo.Service.PagoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pago")
@CrossOrigin(origins = "*")
public class PagoController extends BaseController <Pago, Long>{

    public PagoController (PagoService pagoService) {
        super(pagoService);
    }
}
