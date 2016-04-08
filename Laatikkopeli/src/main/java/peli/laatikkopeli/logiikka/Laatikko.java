package peli.laatikkopeli.logiikka;

import java.awt.Color;
import java.awt.Graphics;

public class Laatikko {

    private Ruutu ruutu;
//    private boolean onMaalissa;

    public Laatikko(Ruutu ruutu) {
        this.ruutu = ruutu;
//        this.onMaalissa = false;
    }

    public void siirraYlos() {
        this.ruutu = this.ruutu.getYla();
    }
    
    public void siirraAlas() {
        this.ruutu = this.ruutu.getAla();
    }
    
    public void siirraVasemmalle() {
        this.ruutu = this.ruutu.getVasen();
    }
    
    public void siirraOikealle() {
        this.ruutu = this.ruutu.getOikea();
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
