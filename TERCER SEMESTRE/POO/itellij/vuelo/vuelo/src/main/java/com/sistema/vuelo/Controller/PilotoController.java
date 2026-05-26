package com.sistema.vuelo.Controller;

import com.sistema.vuelo.Model.Piloto;
import com.sistema.vuelo.Service.PilotoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/piloto")
@CrossOrigin(origins = "*")
public class PilotoController extends BaseController <Piloto, Long>{

    public PilotoController (PilotoService pilotoService) {
        super(pilotoService);
    }
}
