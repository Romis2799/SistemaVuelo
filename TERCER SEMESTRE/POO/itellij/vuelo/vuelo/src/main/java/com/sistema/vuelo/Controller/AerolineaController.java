package com.sistema.vuelo.Controller;

import com.sistema.vuelo.Model.Aerolinea;
import com.sistema.vuelo.Service.AerolineaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/aerolinea")
@CrossOrigin(origins = "*")
public class AerolineaController extends BaseController<Aerolinea, Long> {

    public AerolineaController(AerolineaService avionService) {
        super(avionService);
    }
}
