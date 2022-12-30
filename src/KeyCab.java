import java.io.*;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.UUID;

import entidades.*;
import org.jxmapviewer.viewer.GeoPosition;
import procesos.manejoMapa;
import procesos.registroConfig;
import archivos.jsonConfig;

public class KeyCab {
    static Scanner s = new Scanner(System.in);
    static File archivopasajero = new File("CUENTAS - PASAJEROS.txt");    // NUEVO, ESTO NO SE MUESTRA EN PANTALLA
    static File archivochofer = new File("CUENTAS - CHOFERES.txt");          // NUEVO, ESTO NO SE MUESTRA EN PANTALLA
    static File datosdelchofer = new File("DATOS DE LOS CHOFERES.txt");     // NUEVO, ESTO SI SE MUESTRA EN PANTALLA

    public static void main(String[] args) throws IOException {
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
        System.out.println("Presione 1 para registrarse");
        System.out.println("Presione 2 para iniciar sesion como pasajero");
        System.out.println("Presione 3 para iniciar sesion como chofer");
        System.out.println("Presione 4 para salir de la aplicacion");
    }
    public static void registro(registroConfig config) throws IOException
    {


        System.out.println("Menu de registro proceda a llenar sus datos");
        System.out.println("Presione 1 para registarse como Pasajero");
        System.out.println("Presione 2 para registarse como Chofer");
        System.out.println("Presione 3 o otro numero para salir");
        int opc = s.nextInt();

        if(opc ==1 || opc == 2)
        {
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


            if (opc == 1)
            {

                Pasajero p = new Pasajero(nombres, apellidoPat, apellidoMat, genero, telefono, DNI, email, contrasenia);

                //"CUENTAS - PASAJEROS.txt"

                FileWriter escritura3 = new FileWriter(archivopasajero, true);

                escritura3.write("\n");
                escritura3.write("-" + p.getNombres());
                escritura3.write("-" + p.getApellidoPat());
                escritura3.write("-" + p.getApellidoMat());
                escritura3.write("-" + p.getGenero());
                escritura3.write("-" + p.getTelefono());
                escritura3.write("-" + p.getDNI());
                escritura3.write("-" + p.getEmail());
                escritura3.write("-" + p.getContrasenia());

                escritura3.close();

                if (config.creaPasajero(p)==0)
                {
                    System.out.println("Usuario creado correctamente");
                }
            }
            else
            {
                //NUEVO
                s.nextLine();
                System.out.println("Horario de trabajo (X a.m. a Y p.m.)");
                String horario = s.nextLine();
                System.out.println("Zona de trabajo");
                String zona = s.nextLine();

                System.out.println("Capacidad Total del auto");
                int capacidad = s.nextInt();
                System.out.println("Marca del auto");
                String marca = s.next();
                System.out.println("Placa del auto");
                String placa = s.next();

                Auto a = new Auto(capacidad, marca, placa);
                Chofer c = new Chofer(nombres, apellidoPat, apellidoMat, genero, telefono, DNI, email, contrasenia);

                //"CUENTAS - CHOFERES.txt"

                Cuenta horarioyzona = new Cuenta("", horario, zona);    // NUEVO, cree CONSTRUCTOR EN CLASE CUENTA

                FileWriter escritura = new FileWriter(archivochofer, true);

                escritura.write("\n");
                escritura.write("-" + c.getNombres());
                escritura.write("-" + c.getApellidoPat());
                escritura.write("-" + c.getApellidoMat());
                escritura.write("-" + c.getGenero());
                escritura.write("-" + c.getTelefono());
                escritura.write("-" + c.getDNI());
                escritura.write("-" + c.getEmail());  // NUEVO
                escritura.write("-" + c.getContrasenia());
                escritura.write("-" + a.getCapacidad());
                escritura.write("-" + a.getMarca());
                escritura.write("-" + a.getPlaca());
                escritura.write("-" + horarioyzona.getHorario());
                escritura.write("-" + horarioyzona.getZona());

                escritura.close();

                //NUEVO

                //"DATOS DE LOS CHOFERES.txt"

                FileWriter escritura2 = new FileWriter(datosdelchofer, true);

                escritura2.write("\n\n\t- Nombres: " + c.getNombres());
                escritura2.write("\n\t- Apellido Paterno: " + c.getApellidoPat());
                escritura2.write("\n\t- Apellido Materno: " + c.getApellidoMat());
                escritura2.write("\n\t- Género: " + c.getGenero());
                escritura2.write("\n\t- Teléfono: " + c.getTelefono());
                escritura2.write("\n\t- DNI: " + c.getDNI());
                escritura2.write("\n\t- E-mail: " + c.getEmail());  // NUEVO
                escritura2.write("\n\t- Capacidad Total del auto: " + a.getCapacidad());
                escritura2.write("\n\t- Marca del auto: " + a.getMarca());
                escritura2.write("\n\t- Placa del auto: " + a.getPlaca());
                escritura2.write("\n\t- Horario de Trabajo: " + horarioyzona.getHorario());
                escritura2.write("\n\t- Zona de Trabajo: " + horarioyzona.getZona());

                escritura2.close();

                if (config.creaChofer(c,a)==0) {
                    System.out.println("Usuario creado correctamente");
                }
            }
        }
    }
    public static void IniciarSesionPsj(registroConfig config) throws IOException
    {
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

                        //ACÁ LEO EL TXT DATOS DE LOS CHOFERES

                        System.out.println("\n\tLea y decida un Chofer Disponible para usted: \n");
                        System.out.println("\n\t\t\tDATOS DE TODOS LOS CHOFERES");

                        String contenido;

                        FileReader lector = new FileReader(datosdelchofer);
                        BufferedReader lectura = new BufferedReader(lector);
                        contenido = lectura.readLine();
                        while (contenido != null) {
                            System.out.println(contenido);
                            contenido = lectura.readLine();
                        }   //NUEVO


                        manejoMapa mapa = new manejoMapa();
                        GeoPosition ini;
                        GeoPosition fin;
                        char c;
                        do {
                            Ruta r = mapa.crearMapa(config);
                            System.out.println("Presione S para enviar solicitud");
                            c= s.next().charAt(0);
                            ini=r.getPosIni();
                            fin=r.getPosFin();
                            p.pagarViaje(ini,fin,p);
                            UUID u = UUID.randomUUID();
                            Ruta ruta = new Ruta(ini, fin, p.getEmail(),u);
                            config.getRutas().add(ruta);
                        }while(c!='S');
                        System.out.println("Buscando chof.....");
                        LocalDateTime fechViaje = LocalDateTime.now();
                        System.out.println("Dia y Hora de inicio de busqueda "+ fechViaje);
                        break;
                    case 2:
                        System.out.println("Appi no disponible de momento, regrese mas tarde");
                        break;
                    case 3:
                        System.out.println("Datos Actuales");
                        p.escribePerfil(config,p);
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
    public static void IniciarSesionChof(registroConfig config)
    {

        System.out.println("");
        System.out.println("Ingrese su email");
        String email = s.next();
        System.out.println("Ingrese su contrasenia");
        String contrasenia = s.next();
        jsonConfig js = new jsonConfig();
        Chofer temp = new Chofer(email,contrasenia);
        Chofer c = temp.IniciarSesion(email,contrasenia, config);
        if (c.IniciarSesion(email,contrasenia, config) != null)
        {
            System.out.println("Bievenido " + c.NombreCompleto());
            int option;
            do {
                imprimirMenuChof();
                option = s.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Buscando la solicitud de pasajero mas cercano");
                        manejoMapa mapa = new manejoMapa();
                        GeoPosition ini;
                        char selec;
                        do {
                            ini = mapa.crearMapa();
                            System.out.println("Presione S aceptar la solicitud");
                            selec= s.next().charAt(0);
                            System.out.println(ini);
                        }while(selec!='S');
                        break;
                    case 2:
                        System.out.println("Appi no disponible de momento, regrese mas tarde");
                        break;
                    case 3:
                        System.out.println("Datos Actuales");
                        c.escribePerfil(config,c);
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
    public static void imprimirMenuPas()
    {
        System.out.println("");
        System.out.println("1) Desea Solicitar un Viaje");
        System.out.println("2) Revisar el Historial de Viajes");
        System.out.println("3) Menu de configuracion de Usuario");
        System.out.println("4) Cerrar Sesion");
    }
    public static void imprimirMenuChof()
    {
        System.out.println("");
        System.out.println("1) Desea aceptar una solicitud de Viaje");
        System.out.println("2) Revisar el Historial de Viajes");
        System.out.println("3) Menu de configuracion de Usuario");
        System.out.println("4) Cerrar Sesion");
    }
    public static void salirApp()
    {
        System.out.println("");
        System.out.println("Gracias por usar KeyCab!");
    }
}