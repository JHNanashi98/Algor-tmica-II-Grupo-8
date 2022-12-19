package entidades.pagos;

import org.jxmapviewer.viewer.GeoPosition;

import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Yape extends tPago {

    private String celPas;
    private String celChof;

    public Yape(String celPas, String celChof) {
        this.celPas = celPas;
        this.celChof = celChof;
        tipo ="Yape";
    }

    @Override
    public double calcularPago(GeoPosition geoIni, GeoPosition geoFin) {
        double distLat = geoIni.getLatitude() - geoFin.getLatitude();
        double distLon = geoIni.getLongitude() - geoFin.getLongitude();
        distLat = distLat * distLat;
        distLon = distLon * distLon;
        double distDiag = sqrt(distLat + distLon) * 111.1;
        double monto = distDiag *1.92*3.86; // precio promedio cabify
        System.out.println("Digite el telefono al cual se va a hacer una transferencia");
        Scanner s =new Scanner(System.in);
        String celChof = s.next();
        return monto*0.95;
    }

}
