package entidades;
import com.google.maps.TimeZoneApi;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Viaje {
    private String codViaje;
    private Pasajero usuario;
    private Ruta ruta;
    private Double monto;
    private double progreso;
    Calendar calendar = new GregorianCalendar();
    private boolean completado;
    public boolean getCompletado(){
        return completado;
    }
}
