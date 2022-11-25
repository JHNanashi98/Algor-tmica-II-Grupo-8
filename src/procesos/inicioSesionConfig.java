package procesos;

import entidades.Auto;
import entidades.Chofer;
import entidades.Pasajero;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class inicioSesionConfig extends configuracion {
    public Pasajero IniciarSesionPasajero(String email, String contra) {
        Enumeration<Pasajero> pas = this.getPasajeros().elements();
        while (pas.hasMoreElements()) {
            Pasajero pasajero = pas.nextElement();
            String email1  = String.valueOf(pasajero.getEmail());
            if (email1.equals(email)) {
                if (pasajero.getContrasenia().equals(contra)) {
                    return pasajero;
                }
            }

        }
        System.out.println("Contraseña incorrecta");
        return null;
    }
    public Chofer IniciarSesionChofer(String email, String contra) {
        HashMap<Chofer, Auto> map = this.getMap();
        int i=0;
        Chofer [] chof = new Chofer[map.size()];
        for (Map.Entry<Chofer,Auto> entrada : map.entrySet()) {
            chof[i] =entrada.getKey();
            Chofer chofer = chof[i];
            String email1  = String.valueOf(chofer.getEmail());
            if (email1.equals(email)) {
                if (chofer.getContrasenia().equals(contra)) {
                    return chofer;
                }
            }
            i++;
        }
        System.out.println("Contraseña incorrecta");
        return null;
    }
}
