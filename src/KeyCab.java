import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import entidades.Auto;
import entidades.Chofer;
import entidades.Cuenta;
import entidades.Pasajero;

import procesos.manejoMapa;
import procesos.registroConfig;
import procesos.inicioSesionConfig;
import archivos.jsonConfig;

public class KeyCab {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        registroConfig config = new registroConfig();
        inicioSesionConfig inicio = new inicioSesionConfig();
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
                    IniciarSesionPsj(inicio);
                    break;
                case 3:
                    IniciarSesionChof(inicio);
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
    public static void IniciarSesionPsj(inicioSesionConfig inicio){
        System.out.println("");
        System.out.println("Ingrese su email");
        String email = s.next();
        System.out.println("Ingrese su contrasenia");
        String contrasenia = s.next();
        jsonConfig js = new jsonConfig();
        if (inicio.IniciarSesionPasajero(email,contrasenia) != null){
            Pasajero p = inicio.IniciarSesionPasajero(email,contrasenia);
            System.out.println("Bievenido " + p.NombreCompleto());
            Cuenta cuenta = new Chofer(p.getNombres(), p.getApellidoPat(),p.getApellidoPat(),p.getGenero(),p.getTelefono(),p.getDNI(),p.getEmail(),p.getContrasenia());
            int option;
            do {
                imprimirMenuPas();
                option = s.nextInt();
                switch (option) {
                    case 1:
                        Scanner l = new Scanner(System.in);
                        System.out.println("Introducir ubicacion");
                        System.out.println("Latitud");
                        double lat = l.nextDouble();
                        System.out.println("longitud");
                        double lon= l.nextDouble();
                        manejoMapa mapa = new manejoMapa();
                        mapa.crearMapa(lat, lon);
                        System.out.println("Buscando chof.....");
                        Calendar c = new GregorianCalendar();
                        System.out.println("Hora de inicio de busqueda "+c.getTime());
                        break;
                    case 2:
                        System.out.println("Appi no disponible de momento, regrese mas tarde");
                        break;
                    case 3:
                        System.out.println("Appi no disponible de momento");
                        js.escribePerfil(cuenta, p.getTipo());
                        break;
                    case 4:
                        System.out.println("Regresando al menu principal.....");
                        break;
                }
            }
            while (option != 4);

        }
    }
    public static void IniciarSesionChof(inicioSesionConfig inicio){
        System.out.println("");
        System.out.println("Ingrese su email");
        String email = s.next();
        System.out.println("Ingrese su contrasenia");
        String contrasenia = s.next();
        jsonConfig js = new jsonConfig();
        if (inicio.IniciarSesionChofer(email,contrasenia) != null){
            Chofer c = inicio.IniciarSesionChofer(email,contrasenia);
            Cuenta cuenta = new Chofer(c.getNombres(), c.getApellidoPat(),c.getApellidoPat(),c.getGenero(),c.getTelefono(),c.getDNI(),c.getEmail(),c.getContrasenia());
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
                        System.out.println("Appi no disponible de momento");
                        js.escribePerfil(cuenta, c.getTipo());
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