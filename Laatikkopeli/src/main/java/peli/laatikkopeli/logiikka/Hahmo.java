package peli.laatikkopeli.logiikka;

import java.awt.Color;
import java.awt.Graphics;

public class Hahmo {

    private Ruutu ruutu;

    public Hahmo(Ruutu ruutu) {
        this.ruutu = ruutu;
    }

    public void liikuYlos() {
        if (this.ruutu.getYla() != null) {
            this.ruutu = this.ruutu.getYla();
        }
    }

    public void liikuAlas() {
        if (this.ruutu.getAla() != null) {
            this.ruutu = this.ruutu.getAla();
        }
    }

    public void liikuVasemmalle() {
        if (this.ruutu.getVasen() != null) {
            this.ruutu = this.ruutu.getVasen();
        }
    }

    public void liikuOikealle() {
        if (this.ruutu.getOikea() != null) {
            this.ruutu = this.ruutu.getOikea();
        }
    }
    
    public void piirra(Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.fillOval(this.ruutu.getX(), this.ruutu.getY(), 10, 10);
    }

    @Override
    public String toString() {
        return "Olen ruudussa " + this.ruutu.toString();
    }
}
