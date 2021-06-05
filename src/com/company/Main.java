package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Administrador admin = new Administrador();
        Conserje conserje = new Conserje("dan", "sua", "33", "123", "45");
        Conserje conserje2 = new Conserje("dan2", "sua", "33", "1234", "56");
        Habitacion habi = new Habitacion("21", "12", "doble", 333.45, EstadoHabitacion.LIBRE);


        //Hotel.getUsuarioList().add(conserje);
        //Hotel.getUsuarioList().add(conserje2);

        //admin.guardarListaUsuarioArchivo();

        admin.cargarListaUsuarioArchivo();


        //Hotel.getHabitacionList().add(habi);

        //admin.guardarListaHabitacionArchivo();


        admin.cargarListaHabitacionArchivo();

        System.out.println(Hotel.getHabitacionList());



        //menu();
    }

    public static void modificarPasajero(Pasajero pasajero){

        int com;
        Scanner scanner = new Scanner(System.in);

        do{

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

            switch (com){

                case 1:
                    System.out.println("Ingrese nuevo nombre: ");
                    pasajero.setNombre(scanner.nextLine());
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    break;

                case 7:
                    break;

                case 8:
                    break;

                case 9:
                    break;

                case 0:
                    break;

                default:
            }



        }while(com != 0);

    }

    public static void menu() {

        Scanner scanner = new Scanner(System.in);
        int com;

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
                            }while(com != 0);
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
