package com.sistema.vuelo.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "Vuelo")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vuelo extends BaseEntity{

    @Column( name = "numero_vuelo")
    private int numeroVuelo;

    @ManyToOne
    @JoinColumn (name = "fecha_id")
    private Fecha fecha;

    @ManyToOne
    @JoinColumn (name= "piloto_id")
    private Piloto piloto;

    @ManyToOne (optional = false)
    @JoinColumn (name = "aerolinea_id", nullable = false)
    private Aerolinea aerolinea;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable ( name = "vuelo_aeropuerto",
                 joinColumns = @JoinColumn (name = "vuelo_id"),
                inverseJoinColumns = @JoinColumn(name = "aeropuerto_id"))
    private List<Aeropuerto> aeropuertos = new ArrayList<>();

    @ManyToMany
    @JoinTable ( name = "vuelo_tarifa",
            joinColumns = @JoinColumn (name = "vuelo_id"),
            inverseJoinColumns = @JoinColumn(name = "tarifa_id"))
    private List <Tarifa> tarifas = new ArrayList<>();


}
