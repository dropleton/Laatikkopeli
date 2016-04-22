package peli.laatikkopeli.logiikka;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class Seina extends Peliolio {

    private Image image;

    public Seina(int x, int y) {
        super(x, y);

        URL polku = this.getClass().getResource("");
        ImageIcon icon = new ImageIcon(polku);
        this.image = icon.getImage();
        this.setImage(image);
    }

}
