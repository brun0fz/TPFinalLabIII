package com.company;

import java.time.LocalDate;


public class Reserva {

    private Habitacion habitacion;
    private Pasajero pasajero;
    private LocalDate fechaIn;
    private LocalDate fechaOut;
    private Double precio;


    public Reserva() {
    }

    public Reserva(Habitacion habitacion, Pasajero pasajero, LocalDate fechaIn, LocalDate fechaOut, Double precio) {
        this.habitacion = habitacion;
        this.pasajero = pasajero;
        this.fechaIn = fechaIn;
        this.fechaOut = fechaOut;
        this.precio = precio;
    }



}
