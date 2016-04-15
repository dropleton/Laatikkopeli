/**
 * Perii luokalta Peliolio liikkumiseen tarvittavat metodit.
 */

package peli.laatikkopeli.logiikka;

import java.awt.Color;
import java.awt.Graphics;

public class Laatikko extends Peliolio {
//    private boolean onMaalissa;

    public Laatikko(Ruutu ruutu) {
        super(ruutu);
//        this.onMaalissa = false;
    }
    
    public void piirra(Graphics graphics) {
        graphics.setColor(Color.BLUE);
        graphics.fillRect(this.ruutu.getX(), this.ruutu.getY(), 100, 100);
        graphics.setColor(Color.white);
        graphics.drawRect(this.ruutu.getX(), this.ruutu.getY(), 1, 1);
    }

    @Override
    public String toString() {
        return "Olen laatikko ja ruudussa " + this.ruutu.toString();
    }

//    public boolean onMaalissa() {
//        if(this.ruutu.onkoMaaliruutu()) {
//            return true;
//        }
//        return false;
//    }
}
