package procesos;

import entidades.Chofer;
import entidades.Pasajero;

import java.util.Enumeration;

public class inicioSesionConfig extends configuracion {
    public void creaChofer(Chofer chof){
        Enumeration<Chofer> cf = this.getChoferes().elements();
        while(cf.hasMoreElements()) {
            Chofer chofer = cf.nextElement();
        }
        this.getChoferes().add((Chofer) chof);
    }
    public void creaPasajero(Pasajero pas){
        Enumeration<Pasajero> psj = this.getPasajeros().elements();
        while (psj.hasMoreElements()){
            Pasajero pasa = psj.nextElement();
        }
        this.getPasajeros().add((Pasajero) pas);
    }
    public int IniciarSesionPasajero(String email, String contra) {
        Enumeration<Pasajero> pas = this.getPasajeros().elements();
        while (pas.hasMoreElements()) {
            Pasajero pasajero = pas.nextElement();
            String email1  = String.valueOf(pasajero.getEmail());
            if (email1.equals(email)) {
                if (pasajero.getContrasenia().equals(contra)) {
                    System.out.println("Bievenido: " + pasajero.NombreCompleto());
                    return 1;
                }
            }
        }
        System.out.println("Contraseña incorrecta");
        return 0;
    }
    public int IniciarSesionChofer(String email, String contra) {
        Enumeration<Chofer> cf = this.getChoferes().elements();
        while (cf.hasMoreElements()) {
            Chofer chofer = cf.nextElement();
            String email1  = String.valueOf(chofer.getEmail());

            if (chofer.getEmail().equals(email) && chofer.getContrasenia().equals(contra)) {
                System.out.println("Bievenido"+chofer.NombreCompleto());
                return 1;
            }
        }
        System.out.println("Contraseña incorrecta");
        return 0;
    }
}
