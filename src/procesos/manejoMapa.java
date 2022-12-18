package procesos;

import mapeo.ventanaKeyCab;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;

import org.jxmapviewer.input.MapClickListener;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.*;

import javax.swing.event.MouseInputListener;

public class manejoMapa {
    public void crearMapa() {
        ventanaKeyCab ventana = new ventanaKeyCab();
        JXMapViewer mapa = ventana.getMapa();
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tile = new DefaultTileFactory(info);
        geoLocalizacion geo = new geoLocalizacion();
        mapa.setTileFactory(tile);
        mapa.setAddressLocation(geo.consegirUbicacion(-12.06215203252874, -77.03681945800781));
        mapa.setZoom(8);
        moverMapa(mapa);
        selecionarCoords(mapa);
    }

    public void moverMapa(JXMapViewer mapa) {
        MouseInputListener mouse = new PanMouseInputListener(mapa);
        ZoomMouseWheelListenerCenter zoom = new ZoomMouseWheelListenerCenter(mapa);
        mapa.addMouseListener(mouse);
        mapa.addMouseMotionListener(mouse);
        mapa.addMouseWheelListener(zoom);
    }
    public void selecionarCoords(JXMapViewer mapa) {
        MapClickListener mouse = new MapClickListener(mapa) {
            @Override
            public void mapClicked(GeoPosition geo) {
                System.out.println(geo);
                System.out.println("X:"+geo.getLatitude()+",Y:"+geo.getLongitude());
            }
        };
    }
}
