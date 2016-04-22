/**
 * Perii luokalta Peliolio liikkumiseen tarvittavat metodit.
 */

package peli.laatikkopeli.logiikka;

import java.awt.Color;
import java.awt.Graphics;

public class Hahmo extends Peliolio {

    public Hahmo(int x, int y) {
        super(x, y);
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
