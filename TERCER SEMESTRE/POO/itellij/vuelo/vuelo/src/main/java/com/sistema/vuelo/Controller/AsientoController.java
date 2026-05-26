package com.sistema.vuelo.Controller;


import com.sistema.vuelo.Service.AsientoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/asiento")
@CrossOrigin(origins = "*")
public class AsientoController extends BaseController {

    public AsientoController (AsientoService asientoService) {
        super(asientoService);
    }

}
