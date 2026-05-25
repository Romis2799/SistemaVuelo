package com.sistema.vuelo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table (name = "Tarjeta")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tarjeta extends Pago {

    @Column (name = "nro_tarjeta")
    private int nroTarjeta;

    @Enumerated(EnumType.STRING)
    @Column (name = "tipo_tarjeta")
    private TipoTarjeta tipoTarjeta;
}
