package entidades;
import entidades.pagos.Efectivo;
import entidades.pagos.Tarjeta;
import entidades.pagos.Yape;
import org.jxmapviewer.viewer.GeoPosition;
import procesos.registroConfig;

import java.util.Enumeration;
import java.util.Scanner;

public class Pasajero extends Cuenta implements interCuenta{
    public Pasajero(String nombres, String apellidoPat, String apellidoMat, char genero, String telefono, String DNI ,String email, String contrasenia){
        super(nombres, apellidoPat, apellidoMat, genero, telefono, DNI, email, contrasenia);
        tipo ="Pasajero";
    }
    public void actualizarDatos(registroConfig config, Cuenta c) {
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
        switch (opt) {
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
    public Pasajero(String email, String contrasenia){
        super(email,contrasenia);
    }
    @Override
    public Pasajero IniciarSesion(String email, String contra, registroConfig config) {
        Enumeration<Pasajero> pas = config.getPasajeros().elements();
        while (pas.hasMoreElements()) {
            Pasajero pasajero = pas.nextElement();
            String email1  = String.valueOf(pasajero.getEmail());
            if (email1.equals(email)) {
                if (pasajero.getContrasenia().equals(contra)){
                    return pasajero;
                }
                System.out.println("Contraseña incorrecta");
            }
        }
        System.out.println("Usuario incorrecto");
        return null;
    }

    @Override
    public void escribePerfil(registroConfig config, Cuenta c) {
        Pasajero p = (Pasajero) c;
        System.out.println("Mostrando datos del Usuario ");
        System.out.println("Nombres "+ p.getNombres());
        System.out.println("Apellidos "+ p.getApellidoPat()+" "+p.getApellidoMat());
        System.out.println("Genero "+ p.getGenero());
        System.out.println("Telefono "+p.getTelefono());
        System.out.println("DNI "+ p.getDNI());
        System.out.println("email "+ p.getEmail());
        System.out.println("contrasenia "+ p.getContrasenia());
    }

    @Override
    public void mostrarViaje() {

    }

    public void pagarViaje(GeoPosition ini, GeoPosition fin,Pasajero p){
        System.out.println("Seleccione metodo a pagar");
        System.out.println("1) Efectivo");
        System.out.println("2) Tarjeta Credito");
        System.out.println("3) Yape");
        Scanner s = new Scanner(System.in);
        double monto;
        int op =s.nextInt();
        switch(op) {
            case 1:
                Efectivo e = new Efectivo();
                monto = e.calcularPago(ini,fin);
                System.out.println(monto);
                break;
            case 2:
                System.out.println("Digite su tarjeta de credito");
                String ccvP = s.next();
                System.out.println("Digite el mes de Vencimiento");
                int mes = s.nextInt();
                System.out.println("Digite el anio de Vencimiento");
                int anio = s.nextInt();
                System.out.println("Digite la tarjeta de credito del Chofer");
                String ccvC = s.next();
                Tarjeta t = new Tarjeta(ccvP,mes,anio,ccvC);
                monto =t.calcularPago(ini,fin);
                System.out.println(monto);
                break;
            case 3:
                System.out.println("Digite el telefono del Choder");
                String telfChof =s.next();
                Yape y = new Yape(p.getTelefono(), telfChof);
                monto =y.calcularPago(ini,fin);
                System.out.println(monto);
                break;
        }
    }

}
