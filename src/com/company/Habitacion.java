package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Habitacion {

    private String piso;
    private String numero;
    private String tipo;
    private Double precio;

    private Pasajero pasajero;

    private LocalDate checkIn;
    private LocalDate checkOut;
    private String Estado;

    private List<Producto> consumoList = new ArrayList<>();

    public Habitacion() {
    }

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

    public List<Producto> getConsumoList() {
        return consumoList;
    }

    public void setConsumoList(List<Producto> consumoList) {
        this.consumoList = consumoList;
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


    public double calcularPrecioConsumos(){

        double total=0;

        for (Producto producto:consumoList){
            total+=producto.getPrecio();
        }
        return total;
    }
}
