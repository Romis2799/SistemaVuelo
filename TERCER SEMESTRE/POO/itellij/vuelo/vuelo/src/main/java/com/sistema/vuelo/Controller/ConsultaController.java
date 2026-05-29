package com.sistema.vuelo.Controller;

import com.sistema.vuelo.Dto.ConsultaDetalleDto;
import com.sistema.vuelo.Model.Consulta;
import com.sistema.vuelo.Service.ConsultaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/consulta")
@CrossOrigin(origins = "*")
public class ConsultaController extends BaseController<Consulta, Long> {

    private final ConsultaService consultaService;

    public ConsultaController (ConsultaService consultaService) {
        super(consultaService);
        this.consultaService = consultaService;
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<ConsultaDetalleDto> getDetalle(@PathVariable Long id) {
        try {
            ConsultaDetalleDto dto = consultaService.getConsultaDetalle(id);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }



}
