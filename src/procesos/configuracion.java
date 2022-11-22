package procesos;

import entidades.Auto;
import entidades.Chofer;
import entidades.Pasajero;

import java.util.HashMap;
import java.util.Vector;

public abstract class configuracion {
    private static Vector<Chofer> choferes;
    private static Vector<Pasajero> pasajeros;
    private static Vector<Auto> autos;

    private static HashMap<Chofer,Auto> choferAutoMap;

    public configuracion(){
        this.choferes = new Vector<Chofer>();
        this.pasajeros = new Vector<Pasajero>();
        this.autos = new Vector<Auto>();
        this.choferAutoMap = new HashMap<Chofer, Auto>();
    }
    public  Vector<Chofer> getChoferes() {
        return choferes;
    }
    public Vector<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public static Vector<Auto> getAutos() {
        return autos;
    }
    public HashMap<Chofer,Auto> getMap() {
        return choferAutoMap;
    }

}