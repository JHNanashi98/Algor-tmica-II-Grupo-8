package entidades;


import java.util.Vector;

public class Chofer extends Cuenta {
    private Vector <Auto> autos;
    public Chofer(String nombres, String apellidoPat, String apellidoMat, char genero, String telefono, String DNI, String email, String contrasenia) {
        super(nombres, apellidoPat, apellidoMat, genero, telefono, DNI, email, contrasenia);
        tipo = "Chofer";
    }

    public Vector<Auto> getAutos() {
        return autos;
    }
}

