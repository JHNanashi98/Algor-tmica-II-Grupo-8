package procesos;

import entidades.Auto;
import entidades.Chofer;
import entidades.Pasajero;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.Iterator;
import java.util.Map;
import java.util.Enumeration;
import java.util.HashMap;

public class registroConfig extends configuracion{
    public int creaChofer(Chofer chof, Auto auto){
        Iterator<Map.Entry<Chofer, Auto>> entrada = this.getMap().entrySet().iterator();
        while(entrada.hasNext()) {
            Map.Entry<Chofer,Auto> entry = entrada.next();
            if(chof.getEmail().equals(entry.getKey().getEmail())){
                System.out.println("Este correo ya se encuentra registrado, intente con otro");
                return 1;
            }
            System.out.println(getMap());
        }
        this.getMap().put(chof,auto);
        System.out.println(getMap());
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
        HashMap<Chofer, Auto> map = this.getMap();
        int i=0;
        Chofer [] chof = new Chofer[map.size()];
        Auto [] aut = new Auto[map.size()];
        for(Map.Entry<Chofer,Auto> entrada : map.entrySet()){
            chof[i] = entrada.getKey();
            aut[i] = entrada.getValue();
            Chofer c = chof[i];
            Auto a = aut[i];
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
            JSONObject obj2= new JSONObject();
            obj2.put("marca",a.getMarca());
            obj2.put("capacidad",String.valueOf(a.getCapacidad()));
            obj2.put("placa",a.getPlaca());
            obj.put("Auto", obj2);
            i++;
        }
        return arrayChof;
    }
}
