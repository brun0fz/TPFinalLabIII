package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Administrador admin = new Administrador("Bruno", "Fabrizio", "39123123", "Bruno", "1234");

        Conserje conserje = new Conserje("dan", "sua", "33", "123", "45");
        Pasajero pasajero = new Pasajero("Danilo", "Suarez", "33102857", "danilo", "1234", "Funes 2461", "2236688139", "danilomdq@gmail.com");

        Habitacion habi = new Habitacion("21", "12", TipoDeHabitacion.INDIVIDUAL, 333.45, EstadoHabitacion.LIBRE);
        Habitacion habi1 = new Habitacion("12", "115", TipoDeHabitacion.TRIPLE, 333.45, EstadoHabitacion.LIBRE);
        Habitacion habi2 = new Habitacion("9", "3", TipoDeHabitacion.QUEEN, 333.45, EstadoHabitacion.LIBRE);

        Producto cocaCola = new Producto("Coca Cola", 120);
        Producto agua = new Producto("Agua mineral", 120);
        Producto sandwich = new Producto("Sandwich", 120);
        ///cargar mas productos

        Hotel.getMiniBar().add(cocaCola);
        Hotel.getMiniBar().add(agua);
        Hotel.getMiniBar().add(sandwich);

        Hotel.getUsuarioList().add(admin);

        Hotel.getHabitacionList().add(habi);
        Hotel.getHabitacionList().add(habi1);
        Hotel.getHabitacionList().add(habi2);
        Hotel.getUsuarioList().add(conserje);

        Hotel.getUsuarioList().add(pasajero);


        //Falta:
        //pulir parte grafica


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

                                            com = scanner.nextInt();

                                            switch (com) {
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

                                        } while (com != 0);

                                        break;

                                    case 5:

                                        do {
                                            System.out.println("Tipos de habitaciones");
                                            System.out.println("1. Individual");
                                            System.out.println("2. Doble");
                                            System.out.println("3. Triple");
                                            System.out.println("4. Queen");
                                            System.out.println("\n0. Salir");

                                            com = scanner.nextInt();

                                            switch (com) {
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

                                        } while (com != 0);

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


                                            com = scanner.nextInt();

                                            switch (com) {

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

                                        } while (com != 0);

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

                                            com = scanner.nextInt();

                                            switch (com) {
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

                                        } while (com != 0);


                                        break;

                                    case 5:
                                        do {
                                            System.out.println("Tipos de habitaciones");
                                            System.out.println("1. Individual");
                                            System.out.println("2. Doble");
                                            System.out.println("3. Triple");
                                            System.out.println("4. Queen");
                                            System.out.println("\n0. Salir");

                                            com = scanner.nextInt();

                                            switch (com) {
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

                                        } while (com != 0);

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


                                            com = scanner.nextInt();

                                            switch (com) {

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

                                        } while (com != 0);

                                        break;

                                    //Crear Usuario
                                    case 7:
                                        do {
                                            System.out.println("Que tipo de usuario desea crear?: ");
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

                                                case 0:
                                                    break;
                                            }

                                        } while (com != 0);
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

                                            switch (com) {

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

                                        } while (com != 0);

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

