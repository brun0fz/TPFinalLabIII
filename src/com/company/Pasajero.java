package com.company;

public class Pasajero extends Usuario{

    private String direccion;
    private String telefono;
    private String email;
    private Reserva reserva=null;

    public Pasajero() {
    }

    public Pasajero(String nombre, String apellido, String dni, String usuario, String constrasena, String direccion, String telefono, String email) {
        super(nombre, apellido, dni, usuario, constrasena);
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Pasajero{" +
                "direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", reserva=" + reserva +
                '}';
    }
}
