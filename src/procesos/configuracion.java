package procesos;
import entidades.Pasajero;
import entidades.Chofer;
import entidades.Auto;
import entidades.Cuenta;
import entidades.Viaje;
import entidades.Ruta;

import java.util.HashMap;
import java.util.Vector;

public class configuracion {
    private static Vector<Pasajero> pasajeros;
    private static HashMap<Chofer,Auto> choferAutoMap;
    private static HashMap<Viaje,Ruta> viajeRutaMap;
    private static Vector<Ruta> rutas;
    public configuracion(){
        this.pasajeros = new Vector<Pasajero>();
        this.choferAutoMap = new HashMap<Chofer, Auto>();
        this.viajeRutaMap = new HashMap<Viaje,Ruta>();
        this.rutas = new Vector<Ruta>();
    }
    public Vector<Pasajero> getPasajeros() {
        return pasajeros;
    }
    public HashMap<Chofer,Auto> getCAMap() {
        return choferAutoMap;
    }
    public HashMap<Viaje,Ruta> getVRMap(){return viajeRutaMap;}
    public Vector<Ruta> getRutas(){
        return rutas;
    }
}