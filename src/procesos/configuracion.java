package procesos;

import entidades.Auto;
import entidades.Chofer;
import entidades.Pasajero;

import java.util.Enumeration;
import java.util.Vector;

public class configuracion {
    private Vector<Chofer> choferes;
    private Vector<Pasajero> pasajeros;
    private Vector<Auto> autos;
    public configuracion(){
        this.choferes = new Vector<Chofer>();
        this.pasajeros = new Vector<Pasajero>();
        this.autos = new Vector<Auto>();
    }
    public Vector<Chofer> getChoferes() {
        return choferes;
    }
    public Vector<Pasajero> getPasajeros() {
        return pasajeros;
    }
    public Vector<Auto> getAutos() {
        return autos;
    }
    public int creaChofer(Chofer chof){
        Enumeration<Chofer> cf = this.getChoferes().elements();
        while(cf.hasMoreElements()) {
            Chofer chofer = cf.nextElement();
            if(chofer.getEmail().equals(chof.getEmail())){
                System.out.println("Este correo ya se encuentra registrado, intente con otro");
                return 1;
            }
        }
        this.getChoferes().add((Chofer) chof);
        return 0;
    }
    public int creaPasajero(Pasajero pas){
        Enumeration<Pasajero> psj = this.getPasajeros().elements();
        while (psj.hasMoreElements()){
            Pasajero pasa = psj.nextElement();
            if(pasa.getEmail().equals(pas.getEmail())) {
                System.out.println("Este correo ya se encuentra registrado, intente con otro");
                return 1;
            }
        }
        this.getPasajeros().add((Pasajero) pas);
        return 0;
    }
}