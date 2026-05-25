package com.sistema.vuelo.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "consulta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Consulta extends BaseEntity{

    @Column (name = "numero_consulta")
    private int numeroConsulta;

    @ManyToOne
    @JoinColumn(name = "vuelo_id")
    private Vuelo vuelo;

    @ManyToOne(optional = false)
    @JoinColumn (name = "usuario_id", nullable = false)
    private Usuario usuario;





}
