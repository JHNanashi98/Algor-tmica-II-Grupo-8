package entidades.pagos;

import org.jxmapviewer.viewer.GeoPosition;

import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Tarjeta extends tPago{

    private String ccvPas;
    private int mesVencPas;
    private int anioVencPas;
    private String ccvChof;

    public String getCcvPas() {
        return ccvPas;
    }

    public int getMesVencPas() {
        return mesVencPas;
    }

    public int getAnioVencPas() {
        return anioVencPas;
    }
    public String getCcvChof() {
        return ccvChof;
    }

    public Tarjeta(String ccvPas, int mesVencPas, int anioVencPas, String ccvChof) {
        this.ccvPas = ccvPas;
        this.mesVencPas = mesVencPas;
        this.anioVencPas = anioVencPas;
        this.ccvChof = ccvChof;
        tipo="Tarjeta";
    }

    @Override
    public double calcularPago(GeoPosition geoIni, GeoPosition geoFin) {
        double distLat = geoIni.getLatitude() - geoFin.getLatitude();
        double distLon = geoIni.getLongitude() - geoFin.getLongitude();
        distLat = distLat * distLat;
        distLon = distLon * distLon;
        double distDiag = sqrt(distLat + distLon) * 111.1;
        double monto = distDiag *1.92*3.86; // precio promedio cabify
        monto = bancoPago(monto);
        return monto*0.85;
    }
    public double bancoPago(double montoIni){
        double montoF=montoIni;
        System.out.println("De que banco va a efectuar su Pago ");
        System.out.println("1) BCP ");
        System.out.println("2) Interbank ");
        System.out.println("3) Scotiabank ");
        System.out.println("4) Banco de la Nacion ");
        System.out.println("5) Otro ");
        Scanner s = new Scanner(System.in);
        int op = s.nextInt();
        switch(op){
            case 1:
                montoF = montoIni*1.001;
                break;
            case 2:
                montoF = montoIni*1.01;
                break;
            case 3:
                montoF = montoIni*1.002;
                break;
            case 4:
                montoF = montoIni*1.005;
                break;
            case 5:
                montoF = montoIni*1.008;
                break;
        }
        return montoF;
    }

}
