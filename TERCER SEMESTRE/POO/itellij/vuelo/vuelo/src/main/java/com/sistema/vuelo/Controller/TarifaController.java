package com.sistema.vuelo.Controller;


import com.sistema.vuelo.Model.Tarifa;
import com.sistema.vuelo.Service.TarifaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tarifa")
@CrossOrigin(origins = "*")
public class TarifaController extends BaseController<Tarifa, Long> {

    public TarifaController (TarifaService tarifaService) {
        super(tarifaService);
    }
}
