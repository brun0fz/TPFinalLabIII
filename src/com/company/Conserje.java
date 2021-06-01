package com.company;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Conserje extends Usuario implements Descuento {


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

    public void mostrarHabitaciones(){
        for(Habitacion habitacion : Hotel.getHabitacionList()){
            System.out.println(habitacion);
        }
    }

    public void mostrarHabitacionesEstado(String estado){
        for(Habitacion habitacion : Hotel.getHabitacionList()){
            if(habitacion.getEstado().equals(estado)){
                System.out.println(habitacion);
            }
        }
    }


    public void mostrarHabitacionesTipo(String tipo){
        for(Habitacion habitacion : Hotel.getHabitacionList()){
            if(habitacion.getTipo().equals(tipo)){
                System.out.println(habitacion);
            }
        }
    }

    public Pasajero buscarPasajeros(String user) {
        for (Usuario usuario : Hotel.getUsuarioList()) {
            if (usuario instanceof Pasajero && usuario.getUsuario().equals(user)) {
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

        String com = "s";

        Habitacion habitacion;
        System.out.print("Tiene una reserva? [s/n]: ");
        com = scanner.nextLine();

        if (com.equals("s")) {
            Reserva reserva;
            String dni;

            while (com.equals("s")) {

                System.out.print("Ingrese numero de DNI del pasajero: ");
                dni = scanner.nextLine();

                reserva = buscarReservaPasajero(dni);

                if (reserva != null) {

                    habitacion = reserva.getHabitacion();

                    System.out.println("Se le asigno la habitacion nro: " + habitacion.getNumero());

                    habitacion.setPasajero(reserva.getPasajero());
                    habitacion.setCheckIn(LocalDate.now());
                    habitacion.setEstado(EstadoHabitacion.OCUPADA);
                    habitacion.setCheckOut(null);

                    reserva.setActivo(false);

                } else {
                    System.out.print("No se encontro la reserva. Desea buscar otra vez? [s/n]: ");
                    com = scanner.nextLine();
                }
            }

        } else {

            com = "s";
            while (com.equals("s")) {

                System.out.print("Ingrese tipo de habitacion: ");
                String tipoHabit = scanner.nextLine(); ///hacer un swtich con los tipos de habitacion

                habitacion = buscarHabitacionDisponible(tipoHabit);

                if (habitacion != null) {
                    com = "n";

                    System.out.println("Se le asigno la habitacion nro: " + habitacion.getNumero());

                    System.out.print("Ingrese el usuario del pasajero: ");

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

                } else {
                    System.out.println("No hay habitaciones disponibles del tipo: " + tipoHabit + "Desea buscar habitaciones de otro tipo?: [s/n]");
                    com = scanner.nextLine();
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
        String com = "s";

        Scanner scanner = new Scanner(System.in);

        while (com.equals("s")) {
            System.out.println("Ingrese DNI del pasajero: ");

            String dni = scanner.nextLine();

            Habitacion habitacion = buscarHabitacionPasajero(dni);

            if (habitacion != null) {
                com = "n";

                habitacion.setCheckOut(LocalDate.now());

                total = habitacion.calcularPrecioConsumos() + calcularPrecioDias(habitacion, habitacion.getCheckIn(), habitacion.getCheckOut());

                habitacion.setCheckIn(null);
                habitacion.setEstado(EstadoHabitacion.LIBRE);
                habitacion.setPasajero(null);
                habitacion.setConsumoList(null);

                System.out.println("Usted debe pagar:" + total);

            } else {

                System.out.print("No se ha encontrado una habitacion con ese pasajero. Desea volver a buscar? [s/n]: ");
                com = scanner.nextLine();
            }
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

                LocalDate fechaOut = LocalDate.of(anio, mes, dia);

                Reserva reserva = new Reserva(habitacion, pasajero, fechaIn, fechaOut, calcularPrecioDias(habitacion, fechaIn, fechaOut));

                Hotel.getReservaList().add(reserva);
            }
        }
    }


    @Override
    public String toString() {
        return "Conserje{}" + super.toString();
    }
}




