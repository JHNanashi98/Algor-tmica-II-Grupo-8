package procesos;

import entidades.Auto;
import entidades.Chofer;
import entidades.Pasajero;

import java.util.HashMap;
import java.util.Vector;

public abstract class configuracion {
    private static Vector<Pasajero> pasajeros;
    private static HashMap<Chofer,Auto> choferAutoMap;

    public configuracion(){
        this.pasajeros = new Vector<Pasajero>();
        this.choferAutoMap = new HashMap<Chofer, Auto>();
    }
    public Vector<Pasajero> getPasajeros() {
        return pasajeros;
    }
    public HashMap<Chofer,Auto> getMap() {
        return choferAutoMap;
    }

}