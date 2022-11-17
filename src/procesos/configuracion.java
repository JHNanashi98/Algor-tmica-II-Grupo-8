package procesos;

import entidades.Chofer;
import entidades.Pasajero;

import java.util.Vector;

public class configuracion {
    private Vector<Chofer> choferes;
    private Vector<Pasajero> pasajeros;
    public configuracion(){
        this.choferes = new Vector<Chofer>();
        this.pasajeros = new Vector<Pasajero>();
    }

    public Vector<Chofer> getChoferes() {
        return choferes;
    }

    public Vector<Pasajero> getPasajeros() {
        return pasajeros;
    }
}
