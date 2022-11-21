package procesos;

import entidades.Auto;
import entidades.Chofer;
import entidades.Pasajero;

import java.util.Enumeration;
import java.util.Vector;

public abstract class configuracion {
    private static Vector<Chofer> choferes;
    private static Vector<Pasajero> pasajeros;
    private static Vector<Auto> autos;
    public configuracion(){
        this.choferes = new Vector<Chofer>();
        this.pasajeros = new Vector<Pasajero>();
        this.autos = new Vector<Auto>();
    }
    public  Vector<Chofer> getChoferes() {
        return choferes;
    }
    public Vector<Pasajero> getPasajeros() {
        return pasajeros;
    }
    public Vector<Auto> getAutos() {
        return autos;
    }
}