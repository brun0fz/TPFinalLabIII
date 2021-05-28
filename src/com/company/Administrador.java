package com.company;

import com.google.gson.Gson;

import java.lang.reflect.GenericArrayType;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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

    public void guardarListaUsuariosArchivo() {
        Gson gson = new Gson();
        String json = gson.toJson(Hotel.getUsuarioList());

        try {
            FileWriter writer = new FileWriter("usuarioList.json");
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarListaUsuarioArchivo(){
        Gson gson = new Gson();
        try{
            BufferedReader br = new BufferedReader(new FileReader("usuarioList.json"));
            Hotel.setUsuarioList(gson.fromJson(br,Hotel.getUsuarioList().getClass()));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    ///falta lo mismo para reserva, habitacion


}
