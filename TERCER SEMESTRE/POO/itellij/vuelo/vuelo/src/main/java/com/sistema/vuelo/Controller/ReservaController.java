package com.sistema.vuelo.Controller;


import com.sistema.vuelo.Dto.ReservaDetalleDto;
import com.sistema.vuelo.Model.Reserva;
import com.sistema.vuelo.Service.ReservaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reserva")
@CrossOrigin(origins = "*")
public class ReservaController extends BaseController<Reserva, Long> {


    private final ReservaService reservaService;

    public ReservaController (ReservaService reservaService) {
        super(reservaService);
        this.reservaService = reservaService;
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<ReservaDetalleDto> getDetalle(@PathVariable Long id) {
        try {
            ReservaDetalleDto dto = reservaService.getReservaDetalle(id);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }



}
