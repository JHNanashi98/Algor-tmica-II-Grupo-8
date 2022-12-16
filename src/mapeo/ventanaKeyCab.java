package mapeo;

import org.jxmapviewer.JXMapViewer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ventanaKeyCab extends JFrame{
    private JLabel panelUb;
    private JTextField ubcActual;
    private JButton buscarBoton;
    private JPanel mapaVentana;
    private JXMapViewer mapa;
    private JPanel panelMapa;
    private JPanel panelDirec;
    private JButton cBoton;

    public ventanaKeyCab() {
        setContentPane(mapaVentana);
        setTitle("MapaKeyCab");
        setSize(1280, 720);
        setVisible(true);
        cBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarVentana();
            }
        });
    }
    public JPanel getMapaVentana() {
        return mapaVentana;
    }
    public JXMapViewer getMapa() {
        return mapa;
    }

    public JButton getcBoton() {
        return cBoton;
    }
    public void cerrarVentana(){
        super.dispose();
    }
}