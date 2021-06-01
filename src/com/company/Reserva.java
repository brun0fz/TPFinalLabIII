package com.company;

import java.time.LocalDate;


public class Reserva {

    private Habitacion habitacion;
    private Pasajero pasajero;
    private LocalDate fechaIn;
    private LocalDate fechaOut;
    private Double precio;

    private boolean activo;


    public Reserva() {
    }

    public Reserva(Habitacion habitacion, Pasajero pasajero, LocalDate fechaIn, LocalDate fechaOut, Double precio) {
        this.habitacion = habitacion;
        this.pasajero = pasajero;
        this.fechaIn = fechaIn;
        this.fechaOut = fechaOut;
        this.precio = precio;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public LocalDate getFechaIn() {
        return fechaIn;
    }

    public void setFechaIn(LocalDate fechaIn) {
        this.fechaIn = fechaIn;
    }

    public LocalDate getFechaOut() {
        return fechaOut;
    }

    public void setFechaOut(LocalDate fechaOut) {
        this.fechaOut = fechaOut;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean isActivo() {
        return activo;
    }
}
