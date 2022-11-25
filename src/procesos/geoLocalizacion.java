package procesos;

import org.jxmapviewer.viewer.GeoPosition;
public class geoLocalizacion {
    public GeoPosition consegirUbicacion(double lat, double longi){
        GeoPosition posicion = new GeoPosition(lat, longi);
        return posicion;
    }
}
