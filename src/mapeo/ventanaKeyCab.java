package mapeo;

import org.jxmapviewer.JXMapViewer;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ventanaKeyCab extends JFrame{
    private JLabel panelUb;
    private JTextField ubcActual;
    private JButton buscarBoton;
    private JPanel mapaVentana;
    private JXMapViewer mapa;
    private JPanel panelMapa;
    private JPanel panelDirec;

    public ventanaKeyCab() {
        setContentPane(mapaVentana);
        setTitle("MapaKeyCab");
        setSize(1280, 720);
        setVisible(true);
        mapa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });

    }
    public JPanel getMapaVentana() {
        return mapaVentana;
    }
    public JXMapViewer getMapa() {
        return mapa;
    }

}