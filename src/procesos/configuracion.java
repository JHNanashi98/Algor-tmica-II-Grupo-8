package procesos;

import entidades.Auto;
import entidades.Chofer;
import entidades.Cuenta;
import entidades.Pasajero;

import java.util.HashMap;
import java.util.Vector;

public abstract class configuracion {
    private static Vector<Pasajero> pasajeros;
    private static HashMap<Chofer,Auto> choferAutoMap;
    private static Vector<Cuenta> admin;

    public configuracion(){
        this.pasajeros = new Vector<Pasajero>();
        this.choferAutoMap = new HashMap<Chofer, Auto>();
        this.admin = new Vector<Cuenta>();
    }
    public Vector<Pasajero> getPasajeros() {
        return pasajeros;
    }
    public HashMap<Chofer,Auto> getMap() {
        return choferAutoMap;
    }

    public static Vector<Cuenta> getAdmin() {
        return admin;
    }
}