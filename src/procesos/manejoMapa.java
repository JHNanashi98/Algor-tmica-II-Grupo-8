package procesos;

import entidades.Ruta;
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
public class manejoMapa{
    public Ruta crearMapa(configuracion config) {
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tile = new DefaultTileFactory(info);
        ventanaKeyCab ventana = new ventanaKeyCab();
        JXMapViewer mapa = ventana.getMapa();
        mapa.setTileFactory(tile);
        geoLocalizacion geo = new geoLocalizacion();
        mapa.setAddressLocation(geo.consegirUbicacion(-12.06215203252874, -77.03681945800781));
        mapa.setZoom(8);
        moverMapa(mapa);
        char op;
        System.out.println("Use el click izquierdo para seleccionar la posicion inicial");
        System.out.println("Use el click derecho para seleccionar la posicion final");
        GeoPosition[] geoI = selecCoordsInicio(mapa);
        GeoPosition[] geoF = selecCoordsFin(mapa);
        Scanner s = new Scanner(System.in);
        System.out.println("Confirmar Ubicacion S/N");
        op = s.next().charAt(0);
           if (op == 'S') {
               System.out.println(geoI[0]);
               System.out.println(geoF[0]);
               ventana.dispose();
               Ruta r = new Ruta(geoI[0], geoF[0]);
           return r;
        }
        return null;
    }
    public void moverMapa(JXMapViewer mapa) {
        MouseInputListener mouse = new PanMouseInputListener(mapa);
        ZoomMouseWheelListenerCenter zoom = new ZoomMouseWheelListenerCenter(mapa);
        mapa.addMouseListener(mouse);
        mapa.addMouseMotionListener(mouse);
        mapa.addMouseWheelListener(zoom);
    }
    public GeoPosition[] selecCoordsInicio(JXMapViewer mapa) {
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
    public GeoPosition[] selecCoordsFin(JXMapViewer mapa) {
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
    public GeoPosition crearMapa() {
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tile = new DefaultTileFactory(info);
        ventanaKeyCab ventana = new ventanaKeyCab();
        JXMapViewer mapa = ventana.getMapa();
        mapa.setTileFactory(tile);
        geoLocalizacion geo = new geoLocalizacion();
        mapa.setAddressLocation(geo.consegirUbicacion(-12.06215203252874, -77.03681945800781));
        mapa.setZoom(8);
        moverMapa(mapa);
        char op;
        System.out.println("Use el click izquierdo para seleccionar su ubicacion Actual");
        GeoPosition[] geoI = selecCoordsInicio(mapa);
        Scanner s = new Scanner(System.in);
        System.out.println("Confirmar Ubicacion S/N");
        op = s.next().charAt(0);
        if (op == 'S') {
            System.out.println(geoI[0]);
            ventana.dispose();
            GeoPosition geoC = geoI[0];
            return geoC;
        }
        return null;
    }
}

