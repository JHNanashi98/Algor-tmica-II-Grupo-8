package entidades;
public class Viaje {
    private String codViaje;
    private Pasajero usuario;
    private Ruta ruta;
    private Double monto;
    private double progreso;

    private boolean completado;
    public boolean getCompletado(){
        return completado;
    }
}
