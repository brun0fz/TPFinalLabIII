package com.company;

public class Producto {

    private NombreProducto nombre;
    private double precio;

    public Producto() {
    }

    public Producto(NombreProducto nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public NombreProducto getNombre() {
        return nombre;
    }

    public void setNombre(NombreProducto nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
