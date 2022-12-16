package mapeo;
import javax.swing.*;
import java.awt.*;

public class marcadorPNG extends JButton {
    public String icono;
    public marcadorPNG(){
        this.icono ="src/iconos/marcador.png";
        setContentAreaFilled(false);
        setIcon(new ImageIcon(icono));
        setSize(new Dimension(24,24));
    }
}
