package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Habitacion {

    private String piso;
    private String numero;
    private String tipo;
    private Double precio;
    private LocalDate checkIn;
    private LocalDate checkOut;

    private List<Consumo> consumoList = new ArrayList<>();
    private Double precioConsumos;
    private Pasajero pasajero;

    private String Estado;

    public Habitacion(String piso, String numero, String tipo, Double precio, String estado) {
        this.piso = piso;
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        Estado = estado;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public List<Consumo> getConsumoList() {
        return consumoList;
    }

    public void setConsumoList(List<Consumo> consumoList) {
        this.consumoList = consumoList;
    }

    public Double getPrecioConsumos() {
        return precioConsumos;
    }

    public void setPrecioConsumos(Double precioConsumos) {
        this.precioConsumos = precioConsumos;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
