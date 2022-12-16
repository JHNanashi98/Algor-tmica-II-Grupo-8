package entidades;

import procesos.inicioSesionConfig;

import java.util.Scanner;

public class Pasajero extends Cuenta{
    public Pasajero(String nombres, String apellidoPat, String apellidoMat, char genero, String telefono, String DNI ,String email, String contrasenia){
        super(nombres, apellidoPat, apellidoMat, genero, telefono, DNI, email, contrasenia);
        tipo ="Pasajero";
    }
    @Override
    public void actualizarDatos(inicioSesionConfig inicio){
        System.out.println("Sistema Actualizado Datos");
    }
    public void actualizarDatos(inicioSesionConfig inicio, Pasajero p){
        Scanner s = new Scanner(System.in);
        System.out.println("Sistema Actualizado Datos");
        System.out.println("¿Que dato desea actualizar?");
        System.out.println("1) Nombres");
        System.out.println("2) Apellidos");
        System.out.println("3) Genero");
        System.out.println("4) Telefono");
        System.out.println("5) DNI");
        System.out.println("6) Email");
        System.out.println("7) contraseña");
        int pos = inicio.getPasajeros().indexOf(p);
        int opt = s.nextInt();
        Scanner f = new Scanner(System.in);
        switch (opt){
            case 1:
                System.out.println("Ingrese nombres");
                String nombre = f.nextLine();
                inicio.getPasajeros().get(pos).setNombres(nombre);
                break;
            case 2:
                System.out.println("Ingrese Apellido Paterno");
                String apellidoP = f.nextLine();
                inicio.getPasajeros().get(pos).setApellidoPat(apellidoP);
                String apellidoM = f.nextLine();
                System.out.println("Ingrese Apellido Materno");
                inicio.getPasajeros().get(pos).setApellidoMat(apellidoM);
                break;
            case 3:
                System.out.println("Ingrese Genero");
                char gen = f.next().charAt(0);
                inicio.getPasajeros().get(pos).setGenero(gen);
                break;
            case 4:
                System.out.println("Ingrese numero telefonico");
                String telf = f.nextLine();
                inicio.getPasajeros().get(pos).setTelefono(telf);
                break;
            case 5:
                System.out.println("Ingrese DNI");
                String dni = f.nextLine();
                inicio.getPasajeros().get(pos).setDNI(dni);
                break;
            case 6:
                System.out.println("Ingrese email");
                String email = f.nextLine();
                inicio.getPasajeros().get(pos).setEmail(email);
                break;
            case 7:
                System.out.println("Ingrese contrasenia");
                String contra = f.nextLine();
                inicio.getPasajeros().get(pos).setContrasenia(contra);
                break;
        }

    }
}
