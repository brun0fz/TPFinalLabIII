package com.company;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.awt.*;
import java.rmi.NotBoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Administrador admin = new Administrador("Bruno", "Fabrizio", "40579965", "brunofz", "1759");
        /* Administrador admin2 = new Administrador("Danilo", "Suarez", "33102857", "danilomdq", "2481");

        Conserje conserje = new Conserje("Ezequiel", "Rage", "27123123", "eze", "1234");
        Pasajero pasajero = new Pasajero("Carlos", "Miranda", "32123123", "charly", "1234", "Funes 2461", "2236688139", "charly@gmail.com");

        Habitacion habi = new Habitacion("1", "1", TipoDeHabitacion.INDIVIDUAL, 333.45, EstadoHabitacion.LIBRE);
        Habitacion habi1 = new Habitacion("1", "2", TipoDeHabitacion.INDIVIDUAL, 333.45, EstadoHabitacion.LIBRE);
        Habitacion habi2 = new Habitacion("1", "3", TipoDeHabitacion.INDIVIDUAL, 333.45, EstadoHabitacion.LIBRE);
        Habitacion habi3 = new Habitacion("1", "4", TipoDeHabitacion.INDIVIDUAL, 333.45, EstadoHabitacion.LIBRE);
        Habitacion habi13 = new Habitacion("2", "5", TipoDeHabitacion.TRIPLE, 900.3, EstadoHabitacion.LIBRE);
        Habitacion habi14 = new Habitacion("2", "6", TipoDeHabitacion.TRIPLE, 900.3, EstadoHabitacion.LIBRE);
        Habitacion habi15 = new Habitacion("2", "7", TipoDeHabitacion.TRIPLE, 900.3, EstadoHabitacion.LIBRE);
        Habitacion habi16 = new Habitacion("2", "8", TipoDeHabitacion.TRIPLE, 900.3, EstadoHabitacion.LIBRE);
        Habitacion habi27 = new Habitacion("3", "9", TipoDeHabitacion.QUEEN, 650.7, EstadoHabitacion.LIBRE);
        Habitacion habi24 = new Habitacion("3", "10", TipoDeHabitacion.QUEEN, 650.7, EstadoHabitacion.LIBRE);
        Habitacion habi23 = new Habitacion("3", "11", TipoDeHabitacion.QUEEN, 650.7, EstadoHabitacion.LIBRE);
        Habitacion habi21 = new Habitacion("3", "12", TipoDeHabitacion.QUEEN, 650.7, EstadoHabitacion.LIBRE);
        Habitacion habi28 = new Habitacion("3", "13", TipoDeHabitacion.QUEEN, 650.7, EstadoHabitacion.LIBRE);
        Habitacion habi29 = new Habitacion("4", "14", TipoDeHabitacion.DOBLE, 550.9, EstadoHabitacion.LIBRE);
        Habitacion habi30 = new Habitacion("4", "15", TipoDeHabitacion.DOBLE, 550.9, EstadoHabitacion.LIBRE);
        Habitacion habi31 = new Habitacion("4", "16", TipoDeHabitacion.DOBLE, 550.9, EstadoHabitacion.LIBRE);
        Habitacion habi33 = new Habitacion("4", "17", TipoDeHabitacion.DOBLE, 550.9, EstadoHabitacion.LIBRE);
        Hotel.getHabitacionList().add(habi);
        Hotel.getHabitacionList().add(habi1);
        Hotel.getHabitacionList().add(habi2);
        Hotel.getHabitacionList().add(habi3);
        Hotel.getHabitacionList().add(habi13);
        Hotel.getHabitacionList().add(habi14);
        Hotel.getHabitacionList().add(habi15);
        Hotel.getHabitacionList().add(habi16);
        Hotel.getHabitacionList().add(habi27);
        Hotel.getHabitacionList().add(habi24);
        Hotel.getHabitacionList().add(habi23);
        Hotel.getHabitacionList().add(habi21);
        Hotel.getHabitacionList().add(habi28);
        Hotel.getHabitacionList().add(habi29);
        Hotel.getHabitacionList().add(habi30);
        Hotel.getHabitacionList().add(habi31);
        Hotel.getHabitacionList().add(habi33);

        Producto cocaCola = new Producto(NombreProducto.COCA_COLA, 120);
        Producto agua = new Producto(NombreProducto.AGUA, 120);
        Producto sandwich = new Producto(NombreProducto.SANDWICH, 120);
        Producto oreo = new Producto(NombreProducto.OREO, 80);
        Producto havanna = new Producto(NombreProducto.HAVANNA, 98);
        Producto cerveza = new Producto(NombreProducto.CERVEZA, 135);
        Producto sonrisas = new Producto(NombreProducto.SONRISAS, 118);
        Producto sprite = new Producto(NombreProducto.SPRITE, 135);
        Producto soda = new Producto(NombreProducto.SODA, 135);
        Producto whisky = new Producto(NombreProducto.WHISKY, 135);
        Hotel.getMiniBar().add(cocaCola);
        Hotel.getMiniBar().add(agua);
        Hotel.getMiniBar().add(sandwich);
        Hotel.getMiniBar().add(oreo);
        Hotel.getMiniBar().add(havanna);
        Hotel.getMiniBar().add(cerveza);
        Hotel.getMiniBar().add(sonrisas);
        Hotel.getMiniBar().add(sprite);
        Hotel.getMiniBar().add(soda);
        Hotel.getMiniBar().add(whisky);


        Hotel.getUsuarioList().add(admin);
        Hotel.getUsuarioList().add(admin2);
        Hotel.getUsuarioList().add(conserje);
        Hotel.getUsuarioList().add(pasajero);


        admin.guardarListaUsuarioArchivo();
        admin.guardarMiniBarArchivo();
        admin.guardarListaHabitacionArchivo();


         */
        admin.cargarListaUsuarioArchivo();
        admin.cargarListaHabitacionArchivo();
        //admin.cargarListaReservaArchivo();
        admin.cargarMiniBarArchivo();


        sistemaHoteleria();
    }

    public static void sistemaHoteleria() {

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
                        if (user.getClass().equals(Conserje.class)) {
                            com = 1;
                            conserje = (Conserje) user;

                        } else if (user.getClass().equals(Administrador.class)) {
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
                                int com2;

                                System.out.println("Menu Conserje\n");
                                System.out.println("1. Realizar CheckIn");
                                System.out.println("2. Realizar CheckOut");
                                System.out.println("3. Realizar Reserva");
                                System.out.println("4. Buscar Pasajeros");
                                System.out.println("5. Mostrar habitaciones por tipo");
                                System.out.println("6. Mostrar habitaciones por estado");
                                System.out.println("7. Modificar mis datos");
                                System.out.println("\n0. Salir");

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
                                    //Buscar pasajeros
                                    case 4:


                                        do {
                                            System.out.println("Buscar pasajeros por:");
                                            System.out.println("1. Nombre");
                                            System.out.println("2. Apellido");
                                            System.out.println("3. Dni");
                                            System.out.println("4. Usuario");
                                            System.out.println("\n0. Salir");

                                            com2 = scanner.nextInt();

                                            switch (com2) {
                                                //Nombre
                                                case 1:
                                                    System.out.println("Ingrese el nombre:  ");
                                                    String nombre = scanner.next();
                                                    System.out.println(conserje.buscarPasajerosNombre(nombre));
                                                    break;
                                                //Apellido
                                                case 2:
                                                    System.out.println("Ingrese el apellido:  ");
                                                    String apellido = scanner.next();
                                                    System.out.println(conserje.buscarPasajerosApellido(apellido));
                                                    break;
                                                //Dni
                                                case 3:
                                                    System.out.print("Ingrese DNI: ");
                                                    String dni = scanner.next();
                                                    System.out.println(conserje.buscarPasajerosDni(dni));
                                                    break;
                                                //Usuario
                                                case 4:
                                                    System.out.println("Ingrese el usuario:  ");
                                                    String usuario = scanner.next();
                                                    System.out.println(conserje.buscarPasajerosUsuario(usuario));
                                                    break;
                                            }

                                        } while (com2 != 0);

                                        break;

                                    case 5:

                                        do {
                                            System.out.println("Tipos de habitaciones");
                                            System.out.println("1. Individual");
                                            System.out.println("2. Doble");
                                            System.out.println("3. Triple");
                                            System.out.println("4. Queen");
                                            System.out.println("\n0. Salir");

                                            com2 = scanner.nextInt();

                                            switch (com2) {
                                                //INDIVIDUAL
                                                case 1:
                                                    conserje.mostrarHabitacionesTipo(TipoDeHabitacion.INDIVIDUAL);
                                                    break;
                                                //Doble
                                                case 2:
                                                    conserje.mostrarHabitacionesTipo(TipoDeHabitacion.DOBLE);
                                                    break;
                                                //Triple
                                                case 3:
                                                    conserje.mostrarHabitacionesTipo(TipoDeHabitacion.TRIPLE);
                                                    break;
                                                //Queen
                                                case 4:
                                                    conserje.mostrarHabitacionesTipo(TipoDeHabitacion.QUEEN);
                                                    break;

                                                case 0:
                                                    break;
                                            }

                                        } while (com2 != 0);

                                        break;

                                    case 6:

                                        do {
                                            System.out.println("Estado de la habitacion: ");
                                            System.out.println("1. Libre");
                                            System.out.println("2. Ocupada");
                                            System.out.println("3. Reservada");
                                            System.out.println("4. En Limpieza");
                                            System.out.println("5. En Reparacion");
                                            System.out.println("\n0. Salir");


                                            com2 = scanner.nextInt();

                                            switch (com2) {

                                                case 1:
                                                    conserje.mostrarHabitacionesEstado(EstadoHabitacion.LIBRE);
                                                    break;

                                                case 2:
                                                    conserje.mostrarHabitacionesEstado(EstadoHabitacion.OCUPADA);
                                                    break;

                                                case 3:
                                                    conserje.mostrarHabitacionesEstado(EstadoHabitacion.RESERVADA);
                                                    break;

                                                case 4:
                                                    conserje.mostrarHabitacionesEstado(EstadoHabitacion.LIMPIEZA);
                                                    break;

                                                case 5:
                                                    conserje.mostrarHabitacionesEstado(EstadoHabitacion.REPARACION);
                                                    break;

                                                case 0:
                                                    break;
                                            }

                                        } while (com2 != 0);

                                        break;

                                    case 7:
                                        conserje.modificarConserje(conserje);
                                        break;

                                    case 0:
                                        break;
                                }
                            } while (com != 0);
                            break;

                        //Menu admin
                        case 2:
                            do {
                                int com1;

                                System.out.println("Menu Administrador");
                                System.out.println("1. Realizar CheckIn");
                                System.out.println("2. Realizar CheckOut");
                                System.out.println("3. Realizar Reserva");
                                System.out.println("4. Buscar Pasajeros");
                                System.out.println("5. Mostrar habitaciones por tipo");
                                System.out.println("6. Mostrar habitaciones por estado");
                                System.out.println("7. Crear Usuario");
                                System.out.println("8. Asignar Permisos");
                                System.out.println("9. Modificar Usuarios");
                                System.out.println("10. Realizar Back-Up");
                                System.out.println("\n0. Salir");

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

                                        do {
                                            System.out.println("Buscar pasajeros por:");
                                            System.out.println("1. Nombre");
                                            System.out.println("2. Apellido");
                                            System.out.println("3. Dni");
                                            System.out.println("4. Usuario");
                                            System.out.println("\n0. Salir");

                                            com1 = scanner.nextInt();

                                            switch (com1) {
                                                //Nombre
                                                case 1:
                                                    System.out.println("Ingrese el nombre:  ");
                                                    String nombre = scanner.next();
                                                    System.out.println(admin.buscarPasajerosNombre(nombre));
                                                    break;
                                                //Apellido
                                                case 2:
                                                    System.out.println("Ingrese el apellido:  ");
                                                    String apellido = scanner.next();
                                                    System.out.println(admin.buscarPasajerosApellido(apellido));
                                                    break;
                                                //Dni
                                                case 3:
                                                    System.out.print("Ingrese DNI: ");
                                                    String dni = scanner.next();
                                                    System.out.println(admin.buscarPasajerosDni(dni));
                                                    break;
                                                //Usuario
                                                case 4:
                                                    System.out.println("Ingrese el usuario:  ");
                                                    String usuario = scanner.next();
                                                    System.out.println(admin.buscarPasajerosUsuario(usuario));
                                                    break;
                                            }

                                        } while (com1 != 0);
                                        break;

                                    case 5:
                                        do {
                                            System.out.println("Tipos de habitaciones");
                                            System.out.println("1. Individual");
                                            System.out.println("2. Doble");
                                            System.out.println("3. Triple");
                                            System.out.println("4. Queen");
                                            System.out.println("\n0. Salir");

                                            com1 = scanner.nextInt();

                                            switch (com1) {
                                                //INDIVIDUAL
                                                case 1:
                                                    admin.mostrarHabitacionesTipo(TipoDeHabitacion.INDIVIDUAL);
                                                    break;
                                                //Doble
                                                case 2:
                                                    admin.mostrarHabitacionesTipo(TipoDeHabitacion.DOBLE);
                                                    break;
                                                //Triple
                                                case 3:
                                                    admin.mostrarHabitacionesTipo(TipoDeHabitacion.TRIPLE);
                                                    break;
                                                //Queen
                                                case 4:
                                                    admin.mostrarHabitacionesTipo(TipoDeHabitacion.QUEEN);
                                                    break;

                                                case 0:
                                                    break;
                                            }

                                        } while (com1 != 0);

                                        break;

                                    case 6:

                                        do {
                                            System.out.println("Estado de la habitacion: ");
                                            System.out.println("1. Libre");
                                            System.out.println("2. Ocupada");
                                            System.out.println("3. Reservada");
                                            System.out.println("4. En Limpieza");
                                            System.out.println("5. En Reparacion");
                                            System.out.println("0. Salir");


                                            com1 = scanner.nextInt();

                                            switch (com1) {

                                                case 1:
                                                    admin.mostrarHabitacionesEstado(EstadoHabitacion.LIBRE);
                                                    break;

                                                case 2:
                                                    admin.mostrarHabitacionesEstado(EstadoHabitacion.OCUPADA);
                                                    break;

                                                case 3:
                                                    admin.mostrarHabitacionesEstado(EstadoHabitacion.RESERVADA);
                                                    break;

                                                case 4:
                                                    admin.mostrarHabitacionesEstado(EstadoHabitacion.LIMPIEZA);
                                                    break;

                                                case 5:
                                                    admin.mostrarHabitacionesEstado(EstadoHabitacion.REPARACION);
                                                    break;

                                                case 0:
                                                    break;
                                            }

                                        } while (com1 != 0);

                                        break;

                                    //Crear Usuario
                                    case 7:
                                        do {
                                            System.out.println("Que tipo de usuario desea crear?: ");
                                            System.out.println("1. Pasajero");
                                            System.out.println("2. Conserje");
                                            System.out.println("3. Administrador");
                                            System.out.println("0. Salir");

                                            com1 = scanner.nextInt();
                                            switch (com1) {
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

                                                case 0:
                                                    break;
                                            }

                                        } while (com1 != 0);
                                        break;

                                    //Asignar Permisos
                                    case 8:
                                        break;

                                    //Modificar usuarios
                                    case 9:

                                        do {

                                            System.out.println("Modificar usuarios");
                                            System.out.println("1. Modificar");
                                            System.out.println("2. Dar de baja/alta");
                                            System.out.println("0. Salir");

                                            com1 = scanner.nextInt();

                                            switch (com1) {

                                                case 1:
                                                    String dni = scanner.next();
                                                    Usuario user1 = admin.buscarUsuario(dni);

                                                    if (user != null) {
                                                        if (user instanceof Conserje) {
                                                            admin.modificarConserje((Conserje) user1);

                                                        } else if (user instanceof Administrador) {
                                                            admin.modificarAdministrador((Administrador) user1);

                                                        } else {
                                                            pasajero.modificarPasajero((Pasajero) user1);
                                                        }

                                                    } else {
                                                        System.out.println("No se econtro el usuario.");
                                                    }

                                                    break;

                                                case 2:
                                                    String dni1 = scanner.next();
                                                    admin.darBajaAlta(admin.buscarUsuario(dni1));
                                                    break;

                                                case 0:
                                                    break;
                                            }

                                        } while (com1 != 0);

                                        break;

                                    //Realizar Back-Up
                                    case 10:
                                        admin.guardarListaUsuarioArchivo();
                                        admin.guardarListaHabitacionArchivo();
                                        admin.guardarListaReservaArchivo();
                                        admin.guardarMiniBarArchivo();

                                        System.out.println("Realizando Back-Up...");
                                        break;

                                    default:
                                }
                            } while (com != 0);
                            break;

                        //Menu Pasajero
                        case 3:
                            do {
                                System.out.println("Menu Pasajero");
                                System.out.println("1. Realizar reserva remota");
                                System.out.println("2. Mini Bar");
                                System.out.println("3. Modificar sus datos");
                                System.out.println("0. Salir");

                                com = scanner.nextInt();

                                switch (com) {

                                    case 1:
                                        pasajero.reservaRemota(pasajero);
                                        break;

                                    case 2:
                                        pasajero.realizarConsumo();
                                        break;

                                    case 3:
                                        pasajero.modificarPasajero(pasajero);
                                        break;

                                    case 0:
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
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
            }
        } while (com != 3);
    }
}

