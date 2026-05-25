package com.sistema.vuelo.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Cuidad")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cuidad extends BaseEntity{

    @Column (name = "nombre_cuidad" )
    private String nombreCuidad;

}
