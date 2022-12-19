package entidades;

import java.time.LocalDateTime;
import java.time.Duration;

public class Viaje {
    private String codViaje;
    private Pasajero usuario;
    private Double monto;
    private Chofer chofer;
    LocalDateTime inicio;
    LocalDateTime Fin;
    Duration duracion;
    private boolean completado;
    public boolean getCompletado(){
        return completado;
    }
}
