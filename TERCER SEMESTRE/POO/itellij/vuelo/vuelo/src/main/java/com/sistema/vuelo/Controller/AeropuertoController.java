package com.sistema.vuelo.Controller;

import com.sistema.vuelo.Model.Aeropuerto;
import com.sistema.vuelo.Service.AerolineaService;
import com.sistema.vuelo.Service.AeropuertoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/aeropuerto")
@CrossOrigin(origins = "*")
public class AeropuertoController extends BaseController<Aeropuerto, Long> {

    public AeropuertoController(AeropuertoService aeropuertoService) {
        super(aeropuertoService);
    }
}
