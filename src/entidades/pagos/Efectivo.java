package entidades.pagos;

import org.jxmapviewer.viewer.GeoPosition;

import static java.lang.Math.sqrt;

public class Efectivo extends tPago {

    public Efectivo() {
        tipo ="Efectivo";
    }

    @Override
    public double calcularPago(GeoPosition geoIni, GeoPosition geoFin) {
        double distLat=geoIni.getLatitude()-geoFin.getLatitude();
        double distLon=geoIni.getLongitude()-geoFin.getLongitude();
        distLat=distLat*distLat;
        distLon=distLon*distLon;
        double distDiag = sqrt(distLat+distLon)*111.1;
        double montoNoR =distDiag*1.92*3.86; // precio promedio cabify
        int monto = (int) Math.round(montoNoR);
        return monto;
    }

}
