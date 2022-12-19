package entidades.pagos;

import org.jxmapviewer.viewer.GeoPosition;

public abstract class tPago {
    String tipo;
    abstract double calcularPago(GeoPosition lat, GeoPosition lon);
    public String getTipo() {
        return tipo;
    }
}
