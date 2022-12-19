package entidades.pagos;

import org.jxmapviewer.viewer.GeoPosition;

public abstract class tPago {
    String tipo;

    double porcentPagoEmpresa(double monto){
        monto=monto*0.15;
        return monto;
    }
    abstract double calcularPago(GeoPosition lat, GeoPosition lon);

    public String getTipo() {
        return tipo;
    }
}
