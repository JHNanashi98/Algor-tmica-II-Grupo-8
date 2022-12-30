package entidades;

import procesos.registroConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Chofer extends Cuenta implements interCuenta
{
    public Chofer(String nombres, String apellidoPat, String apellidoMat, char genero, String telefono, String DNI, String email, String contrasenia)
    {
        super(nombres, apellidoPat, apellidoMat, genero, telefono, DNI, email, contrasenia);
        tipo = "Chofer";
    }

    public Chofer(String email, String contrasenia) {
        super(email,contrasenia);
    }

    @Override
    public void actualizarDatos(registroConfig config, Cuenta cu){
        Chofer c = (Chofer)cu;
        System.out.println("¿Que datos desea actualizar, Chofer o Auto?");
        System.out.println("1) Chofer");
        System.out.println("2) Auto");
        System.out.println("Digite cualquier otro numero regresar al menu anterior");
        Scanner s = new Scanner(System.in);
        HashMap<Chofer, Auto> map = config.getCAMap();
        for(Map.Entry<Chofer,Auto> entrada :map.entrySet()){
            if(entrada.getKey().equals(c)){
                int op = s.nextInt();
                switch (op) {
                    case 1 :
                        actualizarDatosPer(c, s);
                        map.put(c,entrada.getValue());
                        break;
                    case 2:
                        Auto auto = entrada.getValue();
                        actilizadDatosAut(auto, s);
                        map.put(entrada.getKey(),auto);
                        break;
                    default:
                        break;
                }
            }
        }
    }
    public void actualizarDatosPer(Chofer c, Scanner s){
        System.out.println("Sistema Actualizado Datos");
        System.out.println("¿Que dato desea actualizar?");
        System.out.println("1) Nombres");
        System.out.println("2) Apellidos");
        System.out.println("3) Genero");
        System.out.println("4) Telefono");
        System.out.println("5) DNI");
        System.out.println("6) Email");
        System.out.println("7) contraseña");
        int opt = s.nextInt();
        Scanner f = new Scanner(System.in);
        switch (opt){
            case 1:
                System.out.println("Ingrese nombres");
                String nombre = f.nextLine();
                c.setNombres(nombre);
                break;
            case 2:
                System.out.println("Ingrese Apellido Paterno");
                String apellidoP = f.nextLine();
                c.setApellidoMat(apellidoP);
                String apellidoM = f.nextLine();
                System.out.println("Ingrese Apellido Materno");
                c.setApellidoMat(apellidoM);
                break;
            case 3:
                System.out.println("Ingrese Genero");
                char gen = f.next().charAt(0);
                c.setGenero(gen);
                break;
            case 4:
                System.out.println("Ingrese numero telefonico");
                String telf = f.nextLine();
                c.setTelefono(telf);
                break;
            case 5:
                System.out.println("Ingrese DNI");
                String dni = f.nextLine();
                c.setDNI(dni);
                break;
            case 6:
                System.out.println("Ingrese email");
                String email = f.nextLine();
                c.setEmail(email);
                break;
            case 7:
                System.out.println("Ingrese contrasenia");
                String contra = f.nextLine();
                c.setContrasenia(contra);
                break;
        }
    }
    public void actilizadDatosAut(Auto a, Scanner s){
        System.out.println("Sistema Actualizado Datos");
        System.out.println("¿Que dato desea actualizar?");
        System.out.println("1) Placa");
        System.out.println("2) Capacidad");
        System.out.println("3) Marca");
        int opt = s.nextInt();
        Scanner f = new Scanner(System.in);
        switch (opt) {
            case 1:
                System.out.println("Ingrese Placa");
                String placa = f.nextLine();
                a.setPlaca(placa);
                break;
            case 2:
                System.out.println("Ingrese capacidad");
                int capa = f.nextInt();
                a.setCapacidad(capa);
                break;
            case 3:
                System.out.println("Ingrese Marca");
                String marca = f.nextLine();
                a.setMarca(marca);
                break;
        }
    }
    @Override
    public Chofer IniciarSesion(String email, String contra,registroConfig config) {
        HashMap<Chofer, Auto> map = config.getCAMap();
        int i=0;
        Chofer [] chof = new Chofer[map.size()];
        for (Map.Entry<Chofer,Auto> entrada : map.entrySet()) {
            chof[i] =entrada.getKey();
            Chofer chofer = chof[i];
            String email1  = String.valueOf(chofer.getEmail());
            if (email1.equals(email)) {
                if (chofer.getContrasenia().equals(contra)) {
                    return chofer;
                }
                System.out.println("Contraseña incorrecta");
            }
            i++;
        }
        System.out.println("Usuario incorrecto");
        return null;
    }

    @Override
    public void escribePerfil(registroConfig config, Cuenta cu) {
        Chofer c = (Chofer) cu;
        System.out.println("Mostrando datos del Usuario ");
        System.out.println("Nombres "+ c.getNombres());
        System.out.println("Apellidos "+ c.getApellidoPat()+" "+c.getApellidoMat());
        System.out.println("Genero "+ c.getGenero());
        System.out.println("Telefono "+c.getTelefono());
        System.out.println("DNI "+ c.getDNI());
        System.out.println("email "+ c.getEmail());
        System.out.println("contrasenia "+ c.getContrasenia());
        HashMap<Chofer, Auto> map = config.getCAMap();
        for (Map.Entry<Chofer,Auto> entrada : map.entrySet()) {
            if(entrada.getKey().equals(c)) {
                System.out.println("Auto");
                System.out.println("Marca "+entrada.getValue().getMarca());
                System.out.println("Capacidad "+entrada.getValue().getCapacidad());
                System.out.println("Capacidad "+entrada.getValue().getPlaca());
            }
        }
    }

    @Override
    public void mostrarViaje() {

    }
}

