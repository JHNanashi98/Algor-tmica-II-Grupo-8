package archivos;

import entidades.Chofer;
import entidades.Pasajero;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import procesos.registroConfig;
import procesos.inicioSesionConfig;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import entidades.Auto;
public class jsonConfig {
    private String archivo;

    public jsonConfig() {
        this.archivo = "config.json";
    }

    public void leerConfig(registroConfig config) {
        JSONParser parser = new JSONParser();
        try {
            FileReader reader = new FileReader(this.archivo);
            JSONObject obj = (JSONObject) parser.parse(reader);
            leerPas(obj, config);
            leerChof(obj, config);
            System.out.println("Lectura correcta" + obj);
            System.out.println("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void leerConfig2(inicioSesionConfig config1) {
        JSONParser parser = new JSONParser();
        try {
            FileReader reader = new FileReader(this.archivo);
            JSONObject obj = (JSONObject) parser.parse(reader);
            leerPas2(obj, config1);
            leerChof2(obj, config1);
            System.out.println("Lectura correcta" + obj);
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
        System.out.println("Datos guardados");
    }

    public void leerChof(JSONObject jsonObject, registroConfig config) {
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
            /* JSONObject auto = (JSONObject)chof.get("Auto");
            String capa = (String)auto.get("capacidad");
            int capacidad =Integer.parseInt(capa);
            String marca = (String)auto.get("marca");
            String placa = (String)auto.get("placa");
            Auto a = new Auto(capacidad, marca,placa); */
            Chofer c = new Chofer(nombres, apellidoPat, apellidoMat, genero, telefono, DNI, email, contrasenia);
            config.creaChofer(c);
        }
    }
    public void leerPas(JSONObject jsonObject, registroConfig config){
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

    public void leerChof2(JSONObject jsonObject, inicioSesionConfig config1){
        JSONArray arrayChof = (JSONArray) jsonObject.get("Chofer");
        Iterator it = arrayChof.iterator();
        while (it.hasNext()){
            JSONObject chof =(JSONObject) it.next();
            String nombres= (String)chof.get("nombres");
            String apellidoPat= (String)chof.get("apellidoPat");
            String apellidoMat= (String)chof.get("apellidoMat");
            String generoS = (String) chof.get("genero");
            char genero = generoS.charAt(0);
            String telefono= (String)chof.get("telefono");
            String DNI= (String)chof.get("DNI");
            String email= (String)chof.get("email");
            String contrasenia= (String)chof.get("contrasenia");
            /* JSONObject auto = (JSONObject)chof.get("Auto");
            String capa = (String)auto.get("capacidad");
            int capacidad =Integer.parseInt(capa);
            String marca = (String)auto.get("marca");
            String placa = (String)auto.get("placa");
            Auto a = new Auto(capacidad, marca,placa); */
            Chofer c = new Chofer(nombres, apellidoPat, apellidoMat, genero, telefono, DNI, email, contrasenia);
            config1.creaChofer(c);
        }
    }
    public void leerPas2(JSONObject jsonObject, inicioSesionConfig config1){
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
            config1.creaPasajero(p);
        }
    }
    public void escribeDatosChof(){
        JSONParser parser = new JSONParser();
        try{
            Object obj =parser.parse(new FileReader(archivo));
            JSONObject jsonObject =(JSONObject) obj;
            System.out.println("Lectura correcta "+ jsonObject);
            JSONArray array = (JSONArray) jsonObject.get("Chofer");
            System.out.println("");
            for(int i=0; i<array.size(); i++){
                JSONObject jsonObject1 = (JSONObject) array.get(i);
                System.out.println("Datos de Usuario "+ i);
                System.out.println("Nombres "+ jsonObject1.get("nombres"));
                System.out.println("Apellidos "+ jsonObject1.get("apellidoPat")+jsonObject1.get("apellidoMat"));
                System.out.println("Genero "+ jsonObject1.get("genero"));
                System.out.println("Telefono "+ jsonObject1.get("telefono"));
                System.out.println("DNI "+ jsonObject1.get("DNI"));
                System.out.println("email "+ jsonObject1.get("email"));
                System.out.println("Auto"+ jsonObject1.get("Auto"));
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
