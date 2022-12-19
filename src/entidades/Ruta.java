package entidades;

import org.jxmapviewer.viewer.GeoPosition;
public class Ruta {
    GeoPosition posIni;
    GeoPosition posFin;
    private String ID;
    public String getID(){
                return ID;
    }

    public GeoPosition getPosIni() {
        return posIni;
    }

    public void setPosIni(GeoPosition posIni) {
        this.posIni = posIni;
    }

    public GeoPosition getPosFin() {
        return posFin;
    }

    public void setPosFin(GeoPosition posFin) {
        this.posFin = posFin;
    }

    public Ruta(GeoPosition posIni, GeoPosition posFin) {
        this.posIni = posIni;
        this.posFin = posFin;
    }
}
