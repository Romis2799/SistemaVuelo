package com.sistema.vuelo.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Aeropuerto")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aeropuerto extends BaseEntity {

    @Column(name = "nombre_aerouerto")
    private String nombreAeroperto;

    @ManyToOne
    @JoinColumn(name= "cuidad_id")
    private Cuidad cuidad;


}
