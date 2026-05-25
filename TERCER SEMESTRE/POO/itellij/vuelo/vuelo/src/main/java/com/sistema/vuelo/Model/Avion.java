package com.sistema.vuelo.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table (name = "Avion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Avion extends BaseEntity implements Especificacion{

    @Column (name= "tipo_turbina")
    private String tipoTurbina;

    @Column (name = "tipo_avion")
    private String tipoAvion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn (name = "avion_id")
    private List<Asiento> asientos = new ArrayList<>();


    @Override
    public String getTipoTurbina() {
        return tipoTurbina;
    }

    @Override
    public String getTipoAvion() {
        return tipoAvion;
    }
}
