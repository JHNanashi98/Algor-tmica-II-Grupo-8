import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import com.google.maps.GeocodingApiRequest;
import com.google.maps.GeolocationApiRequest;
import com.google.maps.GeolocationApi;

import entidades.Auto;
import entidades.Chofer;
import entidades.Pasajero;
import procesos.registroConfig;
import procesos.inicioSesionConfig;
import archivos.jsonConfig;

public class KeyCab {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        registroConfig config = new registroConfig();
        inicioSesionConfig config1 = new inicioSesionConfig();
        int option;
        jsonConfig js = new jsonConfig();
        js.leerConfig(config);
        js.leerConfig2(config1);
        System.out.println("Bienvenido seleccione el menu el cual ingresar");
        do {
            imprimirMenuInicial();
            option = s.nextInt();
            switch (option) {
                case 1:
                    registro(config);
                    break;
                case 2:
                    IniciarSesionPsj(config1);
                    break;
                case 3:
                    IniciarSesionChof(config1);
                    break;
                case 4:
                    salirApp();
                    break;
                case 5:
                    js.escribeConfig(config);
                    break;
            }
        }
        while (option != 4);
    }

    public static void imprimirMenuInicial() {
        System.out.println("");
        System.out.println("Presione 1 para registarse");
        System.out.println("Presione 2 para iniciar sesion como pasajero");
        System.out.println("Presione 3 para iniciar sesion como chofer");
        System.out.println("Presione 4 para salir de la aplicacion");
        System.out.println("Presione 5 para guardar los datos");
    }
    public static void registro(registroConfig config) {
        System.out.println("Menu de registro proceda a llenar sus datos");
        System.out.println("Presione 1 para registarse como Pasajero");
        System.out.println("Presione 2 para registarse como Chofer");
        System.out.println("Presione 3 o otro numero para salir");
        int opc = s.nextInt();
        if(opc ==1 || opc == 2) {
            System.out.println("");
            System.out.println("Llene sus datos basicos");
            System.out.println("Nombres");
            String nombres = s.next();
            System.out.println("Apellido Paterno");
            String apellidoPat = s.next();
            System.out.println("Apellido Materno");
            String apellidoMat = s.next();
            System.out.println("Genero M/F/N");
            char genero = s.next().charAt(0);
            System.out.println("Numero de Telefono");
            String telefono = s.next();
            System.out.println("Numero DNI");
            String DNI = s.next();
            System.out.println("correo electronico");
            String email = s.next();
            System.out.println("Digite una contraseña");
            String contrasenia = s.next();
            if (opc == 1) {
                Pasajero p = new Pasajero(nombres, apellidoPat, apellidoMat, genero, telefono, DNI, email, contrasenia);
                if (config.creaPasajero(p)==0) {
                    System.out.println("Usuario creado correctamente");
                }
            } else {
                System.out.println("Digite los datos de su Auto");
                System.out.println("capacidad");
                int capacidad = s.nextInt();
                System.out.println("Marca");
                String marca = s.next();
                System.out.println("Placa");
                String placa = s.next();
                Auto a = new Auto(capacidad, marca, placa);
                Chofer c = new Chofer(nombres, apellidoPat, apellidoMat, genero, telefono, DNI, email, contrasenia);
                if (config.creaChofer(c)==0) {
                    System.out.println("Usuario creado correctamente");
                }
            }
        }
    }
    public static void IniciarSesionPsj(inicioSesionConfig config1){
        System.out.println("");
        System.out.println("Ingrese su email");
        String email = s.next();
        System.out.println("Ingrese su contrasenia");
        String contrasenia = s.next();
        if (config1.IniciarSesionPasajero(email,contrasenia) == 1){
            int option;
            do {
                imprimirMenuPas();
                option = s.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Introducir ubicacion");
                        System.out.println("Buscando chof.....");
                        Calendar c = new GregorianCalendar();
                        System.out.println("Hora de inicio de busqueda "+c.getTime());
                        break;
                    case 2:
                        System.out.println("Appi no disponible de momento, regrese mas tarde");
                        break;
                    case 3:
                        System.out.println("Cambiar datos o borrar usuario");
                        break;
                    case 4:
                        System.out.println("Regresando al menu principal.....");
                        break;
                }
            }
            while (option != 4);

        }
    }
    public static void IniciarSesionChof(inicioSesionConfig config1){
        System.out.println("");
        System.out.println("Ingrese su email");
        String email = s.next();
        System.out.println("Ingrese su contrasenia");
        String contrasenia = s.next();
        if (config1.IniciarSesionChofer(email,contrasenia) == 1){
            int option;
            do {
                imprimirMenuChof();;
                option = s.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Buscando solicitud de pasajero");
                        break;
                    case 2:
                        System.out.println("Appi no disponible de momento, regrese mas tarde");
                        break;
                    case 3:
                        System.out.println("Cambiar datos o borrar usuario");
                        break;
                    case 4:
                        System.out.println("Regresando al menu principal.....");
                        break;
                }
            }
            while (option != 4);
        }
    }
    public static void imprimirMenuPas(){
        System.out.println("");

        System.out.println("1) Desea Solicitar un Viaje");
        System.out.println("2) Revisar el Historial de Viajes");
        System.out.println("3) Menu de configuracion de Usuario");
        System.out.println("4) Cerrar Sesion");
    }
    public static void imprimirMenuChof(){
        System.out.println("");
        System.out.println("1) Desea aceptar una solicitud de Viaje");
        System.out.println("2) Revisar el Historial de Viajes");
        System.out.println("3) Menu de configuracion de Usuario");
        System.out.println("4) Cerrar Sesion");
    }
    public static void salirApp(){
        System.out.println("");
        System.out.println("Gracias por usar KeyCab!");
    }
}