import java.util.Scanner;
import java.time.*;

import entidades.Auto;
import entidades.Chofer;
import entidades.Cuenta;
import entidades.Pasajero;

import org.jxmapviewer.JXMapViewer;
import procesos.manejoMapa;
import procesos.registroConfig;
import archivos.jsonConfig;

public class KeyCab {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        registroConfig config = new registroConfig();
        int option;
        jsonConfig js = new jsonConfig();
        js.leerConfig(config);
        System.out.println("Bienvenido seleccione el menu el cual ingresar");
        do {
            js.escribeConfig(config);
            imprimirMenuInicial();
            option = s.nextInt();
            switch (option) {
                case 1:
                    registro(config);
                    break;
                case 2:
                    IniciarSesionPsj(config);
                    break;
                case 3:
                    IniciarSesionChof(config);
                    break;
                case 4:
                    salirApp();
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
    }
    public static void registro(registroConfig config) {
        System.out.println("Menu de registro proceda a llenar sus datos");
        System.out.println("Presione 1 para registarse como Pasajero");
        System.out.println("Presione 2 para registarse como Chofer");
        System.out.println("Presione 3 o otro numero para salir");
        int opc = s.nextInt();
        if(opc ==1 || opc == 2) {
            Scanner f = new Scanner(System.in);
            System.out.println("");
            System.out.println("Llene sus datos basicos");
            System.out.println("Nombres");
            String nombres = f.nextLine();
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
                if (config.creaChofer(c,a)==0) {
                    System.out.println("Usuario creado correctamente");
                }
            }
        }
    }
    public static void IniciarSesionPsj(registroConfig config){
        System.out.println("");
        System.out.println("Ingrese su email");
        String email = s.next();
        System.out.println("Ingrese su contrasenia");
        String contrasenia = s.next();
        jsonConfig js = new jsonConfig();
        Pasajero temp = new Pasajero(email,contrasenia);
        Pasajero p = temp.IniciarSesion(email,contrasenia, config);
        if (p!= null){
            System.out.println("Bievenido " + p.NombreCompleto());
            int option;
            do {
                imprimirMenuPas();
                option = s.nextInt();
                switch (option) {
                    case 1:
                        manejoMapa mapa = new manejoMapa();
                        mapa.crearMapa();
                        System.out.println("Buscando chof.....");
                        LocalDateTime fechViaje = LocalDateTime.now();
                        System.out.println("Dia y Hora de inicio de busqueda "+ fechViaje);
                        System.out.println();
                        break;
                    case 2:
                        System.out.println("Appi no disponible de momento, regrese mas tarde");
                        break;
                    case 3:
                        System.out.println("Datos Actuales");
                        js.escribePerfil(p, p.getTipo());
                        int act;
                        do {
                            p.actualizarDatos(config, p);
                            System.out.println("¿Ha terminado de actualizar todos sus datos?");
                            System.out.println("Presione 2 para terminar la actualizacion");
                            act = s.nextInt();
                        }while (act!=2);
                        break;
                    case 4:
                        System.out.println("Regresando al menu principal.....");
                        break;
                }
            }
            while (option != 4);
        }
    }
    public static void IniciarSesionChof(registroConfig config){
        System.out.println("");
        System.out.println("Ingrese su email");
        String email = s.next();
        System.out.println("Ingrese su contrasenia");
        String contrasenia = s.next();
        jsonConfig js = new jsonConfig();
        Chofer temp = new Chofer(email,contrasenia);
        Chofer c = temp.IniciarSesion(email,contrasenia, config);
        if (c.IniciarSesion(email,contrasenia, config) != null){
            System.out.println("Bievenido " + c.NombreCompleto());
            int option;
            do {
                imprimirMenuChof();
                option = s.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Buscando solicitud de pasajero");
                        break;
                    case 2:
                        System.out.println("Appi no disponible de momento, regrese mas tarde");
                        break;
                    case 3:
                        System.out.println("Datos Actuales");
                        js.escribePerfil(c, c.getTipo());
                        int act;
                        do {
                            c.actualizarDatos(config, c);
                            System.out.println("¿Ha terminado de actualizar todos sus datos?");
                            System.out.println("Presione 2 para terminar la actualizacion");
                            act = s.nextInt();
                        }while (act!=2);
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