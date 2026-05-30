package com.sistema.vuelo.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaDetalleDto {

    //datos que necesito del usuario

    private int dni;
    private String nombre;
    private String apellido;

    //datos que necesito de la consulta

    private int numeroConsulta;

    //datos que necesito del vuelo

    private int numeroVuelo;
    private String aerolinea;

    //datos que necesito de la tarifa

    private int precioTarifa;
    private String claseTarifa;

    //datos que necesito del aeropuerto y cuidad de destino

    private String nombreAeropuerto;
    private String cuidad;

    //datos del asiento
    private String claseAsiento;

    //datos del piloto

    private int dniP;
    private String nombreP;
    private String apellidoP;
    private int numeroPiloto;

    //fecha
    private String fechaVuelo;



}
