package entidades;
import procesos.registroConfig;

import java.util.Enumeration;
import java.util.Scanner;

public class Cuenta implements interCuenta{
    private String nombres;
    private String apellidoPat;
    private String apellidoMat;
    private String telefono;
    private String email;
    private String contrasenia;
    private String DNI;
    private char genero;
    protected String tipo;
    public Cuenta(String nombres, String apellidoPat, String apellidoMat, char genero, String telefono, String DNI ,String email, String contrasenia) {
        this.nombres = nombres;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.genero = genero;
        this.telefono = telefono;
        this.DNI = DNI;
        this.email = email;
        this.contrasenia = contrasenia;
    }
    public Cuenta(String email, String contrasenia){
        this.email = email;
        this.contrasenia = contrasenia;
    }
    public String getNombres(){return this.nombres;};
    public String getApellidoPat(){return this.apellidoPat;};
    public String getApellidoMat(){return this.apellidoMat;};
    public char getGenero(){return this.genero;};
    public String getTelefono(){return this.telefono;};
    public String getDNI(){return this.DNI;};
    public String getEmail(){return this.email;};
    public String getContrasenia(){return this.contrasenia;};
    public String NombreCompleto() {
        return nombres + " " + apellidoPat + " " + apellidoMat;
    }
    public String getTipo() {
        return tipo;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public void actualizarDatos(registroConfig config, Cuenta c){
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
        int pos = config.getPasajeros().indexOf(c);
        int opt = s.nextInt();
        Scanner f = new Scanner(System.in);
        switch (opt){
            case 1:
                System.out.println("Ingrese nombres");
                String nombre = f.nextLine();
                config.getPasajeros().get(pos).setNombres(nombre);
                break;
            case 2:
                System.out.println("Ingrese Apellido Paterno");
                String apellidoP = f.nextLine();
                config.getPasajeros().get(pos).setApellidoPat(apellidoP);
                String apellidoM = f.nextLine();
                System.out.println("Ingrese Apellido Materno");
                config.getPasajeros().get(pos).setApellidoMat(apellidoM);
                break;
            case 3:
                System.out.println("Ingrese Genero");
                char gen = f.next().charAt(0);
                config.getPasajeros().get(pos).setGenero(gen);
                break;
            case 4:
                System.out.println("Ingrese numero telefonico");
                String telf = f.nextLine();
                config.getPasajeros().get(pos).setTelefono(telf);
                break;
            case 5:
                System.out.println("Ingrese DNI");
                String dni = f.nextLine();
                config.getPasajeros().get(pos).setDNI(dni);
                break;
            case 6:
                System.out.println("Ingrese email");
                String email = f.nextLine();
                config.getPasajeros().get(pos).setEmail(email);
                break;
            case 7:
                System.out.println("Ingrese contrasenia");
                String contra = f.nextLine();
                config.getPasajeros().get(pos).setContrasenia(contra);
                break;
        }

    }
    public Cuenta IniciarSesion(String email, String contra, registroConfig config) {
        //Admin//
        Enumeration<Cuenta> cue = config.getAdmin().elements();
        while (cue.hasMoreElements()) {
            Cuenta cuenta = cue.nextElement();
            String email1  = String.valueOf(cuenta.getEmail());
            if (email1.equals(email)) {
                if (cuenta.getContrasenia().equals(contra)){
                    return cuenta;
                }
                System.out.println("Contraseña incorrecta");
            }
        }
        System.out.println("Usuario incorrecto");
        return null;
    }

}
