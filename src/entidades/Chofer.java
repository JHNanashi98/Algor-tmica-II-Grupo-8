package entidades;

public class Chofer extends Cuenta {
    public Chofer(String nombres, String apellidoPat, String apellidoMat, char genero, String telefono, String DNI, String email, String contrasenia) {
        super(nombres, apellidoPat, apellidoMat, genero, telefono, DNI, email, contrasenia);
        tipo = "Chofer";
    }

}

