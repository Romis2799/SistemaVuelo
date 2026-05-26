package com.sistema.vuelo.Controller;

import com.sistema.vuelo.Model.Fecha;
import com.sistema.vuelo.Service.FechaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fecha")
@CrossOrigin(origins = "*")
public class FechaController extends BaseController<Fecha, Long> {
    public FechaController (FechaService fechaService) {
        super(fechaService);
    }
}
