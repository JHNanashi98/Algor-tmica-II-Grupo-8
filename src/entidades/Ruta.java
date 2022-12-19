package entidades;

import org.jxmapviewer.viewer.GeoPosition;
public class Ruta {
    GeoPosition posIni;
    GeoPosition posFin;
    private String ID;
    public String getID(){
                return ID;
    }

    public Ruta(GeoPosition posIni, GeoPosition posFin) {
        this.posIni = posIni;
        this.posFin = posFin;
    }
}
