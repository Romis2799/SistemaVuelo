package com.sistema.vuelo.Dto;


import com.sistema.vuelo.Model.Ciudad;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDetalleDto {



    //datos que necesito del usuario
    private int dni;
    private String nombre;
    private String apellido;


    //datos de la reserva
    private int numeroReserva;

    //datos del vuelo
    private int numeroVuelo;
    private String aerolinea;

    //datos de la tarifa
    private String claseTarifa;
    private int precioTarifa;

    //datos del aeropuerto y cuidad
    private String nombreAeropuerto;
    private String ciudad;

    //datos del asiento
    private int numeroAsiento;
    private char letraAsiento;

    //datos del avion
    private Long numeroAvion;
    private String tipoTurbina;

    //datos de la fecha
    private String fechaVuelo;

    //datos de la tarjeta
    private int numeroTarjeta;
    private String tipoTarjeta;


    // datos del pago
    private int numeroPago;




}
