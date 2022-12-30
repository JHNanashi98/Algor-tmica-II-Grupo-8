package entidades;

public class Cuenta{
    private String nombres;
    private String apellidoPat;
    private String apellidoMat;
    private String telefono;
    private String email;
    private String contrasenia;
    private String DNI;
    private char genero;
    protected String tipo;
    //NUEVO
    private String nada;
    private String horario;
    private String zona;

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

    public Cuenta(String email, String contrasenia){
        this.email = email;
        this.contrasenia = contrasenia;
    }

    //NUEVO
    public Cuenta(String nada, String horario, String zona)
    {
        this.nada = nada;
        this.horario = horario;
        this.zona = zona;
    }
    //NUEVO
    public String getHorario() {
        return horario;
    }
    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }
    public void setHorario(String horario) {
        this.horario = horario;
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
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }
}
