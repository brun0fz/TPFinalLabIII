package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Administrador admin = new Administrador("Bruno", "Fabrizio", "39123123", "Bruno", "1234");

        Conserje conserje = new Conserje("dan", "sua", "33", "123", "45");
        //Pasajero pasajero = new Pasajero("Danilo","Suarez","33102857","danilo","1234","Funes 2461","2236688139","danilomdq@gmail.com");

        Habitacion habi = new Habitacion("21", "12", TipoDeHabitacion.QUEEN, 333.45, EstadoHabitacion.LIBRE);
        Habitacion habi1 = new Habitacion("12", "115", TipoDeHabitacion.TRIPLE, 333.45, EstadoHabitacion.LIBRE);
        Habitacion habi2 = new Habitacion("9", "3", TipoDeHabitacion.QUEEN, 333.45, EstadoHabitacion.LIBRE);


       /* Hotel.getUsuarioList().add(admin);

        Hotel.getHabitacionList().add(habi);
        Hotel.getHabitacionList().add(habi1);
        Hotel.getHabitacionList().add(habi2);
        Hotel.getUsuarioList().add(conserje);
        //admin.guardarListaUsuarioArchivo();
        //admin.guardarListaHabitacionArchivo();
        admin.cargarListaUsuarioArchivo();


        //Hotel.getHabitacionList().add(habi);

        //admin.guardarListaHabitacionArchivo();


        admin.cargarListaHabitacionArchivo();


        // System.out.println(Hotel.getHabitacionList());*/


        menu();
    }


    public static void menu() {

        Scanner scanner = new Scanner(System.in);
        int com;

        Habitacion habitacion = null;
        Conserje conserje = null;
        Administrador admin = null;
        Pasajero pasajero = null;

        do {

            System.out.println("Hotel");

            System.out.println("1. Iniciar sesion");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");

            com = scanner.nextInt();

            switch (com) {

                ///Iniciar sesion
                case 1:
                    System.out.println("inicio de sesion");

                    Usuario user = Hotel.inicioDeSesion();


                    if (user != null) {
                        if (user instanceof Conserje) {
                            com = 1;
                            conserje = (Conserje) user;

                        } else if (user instanceof Administrador) {
                            com = 2;
                            admin = (Administrador) user;

                        } else {
                            pasajero = (Pasajero) user;
                            com = 3;
                        }

                    } else {

                        System.out.println("No se econtro al usuario.");
                        com = 4;

                    }

                    switch (com) {

                        ///menu conserje
                        case 1:
                            do {
                                System.out.println("Menu Conserje");
                                System.out.println("1. Realizar CheckIn");
                                System.out.println("2. Realizar CheckOut");
                                System.out.println("3. Realizar Reserva");
                                System.out.println("4. Buscar Pasajeros");
                                System.out.println("5. Buscar habitaciones");
                                System.out.println("0. Salir");

                                com = scanner.nextInt();

                                switch (com) {

                                    ///CheckIn
                                    case 1:
                                        conserje.checkIn();
                                        break;

                                    //CheckOut
                                    case 2:
                                        conserje.checkOut();
                                        break;

                                    ///Reservar
                                    case 3:
                                        conserje.reservar();
                                        break;

                                    case 4:
                                        System.out.println("Ingrese Usuario");
                                        String userPasajero = scanner.nextLine();
                                        System.out.println(conserje.buscarPasajeros(userPasajero));
                                        break;

                                    case 5:
                                        //swtich de opciones
                                        break;
                                }
                            } while (com != 0);
                            break;

                        //Menu admin
                        case 2:
                            do {
                                System.out.println("Menu Administrador");
                                System.out.println("1. Realizar CheckIn");
                                System.out.println("2. Realizar CheckOut");
                                System.out.println("3. Realizar Reserva");
                                System.out.println("4. Buscar Pasajeros");
                                System.out.println("5. Buscar habitacione disponible");
                                System.out.println("6. Crear Usuario");
                                System.out.println("7. Asignar Permisos");
                                System.out.println("8. Realizar Back-Up");
                                System.out.println("0. Salir");

                                com = scanner.nextInt();

                                switch (com) {
                                    //Realizar CheckIn
                                    case 1:
                                        admin.checkIn();
                                        break;
                                    //Realizar CheckOut
                                    case 2:
                                        admin.checkOut();
                                        break;
                                    //Realizar Reserva
                                    case 3:
                                        admin.reservar();
                                        break;
                                    //Buscar Pasajeros
                                    case 4:
                                        String dni;

                                        System.out.println("Ingrese dni");
                                        dni = scanner.nextLine();

                                        pasajero = admin.buscarPasajerosDni(dni);

                                        System.out.println(pasajero.toString());
                                        break;
                                    //Buscar habitacione disponible
                                    case 5:

                                        do {
                                            System.out.println("Tipos de habitaciones");
                                            System.out.println("1. Individual");
                                            System.out.println("2. Doble");
                                            System.out.println("3. Triple");
                                            System.out.println("4. Queen");

                                            com = scanner.nextInt();

                                            switch (com) {
                                                //INDIVIDUAL
                                                case 1:
                                                    System.out.println(admin.buscarHabitacionDisponible(TipoDeHabitacion.INDIVIDUAL));

                                                    break;
                                                //Doble
                                                case 2:
                                                    System.out.println(admin.buscarHabitacionDisponible(TipoDeHabitacion.DOBLE));
                                                    break;
                                                //Triple
                                                case 3:
                                                    System.out.println(admin.buscarHabitacionDisponible(TipoDeHabitacion.TRIPLE));
                                                    break;
                                                //Queen
                                                case 4:
                                                    System.out.println(admin.buscarHabitacionDisponible(TipoDeHabitacion.QUEEN));
                                                    break;
                                            }

                                        } while (com != 0);
                                        break;

                                    //Crear Usuario
                                    case 6:
                                        do {
                                            System.out.println("Que tipo de usuario desea crear: ");
                                            System.out.println("1. Pasajero");
                                            System.out.println("2. Conserje");
                                            System.out.println("3. Administrador");
                                            System.out.println("0. Salir");

                                            com = scanner.nextInt();
                                            switch (com) {
                                                //Pasajer
                                                case 1:
                                                    admin.crearPasajero();
                                                    break;
                                                //Conserje
                                                case 2:
                                                    admin.crearConserje();
                                                    break;
                                                //Administrador
                                                case 3:
                                                    admin.crearAdministrador();
                                                    break;
                                            }

                                        } while (com != 0);
                                        break;
                                    //Asignar Permisos
                                    case 7:
                                        break;
                                    //Realizar Back-Up
                                    case 8:
                                        admin.guardarListaUsuarioArchivo();
                                        admin.guardarListaHabitacionArchivo();
                                        admin.guardarListaReservaArchivo();

                                        System.out.println("Realizando Back-Up");
                                        break;
                                }
                            } while (com != 0);
                            break;

                        //Menu Pasajero
                        case 3:
                            do {
                                System.out.println("Menu Pasajero");
                                System.out.println("1. Realizar CheckIn");
                                System.out.println("2. Realizar CheckOut");
                                System.out.println("3. Realizar Reserva");
                                System.out.println("4. Buscar Pasajeros");
                                System.out.println("5. Buscar habitaciones");
                                System.out.println("0. Salir");

                                com = scanner.nextInt();

                                switch (com) {

                                    case 1:
                                        break;

                                    case 2:
                                        break;

                                    case 3:
                                        break;

                                    case 4:
                                        break;

                                    case 5:
                                        break;
                                }
                            } while (com != 0);
                            break;

                        case 4:
                            break;
                    }

                    break;
                case 2:

                    System.out.println("Registrarse");
                    Hotel.registroPasajero();


                    break;
                case 3:


                    break;

                default:

            }

        } while (com != 3);


    }
}
