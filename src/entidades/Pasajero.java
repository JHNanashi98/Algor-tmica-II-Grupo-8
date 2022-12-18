package entidades;

import procesos.registroConfig;

import java.util.Enumeration;

public class Pasajero extends Cuenta{
    public Pasajero(String nombres, String apellidoPat, String apellidoMat, char genero, String telefono, String DNI ,String email, String contrasenia){
        super(nombres, apellidoPat, apellidoMat, genero, telefono, DNI, email, contrasenia);
        tipo ="Pasajero";
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
}
