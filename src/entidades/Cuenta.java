package entidades;

public class Cuenta {
    private String nombres;
    private String apellidoPat;
    private String apellidoMat;
    private String telefono;
    private String email;
    private String contrasenia;
    private String DNI;

    private char genero;
    protected String tipo;

    public Cuenta(String nombres, String apellidoPat, String apellidoMat, char genero, String telefono, String DNI ,String email, String contrasenia) {
        this.nombres = nombres;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.genero = genero;
        this.telefono = telefono;
        this.DNI = DNI;
        this.email = email;
        this.contrasenia = contrasenia;
    }
    public String getNombres(){return this.nombres;};
    public String getApellidoPat(){return this.apellidoPat;};
    public String getApellidoMat(){return this.apellidoMat;};
    public char getGenero(){return this.genero;};
    public String getTelefono(){return this.telefono;};
    public String getDNI(){return this.DNI;};
    public String getEmail(){return this.email;};
    public String getContrasenia(){return this.contrasenia;};
    public String NombreCompleto() {
        return nombres + " " + apellidoPat + " " + apellidoMat;
    }

    public String getTipo() {
        return tipo;
    }
}
