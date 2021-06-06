package com.company;

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


    @Override
    public String toString() {
        return super.toString() +
                "Direccion........" + direccion + "\n" +
                "Telefono........." + telefono + "\n" +
                "Email............" + email + "\n" +
                "Reserva.........." + reserva;
    }
}
