package com.company;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;

import java.io.*;
import java.net.NetPermission;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Administrador extends Conserje {
private String hola=null;

    public Administrador() {
    }

    public Administrador(String userType, String nombre, String apellido, String dni, String usuario, String constrasena) {
        super(userType, nombre, apellido, dni, usuario, constrasena);
    }

    public void crearConserje() {

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


        Conserje nuevoConserje = new Conserje("Conserje", nombre, apellido, dni, usuario, contrasena);

        Hotel.getUsuarioList().add(nuevoConserje);
    }

    public void crearAdministrador() {

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


        Administrador nuevoAdministrador = new Administrador("Administrador", nombre, apellido, dni, usuario, contrasena);

        Hotel.getUsuarioList().add(nuevoAdministrador);

    }

    public void modificarAdministrador(Administrador administrador) {

        int com;
        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println("Modificar Administrador");

            System.out.println(administrador);

            System.out.println("1. Nombre");
            System.out.println("2. Apellido");
            System.out.println("3. DNI");
            System.out.println("4. Usuario");
            System.out.println("5. Contraseña");

            System.out.println("\n0. Salir");

            com = scanner.nextInt();

            scanner.nextLine();

            switch (com) {

                case 1:
                    System.out.println("Ingrese nuevo nombre: ");
                    administrador.setNombre(scanner.nextLine());
                    break;

                case 2:
                    System.out.println("Ingrese nuevo apellido");
                    administrador.setApellido(scanner.nextLine());
                    break;

                case 3:
                    System.out.println("Ingrese nuevo dni");
                    administrador.setDni(scanner.nextLine());
                    break;

                case 4:
                    System.out.println("Ingrese nuevo usuario");
                    administrador.setUsuario(scanner.nextLine());
                    break;

                case 5:
                    System.out.println("Ingrese nueva contraseña");
                    administrador.setConstrasena(scanner.nextLine());
                    break;
            }


        } while (com != 0);
    }


    public Usuario buscarUsuario(String dni) {
        for (Usuario usuario : Hotel.getUsuarioList()) {
            if (usuario.isActivo() && usuario.getDni().equals(dni)) {
                return usuario;
            }
        }
        return null;
    }

    public void darBajaAlta(Usuario user) {

        Scanner scanner = new Scanner(System.in);
        String com;

        if (user.isActivo()) {
            System.out.println("Desea darlo de baja?: [s/n]");
            com = scanner.next();

            if (com == "s") {
                System.out.println("Se ha realizado la baja");
                user.setActivo(false);
            } else {
                System.out.println("No se ha realizado la baja.");
            }

        } else {

            System.out.println("Desea darlo de alta?: [s/n]");
            com = scanner.next();

            if (com == "s") {
                System.out.println("Se ha realizado el alta");
                user.setActivo(true);
            } else {
                System.out.println("No se ha realizado el alta");
            }
        }
    }

    public void guardarListaUsuarioArchivo() {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("usuariosList.json"), Hotel.getUsuarioList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


   /* public void cargarListaUsuarioArchivo() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        try {
            Hotel.setUsuarioList(mapper.readValue(
                    new File("usuariosList.json"),
                    new TypeReference<List<Usuario>>() {
                    }));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
   public void cargarListaUsuarioArchivo() {
       ObjectMapper mapper = new ObjectMapper();
       mapper.enableDefaultTyping();
       JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class,Usuario.class);
       try {
           List<Usuario> usuarioList = mapper.readValue(new File("usuariosList.json"),javaType );
           Hotel.setUsuarioList(usuarioList);
       } catch (IOException e) {
           e.printStackTrace();
       }

   }


    public void guardarListaReservaArchivo() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("reservasList.json"), Hotel.getReservaList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void cargarListaReservaArchivo() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            Hotel.setReservaList(mapper.readValue(
                    new File("reservasList.json"),
                    new TypeReference<List<Reserva>>() {
                    }));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void guardarListaHabitacionArchivo() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("habitacionesList.json"), Hotel.getHabitacionList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void cargarListaHabitacionArchivo() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            Hotel.setHabitacionList(mapper.readValue(
                    new File("habitacionesList.json"),
                    new TypeReference<List<Habitacion>>() {
                    }));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void guardarMiniBarArchivo() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("miniBar.json"), Hotel.getMiniBar());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void cargarMiniBarArchivo() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            Hotel.setMiniBar(mapper.readValue(
                    new File("miniBar.json"),
                    new TypeReference<List<Producto>>() {
                    }));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
