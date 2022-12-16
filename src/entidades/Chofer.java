package entidades;

import procesos.inicioSesionConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Chofer extends Cuenta {
    public Chofer(String nombres, String apellidoPat, String apellidoMat, char genero, String telefono, String DNI, String email, String contrasenia) {
        super(nombres, apellidoPat, apellidoMat, genero, telefono, DNI, email, contrasenia);
        tipo = "Chofer";
    }
    @Override
    public void actualizarDatos(inicioSesionConfig inicio){
        System.out.println("Sistema Actualizado Datos");
    }
    public void actualizarDatos(inicioSesionConfig inicio, Chofer c){
        System.out.println("¿Que datos desea actualizar, Chofer o Auto?");
        System.out.println("1) Chofer");
        System.out.println("2) Auto");
        Scanner s = new Scanner(System.in);
        HashMap<Chofer, Auto> map = inicio.getMap();
        for(Map.Entry<Chofer,Auto> entrada :map.entrySet()){
            if(entrada.getKey().equals(c)){
                int op = s.nextInt();
                switch (op) {
                    case 1 :
                        actualizarDatosPer(c, s);
                        map.put(c,entrada.getValue());
                        break;
                    case 2:
                        Auto auto = entrada.getValue();
                        actilizadDatosAut(auto, s);
                        map.put(entrada.getKey(),auto);
                        break;
                }
            }
        }
    }
    public void actualizarDatosPer(Chofer c, Scanner s){
        System.out.println("Sistema Actualizado Datos");
        System.out.println("¿Que dato desea actualizar?");
        System.out.println("1) Nombres");
        System.out.println("2) Apellidos");
        System.out.println("3) Genero");
        System.out.println("4) Telefono");
        System.out.println("5) DNI");
        System.out.println("6) Email");
        System.out.println("7) contraseña");
        int opt = s.nextInt();
        Scanner f = new Scanner(System.in);
        switch (opt){
            case 1:
                System.out.println("Ingrese nombres");
                String nombre = f.nextLine();
                c.setNombres(nombre);
                break;
            case 2:
                System.out.println("Ingrese Apellido Paterno");
                String apellidoP = f.nextLine();
                c.setApellidoMat(apellidoP);
                String apellidoM = f.nextLine();
                System.out.println("Ingrese Apellido Materno");
                c.setApellidoMat(apellidoM);
                break;
            case 3:
                System.out.println("Ingrese Genero");
                char gen = f.next().charAt(0);
                c.setGenero(gen);
                break;
            case 4:
                System.out.println("Ingrese numero telefonico");
                String telf = f.nextLine();
                c.setTelefono(telf);
                break;
            case 5:
                System.out.println("Ingrese DNI");
                String dni = f.nextLine();
                c.setDNI(dni);
                break;
            case 6:
                System.out.println("Ingrese email");
                String email = f.nextLine();
                c.setEmail(email);
                break;
            case 7:
                System.out.println("Ingrese contrasenia");
                String contra = f.nextLine();
                c.setContrasenia(contra);
                break;
        }
    }
    public void actilizadDatosAut(Auto a, Scanner s){
        System.out.println("Sistema Actualizado Datos");
        System.out.println("¿Que dato desea actualizar?");
        System.out.println("1) Placa");
        System.out.println("2) Capacidad");
        System.out.println("3) Marca");
        int opt = s.nextInt();
        Scanner f = new Scanner(System.in);
        switch (opt) {
            case 1:
                System.out.println("Ingrese Placa");
                String placa = f.nextLine();
                a.setPlaca(placa);
                break;
            case 2:
                System.out.println("Ingrese capacidad");
                int capa = f.nextInt();
                a.setCapacidad(capa);
                break;
            case 3:
                System.out.println("Ingrese Marca");
                String marca = f.nextLine();
                a.setMarca(marca);
                break;
        }

    }
}

