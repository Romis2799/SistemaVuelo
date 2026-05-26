package com.sistema.vuelo.Controller;


import com.sistema.vuelo.Service.CiudadService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ciudad")
@CrossOrigin(origins = "*")
public class CiudadController extends BaseController {

    public CiudadController (CiudadService ciudadService) {
        super(ciudadService);
    }
}
