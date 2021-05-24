package com.company;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conserje extends Usuario {

    public Conserje() {
    }

    public Conserje(String nombre, String apellido, String dni, String usuario, String constrasena) {
        super(nombre, apellido, dni, usuario, constrasena);
    }

    public Habitacion buscarHabitacionDisponible(String tipo) {

        for (Habitacion habitacion : Hotel.getHabitacionList()) {
            if (habitacion.getTipo() == tipo) {
                if (habitacion.getEstado() == EstadoHabitacion.LIBRE) {
                    return habitacion;
                }
            }
        }
        return null;
    }

    public Pasajero buscarPasajeros(String user) {

        for (Usuario usuario : Hotel.getUsuarioList()) {
            if (usuario.getUsuario() == user) {
                return (Pasajero) usuario;
            }
        }

        return null;
    }

    public Pasajero crearPasajero() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese DNI: ");
        String dni = scanner.nextLine();
        System.out.print("Ingrese usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Ingrese contraseña: ");
        String contrasena = scanner.nextLine();
        System.out.print("Ingrese direccion: ");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese telefono: ");
        String telefono = scanner.nextLine();
        System.out.print("Ingrese mail: ");
        String mail = scanner.nextLine();

        Pasajero nuevoPasajero = new Pasajero(nombre, apellido, dni, usuario, contrasena, direccion, telefono, mail);

        return nuevoPasajero;
    }


    public void checkIn() {

        Scanner scanner = new Scanner(System.in);

        String com = "s";

        Habitacion habitacion = null;

        while (com == "s") {
            System.out.print("Ingrese tipo de habitacion: ");
            String tipoHabit = scanner.nextLine(); ///Solucionar

            habitacion = buscarHabitacionDisponible(tipoHabit);

            if (habitacion == null) {
                System.out.println("No hay habitaciones disponibles del tipo: " + tipoHabit + "Desea buscar habitaciones de otro tipo?: [s/n]");
                com = scanner.nextLine();

            } else {
                com = "n";

                System.out.println("Se le asigno la habitacion nro: " + habitacion.getNumero());

                System.out.println("Ingrese el usuario del pasajero: ");

                String usuario = scanner.nextLine();

                Pasajero pasajero = buscarPasajeros(usuario);

                if (pasajero == null) {
                    pasajero = crearPasajero();
                    Hotel.getUsuarioList().add(pasajero);
                }

                habitacion.setPasajero(pasajero);
                habitacion.setCheckIn(LocalDate.now());
                habitacion.setEstado(EstadoHabitacion.OCUPADA);
                habitacion.setCheckOut(null);


            }
        }
    }

    public Habitacion buscarHabitacionPasajero(String dni) {

        for (Habitacion habitacion : Hotel.getHabitacionList()) {
            if (habitacion.getPasajero().getDni() == dni) {
                return habitacion;
            }
        }
        return null;
    }

    public int calcularTotalDias(Habitacion habitacion) {

        Period period = Period.between(habitacion.getCheckIn(), habitacion.getCheckOut());

        return period.getDays();

    }

    public double calcularPrecioDias(Habitacion habitacion){
        return habitacion.getPrecio()*calcularTotalDias(habitacion);

    }

    public void checkOut() {

        double total=0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese DNI: ");

        String dni = scanner.nextLine();
        Habitacion habitacion = buscarHabitacionPasajero(dni);

        if (habitacion != null) {

            habitacion.setCheckOut(LocalDate.now());

           total = habitacion.calcularPrecioConsumos()+calcularPrecioDias(habitacion);

            habitacion.setCheckIn(null);
            habitacion.setEstado(EstadoHabitacion.LIBRE);
            habitacion.setPasajero(null);
            habitacion.setConsumoList(null);

        }

    }
}




