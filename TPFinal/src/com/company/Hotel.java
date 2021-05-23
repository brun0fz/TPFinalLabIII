package com.company;

import java.util.ArrayList;
import java.util.List;

public final class Hotel {

    private static String nombre;
    private static String direccion;

    private static List<Usuario> usuarioList = new ArrayList<>();

    private static List<Habitacion> habitacionList = new ArrayList<>();

    private static List<Reserva> reservaList = new ArrayList<>();

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        Hotel.nombre = nombre;
    }

    public static String getDireccion() {
        return direccion;
    }

    public static void setDireccion(String direccion) {
        Hotel.direccion = direccion;
    }

    public static List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public static void setUsuarioList(List<Usuario> usuarioList) {
        Hotel.usuarioList = usuarioList;
    }

    public static List<Habitacion> getHabitacionList() {
        return habitacionList;
    }

    public static void setHabitacionList(List<Habitacion> habitacionList) {
        Hotel.habitacionList = habitacionList;
    }

    public static List<Reserva> getReservaList() {
        return reservaList;
    }

    public static void setReservaList(List<Reserva> reservaList) {
        Hotel.reservaList = reservaList;
    }

}
