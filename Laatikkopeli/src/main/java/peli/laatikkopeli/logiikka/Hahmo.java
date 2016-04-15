/**
 * Perii luokalta Peliolio liikkumiseen tarvittavat metodit.
 */

package peli.laatikkopeli.logiikka;

import java.awt.Color;
import java.awt.Graphics;

public class Hahmo extends Peliolio {

    public Hahmo(Ruutu ruutu) {
        super(ruutu);
    }
    
    public void piirra(Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.fillOval(this.ruutu.getX(), this.ruutu.getY(), 100, 100);
    }

    @Override
    public String toString() {
        return "Olen ruudussa " + this.ruutu.toString();
    }
}
