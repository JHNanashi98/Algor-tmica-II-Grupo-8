package mapeo;

import org.jxmapviewer.JXMapViewer;

import javax.swing.*;


public class ventanaKeyCab extends JFrame{
    private JLabel panelUb;
    private JTextField ubcActual;
    private JButton buscarBoton;
    private JPanel mapaVentana;
    private JXMapViewer mapa;

    public ventanaKeyCab(){
        setContentPane(mapaVentana);
        setTitle("MapaKeyCab");
        setSize(1080,720);
        setVisible(true);
    }
    public JPanel getMapaVentana() {
        return mapaVentana;
    }
    public JXMapViewer getMapa() {
        return mapa;
    }
}