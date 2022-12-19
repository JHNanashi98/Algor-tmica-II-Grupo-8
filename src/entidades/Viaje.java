package entidades;

public class Viaje {
    private String codViaje;
    private Chofer chofer;
    private Pasajero usuario;
    private Double monto;
    private Double duracion;
    private boolean completado;
    public boolean getCompletado(){
        return completado;
    }
}
