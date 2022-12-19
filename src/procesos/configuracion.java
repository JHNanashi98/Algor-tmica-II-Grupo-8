package procesos;

import entidades.Pasajero;
import entidades.Chofer;
import entidades.Auto;
import entidades.Cuenta;
import entidades.Viaje;
import entidades.Ruta;

import java.util.HashMap;
import java.util.Vector;

public abstract class configuracion {
    private static Vector<Pasajero> pasajeros;
    private static HashMap<Chofer,Auto> choferAutoMap;
    private static Vector<Cuenta> admin;
    private static HashMap<Viaje,Ruta> viajeRutaMap;

    public configuracion(){
        this.pasajeros = new Vector<Pasajero>();
        this.choferAutoMap = new HashMap<Chofer, Auto>();
        this.admin = new Vector<Cuenta>();
        this.viajeRutaMap = new HashMap<Viaje,Ruta>();
    }
    public Vector<Pasajero> getPasajeros() {
        return pasajeros;
    }
    public HashMap<Chofer,Auto> getCAMap() {
        return choferAutoMap;
    }
    public static Vector<Cuenta> getAdmin() {return admin;}

    public HashMap<Viaje,Ruta> getVRMap(){return viajeRutaMap;}
}