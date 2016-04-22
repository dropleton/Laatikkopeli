/**
 * Perii luokalta Peliolio liikkumiseen tarvittavat metodit.
 */

package peli.laatikkopeli.logiikka;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class Laatikko extends Peliolio {
//    private boolean onMaalissa;
    private Image image;

    public Laatikko(int x, int y) {
        super(x, y);
        URL polku = this.getClass().getResource("");
        ImageIcon icon = new ImageIcon(polku);
        this.image = icon.getImage();
        this.setImage(image);
//        this.onMaalissa = false;
    }
    
    public void liiku(int x, int y) {
        int uusix = this.getX() + x;
        int uusiy = this.getY() + y;
        this.setX(uusix);
        this.setY(uusiy);
    }
    
//    public void piirra(Graphics graphics) {
//        graphics.setColor(Color.BLUE);
//        graphics.fillRect(this.ruutu.getX(), this.ruutu.getY(), 100, 100);
//        graphics.setColor(Color.white);
//        graphics.drawRect(this.ruutu.getX(), this.ruutu.getY(), 1, 1);
//    }
//
//    @Override
//    public String toString() {
//        return "Olen laatikko ja ruudussa " + this.ruutu.toString();
//    }

//    public boolean onMaalissa() {
//        if(this.ruutu.onkoMaaliruutu()) {
//            return true;
//        }
//        return false;
//    }
}
