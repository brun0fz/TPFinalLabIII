package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Administrador extends Conserje implements Descuento {


    public Administrador() {
    }

    public Administrador(String nombre, String apellido, String dni, String usuario, String constrasena) {
        super(nombre, apellido, dni, usuario, constrasena);
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


        Conserje nuevoConserje = new Conserje(nombre, apellido, dni, usuario, contrasena);

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


        Administrador nuevoAdministrador = new Administrador(nombre, apellido, dni, usuario, contrasena);

        Hotel.getUsuarioList().add(nuevoAdministrador);

    }

    public void guardarListaUsuarioArchivo(){
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("usuariosList.json"), Hotel.getUsuarioList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void cargarListaUsuarioArchivo(){
        ObjectMapper mapper = new ObjectMapper();

        try {
            Hotel.setUsuarioList(mapper.readValue(
                    new File("usuariosList.json"),
                    new TypeReference<List<Usuario>>() { }));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public void guardarListaReservaArchivo(){
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("reservasList.json"), Hotel.getReservaList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void cargarListaReservaArchivo(){
        ObjectMapper mapper = new ObjectMapper();

        try {
            Hotel.setReservaList(mapper.readValue(
                    new File("reservasList.json"),
                    new TypeReference<List<Reserva>>() { }));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public void guardarListaHabitacionArchivo(){
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("habitacionesList.json"), Hotel.getHabitacionList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void cargarListaHabitacionArchivo(){
        ObjectMapper mapper = new ObjectMapper();

        try {
            Hotel.setHabitacionList(mapper.readValue(
                    new File("habitacionesList.json"),
                    new TypeReference<List<Habitacion>>() { }));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
