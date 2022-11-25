package procesos;

import mapeo.ventanaKeyCab;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.TileFactoryInfo;

import javax.swing.event.MouseInputListener;

public class manejoMapa{
    public void crearMapa(double lat, double lon){
        ventanaKeyCab ventana = new ventanaKeyCab();
        JXMapViewer mapa =ventana.getMapa();
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tile = new DefaultTileFactory(info);
        geoLocalizacion geo = new geoLocalizacion();

        mapa.setTileFactory(tile);
        mapa.setAddressLocation(geo.consegirUbicacion(lat,lon));
        mapa.setZoom(1);
        moverMapa(mapa);
    }
    public void moverMapa (JXMapViewer mapa){
        MouseInputListener mouse =new PanMouseInputListener(mapa);
        ZoomMouseWheelListenerCenter zoom = new ZoomMouseWheelListenerCenter(mapa);
        mapa.addMouseListener(mouse);
        mapa.addMouseMotionListener(mouse);
        mapa.addMouseWheelListener(zoom);
    }
}
