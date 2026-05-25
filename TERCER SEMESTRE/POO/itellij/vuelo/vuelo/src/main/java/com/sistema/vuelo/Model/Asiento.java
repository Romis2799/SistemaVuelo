package com.sistema.vuelo.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "Asiento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Asiento extends BaseEntity{

    @Column(name = "fila_asiento")
    private int filaAsiento;

    @Column (name = "letra_asiento")
    private char letraAsiento;

    @Enumerated(EnumType.STRING)
    @Column(name = "clase_asiento")
    private Clase claseAsiento;

}
