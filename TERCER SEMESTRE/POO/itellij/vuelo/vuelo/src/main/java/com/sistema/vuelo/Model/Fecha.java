package com.sistema.vuelo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "fecha")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Fecha extends BaseEntity{

    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

}

