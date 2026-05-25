package com.sistema.vuelo.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "aeropuerto")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aeropuerto extends BaseEntity {

    @Column(name = "nombre_aeropuerto")
    private String nombreAeropuerto;

    @ManyToOne
    @JoinColumn(name= "ciudad_id")
    private Ciudad ciudad;


}
