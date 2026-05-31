package com.sistema.vuelo.Controller;

import com.sistema.vuelo.Dto.ReservaDetalleDto;
import com.sistema.vuelo.Model.*;
import com.sistema.vuelo.Repository.*;
import com.sistema.vuelo.Service.ReservaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reserva")
@CrossOrigin(origins = "*")
public class ReservaController extends BaseController<Reserva, Long> {

    private final ReservaService reservaService;
    private final UsuarioRepository usuarioRepository;
    private final VueloRepository vueloRepository;
    private final TarjetaRepository tarjetaRepository;

    public ReservaController(ReservaService reservaService,
                             UsuarioRepository usuarioRepository,
                             VueloRepository vueloRepository,
                             TarjetaRepository tarjetaRepository) {
        super(reservaService);
        this.reservaService = reservaService;
        this.usuarioRepository = usuarioRepository;
        this.vueloRepository = vueloRepository;
        this.tarjetaRepository = tarjetaRepository;
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

    @PostMapping("/crear")
    public ResponseEntity<Reserva> crearReserva(
            @RequestParam Long usuarioId,
            @RequestParam Long vueloId,
            @RequestParam Long pagoId,
            @RequestParam int numeroReserva) {
        try {
            Usuario usuario = usuarioRepository.findById(usuarioId)
                    .orElseThrow(() -> new Exception("Usuario no encontrado"));
            Vuelo vuelo = vueloRepository.findById(vueloId)
                    .orElseThrow(() -> new Exception("Vuelo no encontrado"));
            Tarjeta tarjeta = tarjetaRepository.findById(pagoId)
                    .orElseThrow(() -> new Exception("Pago no encontrado"));

            // Asociar tarjeta al usuario si no la tiene ya
            boolean tarjetaExiste = usuario.getTarjetas().stream()
                    .anyMatch(t -> t.getNroTarjeta().equals(tarjeta.getNroTarjeta()));
            if (!tarjetaExiste) {
                usuario.getTarjetas().add(tarjeta);
                usuarioRepository.save(usuario);
            }

            Reserva reserva = new Reserva();
            reserva.setNumeroReserva(numeroReserva);
            reserva.setUsuario(usuario);
            reserva.setVuelo(vuelo);
            reserva.setPago(tarjeta);

            Reserva saved = reservaService.save(reserva);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}