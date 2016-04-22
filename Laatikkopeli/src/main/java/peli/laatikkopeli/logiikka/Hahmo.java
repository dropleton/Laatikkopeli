/**
 * Perii luokalta Peliolio liikkumiseen tarvittavat metodit.
 */
package peli.laatikkopeli.logiikka;

import static com.sun.javafx.runtime.SystemProperties.getCodebase;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.rmi.CORBA.Util;
import javax.swing.ImageIcon;

public class Hahmo extends Peliolio {

    private Image image;

    public Hahmo(int x, int y) {
        super(x, y);

        try {
//            URL polku = this.getClass().getResource("/Laatikkopeli/Resources/Textures/Hahmo.png");

            URL imgURL = this.getClass().getResource("/Textures/Hahmo.png");

//            BufferedImage img = null;
//            try {
//                img = ImageIO.read(this.getClass().getResource("/Resources/Textures/Hahmo.png"));
//            } catch (IOException e) {
//                System.out.println("Hahmon polku ei edelleenkään toimi");
//            }
//            
            ImageIcon icon = new ImageIcon(imgURL);
//            this.setImage(icon.getImage());
//            this.image = img;
//            this.setImage(image);
        } catch (Exception e) {
            System.out.println("Hahmon polku ei toimi");
        }
    }

    public void liiku(int x, int y) {
        int uusix = this.getX() + x;
        int uusiy = this.getY() + y;
        this.setX(uusix);
        this.setY(uusiy);
    }

//    public void piirra(Graphics graphics) {
//        graphics.setColor(Color.red);
//        graphics.fillOval(this.ruutu.getX(), this.ruutu.getY(), 100, 100);
//    }
//
//    @Override
//    public String toString() {
//        return "Olen ruudussa " + this.ruutu.toString();
//    }
//    
//    public void update() {
//        
//    }
}
