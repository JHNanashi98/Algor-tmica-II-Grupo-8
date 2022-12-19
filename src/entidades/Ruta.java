package entidades;

import org.jxmapviewer.viewer.GeoPosition;
import java.util.UUID;
public class Ruta {
    GeoPosition posIni;
    GeoPosition posFin;
    private String usuario;
    private UUID uuid;

    public String getUsuario() {
        return usuario;
    }

    public UUID getUuid() {
        return uuid;
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
    public Ruta(GeoPosition posIni, GeoPosition posFin, String usuario, UUID uuid) {
        this.posIni = posIni;
        this.posFin = posFin;
        this.usuario = usuario;
        this.uuid =UUID.randomUUID();
    }
}
