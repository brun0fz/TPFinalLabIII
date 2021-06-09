package com.company;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.time.LocalDate;
import java.util.Scanner;


public class Pasajero extends Usuario {

    private String direccion;
    private String telefono;
    private String email;
    private Reserva reserva = null;

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


    public void modificarPasajero(Pasajero pasajero) {

        int com;
        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println("Modificar Pasajero");

            System.out.println(pasajero);

            System.out.println("1. Nombre");
            System.out.println("2. Apellido");
            System.out.println("3. DNI");
            System.out.println("4. Usuario");
            System.out.println("5. Contraseña");
            System.out.println("6. Direccion");
            System.out.println("7. Telefono");
            System.out.println("8. Email");
            System.out.println("0. Salir");

            com = scanner.nextInt();

            scanner.nextLine();

            switch (com) {

                case 1:
                    System.out.println("Ingrese nuevo nombre: ");
                    pasajero.setNombre(scanner.nextLine());
                    break;

                case 2:
                    System.out.println("Ingrese nuevo apellido");
                    pasajero.setApellido(scanner.nextLine());
                    break;

                case 3:
                    System.out.println("Ingrese nuevo dni");
                    pasajero.setDni(scanner.nextLine());
                    break;

                case 4:
                    System.out.println("Ingrese nuevo usuario");
                    pasajero.setUsuario(scanner.nextLine());
                    break;

                case 5:
                    System.out.println("Ingrese nueva contraseña");
                    pasajero.setConstrasena(scanner.nextLine());
                    break;

                case 6:
                    System.out.println("Ingrese nuevo direccion");
                    pasajero.setDireccion(scanner.nextLine());
                    break;

                case 7:
                    System.out.println("Ingrese nuevo telefono");
                    pasajero.setTelefono(scanner.nextLine());
                    break;

                case 8:
                    System.out.println("Ingrese nuevo email");
                    pasajero.setEmail(scanner.nextLine());
                    break;

            }


        } while (com != 0);
    }


    public Habitacion buscarMiHabitacion() {
        for (Habitacion habitacion : Hotel.getHabitacionList()) {
            if (habitacion.getPasajero() != null && habitacion.getPasajero().getDni().equals(this.getDni())) {
                return habitacion;
            }
        }
        return null;
    }

    public void realizarConsumo() {

        Scanner scanner = new Scanner(System.in);
        Habitacion habitacion = buscarMiHabitacion();

        int com;

        if(habitacion != null) {


            do {

                System.out.println("MINI BAR");

                System.out.println("Elija el producto");

                System.out.println("1. Coca cola");
                System.out.println("2. Agua mineral");
                System.out.println("3. Sandwich de miga");
                System.out.println("\n0. Salir");

                com = scanner.nextInt();

                switch (com) {
                    case 1:
                        System.out.println("Coca cola!");
                        habitacion.getConsumoList().add(Hotel.getMiniBar().get(0));
                        break;

                    case 2:
                        habitacion.getConsumoList().add(Hotel.getMiniBar().get(1));
                        break;

                    case 3:
                        habitacion.getConsumoList().add(Hotel.getMiniBar().get(2));
                        break;

                    case 0:
                        break;

                }

            } while (com != 0);

        }else{
            System.out.println("Usted no se encuentra en ninguna habitacion.");
        }

    }

    public void reservaRemota(Pasajero pasajero) {

        Scanner scanner = new Scanner(System.in);
        Conserje conserje = new Conserje();

        String com = "s";

        Habitacion habitacion = new Habitacion();

        while (com.equals("s")) {
            int opt;

            do {
                System.out.println("Reserva\n");
                System.out.println("Seleccione el Tipo de habitacion");
                System.out.println("1. Individual");
                System.out.println("2. Doble");
                System.out.println("3. Triple");
                System.out.println("4. Queen");

                opt = scanner.nextInt();

                switch (opt) {
                    //INDIVIDUAL
                    case 1:
                        habitacion = conserje.buscarHabitacionDisponible(TipoDeHabitacion.INDIVIDUAL);
                        break;
                    //Doble
                    case 2:
                        habitacion = conserje.buscarHabitacionDisponible(TipoDeHabitacion.DOBLE);
                        break;
                    //Triple
                    case 3:
                        habitacion = conserje.buscarHabitacionDisponible(TipoDeHabitacion.TRIPLE);
                        break;
                    //Queen
                    case 4:
                        habitacion = conserje.buscarHabitacionDisponible(TipoDeHabitacion.QUEEN);
                        break;
                }

            } while (opt != 0);

            if (habitacion == null) {
                System.out.println("No hay habitaciones disponibles de ese tipo, esea buscar habitaciones de otro tipo?: [s/n]");
                com = scanner.nextLine();

            } else {
                com = "n";

                System.out.println("Se le asigno la habitacion nro: " + habitacion.getNumero());

                habitacion.setPasajero(pasajero);
                habitacion.setEstado(EstadoHabitacion.RESERVADA);
                habitacion.setCheckOut(null);

                int anio, mes, dia;

                System.out.println("Ingrese fecha de entrada: ");
                System.out.print("Año: ");
                anio = scanner.nextInt();
                System.out.print("Mes: ");
                mes = scanner.nextInt();
                System.out.print("Dia: ");
                dia = scanner.nextInt();

                LocalDate fechaIn = LocalDate.of(anio, mes, dia);

                System.out.println("Ingrese fecha de salida: ");
                System.out.print("Año: ");
                anio = scanner.nextInt();
                System.out.print("Mes: ");
                mes = scanner.nextInt();
                System.out.print("Dia: ");
                dia = scanner.nextInt();

                LocalDate fechaOut = LocalDate.of(anio, mes, dia);

                Reserva reserva = new Reserva(habitacion, pasajero, fechaIn, fechaOut, conserje.calcularPrecioDias(habitacion, fechaIn, fechaOut));

                Hotel.getReservaList().add(reserva);

                System.out.println("La reserva se ha realizado exitosamente!");
            }
        }
    }



    @Override
    public String toString() {
        return super.toString() +
                "Direccion........" + direccion + "\n" +
                "Telefono........." + telefono + "\n" +
                "Email............" + email + "\n" +
                "Reserva.........." + reserva;
    }
}
