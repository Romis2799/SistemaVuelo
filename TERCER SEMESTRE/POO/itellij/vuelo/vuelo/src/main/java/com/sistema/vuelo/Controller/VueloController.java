package com.sistema.vuelo.Controller;

import com.sistema.vuelo.Model.Vuelo;
import com.sistema.vuelo.Service.VueloService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vuelo")
@CrossOrigin(origins = "*")
public class VueloController extends BaseController<Vuelo, Long> {


    public VueloController (VueloService vueloService) {
        super(vueloService);
    }
}
