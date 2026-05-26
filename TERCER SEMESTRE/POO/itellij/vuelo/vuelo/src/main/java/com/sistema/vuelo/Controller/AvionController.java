package com.sistema.vuelo.Controller;

import com.sistema.vuelo.Model.Avion;
import com.sistema.vuelo.Service.AvionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/avion")
@CrossOrigin(origins = "*")
public class AvionController extends BaseController<Avion, Long> {

    public AvionController(AvionService avionService) {
        super(avionService);
    }

}
