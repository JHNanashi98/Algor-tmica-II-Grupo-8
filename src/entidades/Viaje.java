package entidades;

public class Viaje {
    private String codViaje;
    private Chofer chofer;
    private Pasajero usuario;
    private Ruta ruta;
    private Double monto;
    private boolean completado;
    public boolean getCompletado(){
        return completado;
    }
}
