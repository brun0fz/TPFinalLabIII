package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Habitacion {

    private String piso;
    private String numero;
    private TipoDeHabitacion tipo;
    private Double precio;

    private Pasajero pasajero;

    private LocalDate checkIn;
    private LocalDate checkOut;
    private EstadoHabitacion Estado;

    private List<Producto> consumoList = new ArrayList<>();

    public Habitacion() {
    }


    public Habitacion(String piso, String numero, TipoDeHabitacion tipo, Double precio, EstadoHabitacion estado) {
        this.piso = piso;
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.Estado = estado;
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

    public TipoDeHabitacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeHabitacion tipo) {
        this.tipo = tipo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
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

    public EstadoHabitacion getEstado() {
        return Estado;
    }

    public void setEstado(EstadoHabitacion estado) {
        Estado = estado;
    }

    public List<Producto> getConsumoList() {
        return consumoList;
    }

    public void setConsumoList(List<Producto> consumoList) {
        this.consumoList = consumoList;
    }



    public double calcularPrecioConsumos(){

        double total=0;

        for (Producto producto:consumoList){
            total+=producto.getPrecio();
        }
        return total;
    }


    @Override
    public String toString() {
        return "Habitacion:\n\n" +
                "Piso.........." + piso + "\n" +
                "Numero........" + numero + "\n" +
                "Tipo.........." + tipo + "\n" +
                "Precio........" + precio +"\n"+
                "Pasajero......" + pasajero +"\n"+
                "CheckIn......." + checkIn+"\n" +
                "CheckOut......" + checkOut+"\n" +
                "Estado........" + Estado +"\n" +
                "Consumos......" + consumoList ;
    }
}
