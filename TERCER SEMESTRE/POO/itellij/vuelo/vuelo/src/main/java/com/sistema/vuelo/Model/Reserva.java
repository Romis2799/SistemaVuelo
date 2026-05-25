package com.sistema.vuelo.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "Reserva")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reserva extends BaseEntity  {

    private int numeroReserva;

    @ManyToOne
    @JoinColumn(name = "vuelo_id")
    private Vuelo vuelo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "pago_id", nullable = false)
    private Pago pago;

}
