package procesos;

import mapeo.ventanaKeyCab;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;

import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.DefaultTileFactory;

import javax.swing.event.MouseInputListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;
<<<<<<< HEAD
public class manejoMapa{
    public void crearMapa() {
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tile = new DefaultTileFactory(info);
        ventanaKeyCab ventana = new ventanaKeyCab();
        JXMapViewer mapa = ventana.getMapa();
=======
public class manejoMapa extends configuracion{
    public void crearMapa(configuracion config) {
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tile = new DefaultTileFactory(info);
        ventanaKeyCab ventana = new ventanaKeyCab();
        final JXMapViewer mapa = ventana.getMapa();
>>>>>>> e8e993fce05d34e34df1c43245e4df399a9873e4
        mapa.setTileFactory(tile);
        geoLocalizacion geo = new geoLocalizacion();
        mapa.setAddressLocation(geo.consegirUbicacion(-12.06215203252874, -77.03681945800781));
        mapa.setZoom(8);
        moverMapa(mapa);
        char op;
        do {
            System.out.println("Use el click izquierdo para seleccionar la posicion inicial");
            System.out.println("Use el click derecho para seleccionar la posicion final");
<<<<<<< HEAD
            GeoPosition[] geoI = selecCoordsInicio(mapa);
            GeoPosition[] geoF = selecCoordsFin(mapa);
=======
            GeoPosition[] geoI = selecCoordsInicio(mapa, config);
            GeoPosition[] geoF = selecCoordsFin(mapa, config);
>>>>>>> e8e993fce05d34e34df1c43245e4df399a9873e4
            Scanner s = new Scanner(System.in);
            System.out.println("Confirmar Viaje S/N");
            op = s.next().charAt(0);
            if (op == 'S') {
<<<<<<< HEAD
                System.out.println(geoI[0]);
                System.out.println(geoF[0]);
=======
                for(int i=0;i<geoF.length; i++) {
                    System.out.println(geoI[i]);
                    System.out.println(geoF[i]);
                }
>>>>>>> e8e993fce05d34e34df1c43245e4df399a9873e4
            }
        }while(op != 'S');
    }
    public void moverMapa(JXMapViewer mapa) {
        MouseInputListener mouse = new PanMouseInputListener(mapa);
        ZoomMouseWheelListenerCenter zoom = new ZoomMouseWheelListenerCenter(mapa);
        mapa.addMouseListener(mouse);
        mapa.addMouseMotionListener(mouse);
        mapa.addMouseWheelListener(zoom);
    }
<<<<<<< HEAD
    public GeoPosition[] selecCoordsInicio(JXMapViewer mapa) {
=======
    public GeoPosition[] selecCoordsInicio(JXMapViewer mapa, configuracion config) {
>>>>>>> e8e993fce05d34e34df1c43245e4df399a9873e4
        GeoPosition [] arregloPos = new GeoPosition[1];
        mapa.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1 && e.getButton() == MouseEvent.BUTTON1) {
                    java.awt.Point p = e.getPoint();
                    GeoPosition geo = mapa.convertPointToGeoPosition(p);
                    System.out.println("Punto de partida");
                    System.out.println("X:" + geo.getLatitude() + ",Y:" + geo.getLongitude());
                    arregloPos[0] = geo;
                }
            }
        });
        return arregloPos;
    }
<<<<<<< HEAD
    public GeoPosition[] selecCoordsFin(JXMapViewer mapa) {
=======
    public GeoPosition[] selecCoordsFin(JXMapViewer mapa, configuracion config) {
>>>>>>> e8e993fce05d34e34df1c43245e4df399a9873e4
        GeoPosition [] arregloPos = new GeoPosition[1];
        mapa.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1 && e.getButton() == MouseEvent.BUTTON3) {
                    java.awt.Point p = e.getPoint();
                    GeoPosition geo = mapa.convertPointToGeoPosition(p);
                    System.out.println("Punto de Llegada");
                    System.out.println("X:" + geo.getLatitude() + ",Y:" + geo.getLongitude());
                    arregloPos[0] = geo;
                }
            }
        });
        return arregloPos;
    }
}

