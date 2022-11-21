package procesos;

import entidades.Auto;
import entidades.Chofer;
import entidades.Pasajero;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Enumeration;
import java.util.Vector;

public class registroConfig extends configuracion{
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
    public JSONArray pasajerosToJSON(){
        JSONArray arrayPasa = new JSONArray();
        Enumeration <Pasajero> pj = this.getPasajeros().elements();
        while  (pj.hasMoreElements()){
            Pasajero p = pj.nextElement();
            JSONObject obj = new JSONObject();
            obj.put("nombres", p.getNombres());
            obj.put("apellidoPat", p.getApellidoPat());
            obj.put("apellidoMat", p.getApellidoMat());
            if(p.getGenero()=='M') {
                obj.put("genero", "M");
            }
            else if (p.getGenero()=='F'){
                obj.put("genero", "F");
            }
            else obj.put("genero", "N");
            obj.put("DNI", p.getDNI());
            obj.put("email", p.getEmail());
            obj.put("telefono", p.getTelefono());
            obj.put("contrasenia", p.getContrasenia());
            arrayPasa.add(obj);
        }
        return arrayPasa;
    }
    public JSONArray choferesToJSON(){
        JSONArray arrayChof= new JSONArray();
        Enumeration <Chofer> cf = this.getChoferes().elements();
        while  (cf.hasMoreElements()){
            Chofer c = cf.nextElement();
            JSONObject obj = new JSONObject();
            obj.put("nombres", c.getNombres());
            obj.put("apellidoPat", c.getApellidoPat());
            obj.put("apellidoMat", c.getApellidoMat());
            if(c.getGenero()=='M') {
                obj.put("genero", "M");
            }
            else if (c.getGenero()=='F'){
                obj.put("genero", "F");
            }
            else obj.put("genero", "N");
            obj.put("DNI", c.getDNI());
            obj.put("email", c.getEmail());
            obj.put("contrasenia", c.getContrasenia());
            obj.put("telefono", c.getTelefono());
            arrayChof.add(obj);
        }
        return arrayChof;
    }
}
