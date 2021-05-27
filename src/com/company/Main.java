package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {



        menu();

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


                    if(user != null)
                    {
                        if ( user instanceof Conserje) {
                            com = 1;
                            conserje = (Conserje) user;

                        } else if (user instanceof Administrador) {
                            com = 2;
                            admin = (Administrador) user;

                        } else {
                            pasajero = (Pasajero) user;
                            com = 3;
                        }
                    }else{

                        System.out.println("No se econtro al usuario.");
                        com = 4;

                    }

                    switch (com){

                        ///menu conserje
                        case 1:
                            do {
                                System.out.println("Menu Conserje");
                                System.out.println("1. Buscar Pasajeros");
                                System.out.println("x. Salir");

                                com = scanner.nextInt();

                                switch (com){

                                    ///Buscar pasajeros
                                    case 1:

                                        System.out.println("Ingrese Usuario");
                                        String userPasajero = scanner.nextLine();

                                        System.out.println(conserje.buscarPasajeros(userPasajero));

                                        break;
                                }
                            }while(com != 5);
                            break;

                            //Menu admin
                        case 2:
                            break;

                            //Menu Pasajero
                        case 3:

                            System.out.println("anduvo");
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
