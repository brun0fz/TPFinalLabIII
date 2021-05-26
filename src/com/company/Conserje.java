package com.company;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Conserje extends Usuario {

    public Conserje() {
    }

    public Conserje(String nombre, String apellido, String dni, String usuario, String constrasena) {
        super(nombre, apellido, dni, usuario, constrasena);
    }

    public Habitacion buscarHabitacionDisponible(String tipo) {

        for (Habitacion habitacion : Hotel.getHabitacionList()) {
            if (habitacion.getTipo().equals(tipo)) {
                if (habitacion.getEstado().equals(EstadoHabitacion.LIBRE)) {
                    return habitacion;
                }
            }
        }
        return null;
    }

    public Pasajero buscarPasajeros(String user) {

        for (Usuario usuario : Hotel.getUsuarioList()) {
            if (usuario.getUsuario().equals(user)) {
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

    ///revisar!
    public Reserva buscarReservaPasajero(String dni) {
        for (Reserva reserva : Hotel.getReservaList()) {
            if (reserva.getPasajero().getDni().equals(dni)) {
                return reserva;
            }
        }
        return null;
    }

    public void checkIn() {

        Scanner scanner = new Scanner(System.in);

        String com = "s", option;

        Habitacion habitacion;
        System.out.print("Tiene una reserva? ");
        option = scanner.nextLine();

        if (option.equals("s")) {
            Reserva reserva;
            Pasajero pasajero;
            String dni;

            System.out.print("Ingrese numero de DNI ");
            dni = scanner.nextLine();

            reserva = buscarReservaPasajero(dni);

            habitacion = reserva.getHabitacion();

            System.out.println("Se le asigno la habitacion nro: " + habitacion.getNumero());

            pasajero = buscarPasajeros(reserva.getPasajero().getUsuario());

            habitacion.setPasajero(pasajero);
            habitacion.setCheckIn(LocalDate.now());
            habitacion.setEstado(EstadoHabitacion.OCUPADA);
            habitacion.setCheckOut(null);

        } else {
            while (com.equals("s")) {
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
    }

    public Habitacion buscarHabitacionPasajero(String dni) {

        for (Habitacion habitacion : Hotel.getHabitacionList()) {
            if (habitacion.getPasajero().getDni().equals(dni)) {
                return habitacion;
            }
        }
        return null;
    }

    public int calcularTotalDias(LocalDate desde, LocalDate hasta) {

        Period period = Period.between(desde, hasta);

        return period.getDays();

    }

    public double calcularPrecioDias(Habitacion habitacion, LocalDate desde, LocalDate hasta) {
        return habitacion.getPrecio() * calcularTotalDias(desde, hasta);

    }

    public void checkOut() {

        double total;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese DNI: ");

        String dni = scanner.nextLine();
        Habitacion habitacion = buscarHabitacionPasajero(dni);

        if (habitacion != null) {

            habitacion.setCheckOut(LocalDate.now());

            total = habitacion.calcularPrecioConsumos() + calcularPrecioDias(habitacion, habitacion.getCheckIn(), habitacion.getCheckOut());

            habitacion.setCheckIn(null);
            habitacion.setEstado(EstadoHabitacion.LIBRE);
            habitacion.setPasajero(null);
            habitacion.setConsumoList(null);

            System.out.println("Usted debe pagar:" + total);
        }

    }

    public void reservar() {

        Scanner scanner = new Scanner(System.in);

        String com = "s";

        Habitacion habitacion;

        while (com.equals("s")) {
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
                habitacion.setEstado(EstadoHabitacion.RESERVADA);
                habitacion.setCheckOut(null);

                int anio, mes, dia;

                System.out.println("ingrese fecha de entrada: ");
                System.out.print("Año: ");
                anio = scanner.nextInt();
                System.out.print("Mes: ");
                mes = scanner.nextInt();
                System.out.print("Dia: ");
                dia = scanner.nextInt();

                LocalDate fechaIn = LocalDate.of(anio, mes, dia);

                System.out.println("ingrese fecha de salida: ");
                System.out.print("Año: ");
                anio = scanner.nextInt();
                System.out.print("Mes: ");
                mes = scanner.nextInt();
                System.out.print("Dia: ");
                dia = scanner.nextInt();
                System.out.println("Hasta: ");

                LocalDate fechaOut = LocalDate.of(anio, mes, dia);

                Reserva reserva = new Reserva(habitacion, pasajero, fechaIn, fechaOut, calcularPrecioDias(habitacion, fechaIn, fechaOut));

                Hotel.getReservaList().add(reserva);
            }


        }
    }


}




