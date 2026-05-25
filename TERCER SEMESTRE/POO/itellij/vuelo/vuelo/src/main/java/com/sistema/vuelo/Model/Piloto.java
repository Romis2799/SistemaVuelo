package com.sistema.vuelo.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "Piloto")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Piloto extends Persona  {

    @Column(name = "nro_piloto")
    private int numeroPiloto;

}
