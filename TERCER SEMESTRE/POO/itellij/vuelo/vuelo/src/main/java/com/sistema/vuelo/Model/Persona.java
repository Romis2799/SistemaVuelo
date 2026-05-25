package com.sistema.vuelo.Model;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Persona extends BaseEntity {

    @Column(name= "nombre_persona")
    protected String nombre;

    @Column(name = "apellido_persona")
    protected String apellido;

    @Column(name = "dni_persona")
    protected int dni;

    
}
