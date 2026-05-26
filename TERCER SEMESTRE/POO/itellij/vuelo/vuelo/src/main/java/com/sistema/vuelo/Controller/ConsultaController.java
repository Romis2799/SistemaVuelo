package com.sistema.vuelo.Controller;

import com.sistema.vuelo.Model.Consulta;
import com.sistema.vuelo.Service.ConsultaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/consulta")
@CrossOrigin(origins = "*")
public class ConsultaController extends BaseController<Consulta, Long> {


    public ConsultaController (ConsultaService consultaService) {
        super(consultaService);
    }


}
