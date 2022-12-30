package archivos;

import entidades.Auto;
import entidades.Chofer;
import entidades.Pasajero;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import procesos.registroConfig;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
public class jsonConfig {
    private String archivo;

    public jsonConfig() {
        this.archivo = "src/data/cuentas.json";
    }
    public void leerConfig(registroConfig config) {
        JSONParser parser = new JSONParser();
        try {
            FileReader reader = new FileReader(this.archivo);
            JSONObject obj = (JSONObject) parser.parse(reader);
            leerCrearPas(obj, config);
            leerCrearChof(obj, config);
            System.out.println("Lectura de Json correcta");
            System.out.println("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public void escribeConfig(registroConfig config) {
        JSONObject JSONconfig = new JSONObject();
        JSONconfig.put("Chofer", config.choferesToJSON());
        JSONconfig.put("Pasajero", config.pasajerosToJSON());
        try {
            FileWriter writer = new FileWriter(this.archivo);
            writer.write(JSONconfig.toJSONString());
            writer.flush();
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        System.out.println("Sistema Actualizado");
    }
    public void leerCrearChof(JSONObject jsonObject, registroConfig config) {
        JSONArray arrayChof = (JSONArray) jsonObject.get("Chofer");
        Iterator it = arrayChof.iterator();
        while (it.hasNext()) {
            JSONObject chof = (JSONObject) it.next();
            String nombres = (String) chof.get("nombres");
            String apellidoPat = (String) chof.get("apellidoPat");
            String apellidoMat = (String) chof.get("apellidoMat");
            String generoS = (String) chof.get("genero");
            char genero = generoS.charAt(0);
            String telefono = (String) chof.get("telefono");
            String DNI = (String) chof.get("DNI");
            String email = (String) chof.get("email");
            String contrasenia = (String) chof.get("contrasenia");
            JSONObject auto = (JSONObject)chof.get("Auto");
            String capa = (String) auto.get("capacidad");
            int capacidad =Integer.parseInt(capa);
            String marca = (String)auto.get("marca");
            String placa = (String)auto.get("placa");
            Auto a = new Auto(capacidad,marca,placa);
            Chofer c = new Chofer(nombres, apellidoPat, apellidoMat, genero, telefono, DNI, email, contrasenia);
            config.creaChofer(c,a);
        }
    }
    public void leerCrearPas(JSONObject jsonObject, registroConfig config){
        JSONArray arrayPasj = (JSONArray) jsonObject.get("Pasajero");
        Iterator it = arrayPasj.iterator();
        while (it.hasNext()){
            JSONObject pasj =(JSONObject) it.next();
            String nombres= (String)pasj.get("nombres");
            String apellidoPat= (String)pasj.get("apellidoPat");
            String apellidoMat= (String)pasj.get("apellidoMat");
            String generoS = (String) pasj.get("genero");
            char genero = generoS.charAt(0);
            String telefono= (String)pasj.get("telefono");
            String DNI= (String)pasj.get("DNI");
            String email= (String)pasj.get("email");
            String contrasenia= (String)pasj.get("contrasenia");
            Pasajero p = new Pasajero(nombres, apellidoPat, apellidoMat, genero, telefono, DNI, email, contrasenia);
            config.creaPasajero(p);
        }
    }
    public JSONArray selcTipo(String tipo, JSONObject jsonObject){
        if(tipo.equals("Chofer")){
            JSONArray arrayC = (JSONArray) jsonObject.get("Chofer");
            return arrayC;
        }
        else{
            JSONArray arrayP = (JSONArray) jsonObject.get("Pasajero");
            return arrayP;
        }
    }
}
