package com.sistema.vuelo.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pago")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Pago extends BaseEntity {

    @Column(name = "nro_pago")
    private Long nroPago;

    @Column (name = "cantidad_pago")
    private int cantidadPago;

}
