package com.sistema.vuelo.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tarifa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tarifa extends BaseEntity {

    @Column(name= "impuesto_tarifa")
    private int impuestoTarifa;

    @Column (name = "precio_tarifa")
    private int precioTarifa;

    @Enumerated(EnumType.STRING)
    @Column (name = "clase_tarifa")
    private Clase claseTarifa;



}
