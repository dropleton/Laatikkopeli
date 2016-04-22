/**
 * Pelikentalla Ruudussa oleva Laatikko tai Pelihahmo.
 */
package peli.laatikkopeli.logiikka;

import java.awt.Image;

public class Peliolio {

    private int KOKO;
    private int x;
    private int y;
    private Image image;

//    protected Ruutu ruutu;
    public Peliolio(int x, int y) {
//        this.ruutu = ruutu;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean voiLiikkuaYlos(Peliolio olio) {
        if (this.x == olio.getX() && this.y - KOKO == olio.getY()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean voiLiikkuaAlas(Peliolio olio) {
        if (this.x == olio.getX() && this.y + KOKO == olio.getY()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean voiLiikkuaOikealle(Peliolio olio) {
        if (this.x + KOKO == olio.getX() && this.y == olio.getY()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean voiLiikkuaVasemmalle(Peliolio olio) {
        if (this.x - KOKO == olio.getX() && this.y == olio.getY()) {
            return true;
        } else {
            return false;
        }
    }
    
    public Image getImage() {
        return this.image;
    }
    
    public void setImage(Image image) {
        this.image = image;
    }

//    public void liikuYlos() {
//        if (this.ruutu.getYla() != null) {
//            this.ruutu = this.ruutu.getYla();
//        }
//    }
//
//    public void liikuAlas() {
//        if (this.ruutu.getAla() != null) {
//            this.ruutu = this.ruutu.getAla();
//        }
//    }
//
//    public void liikuVasemmalle() {
//        if (this.ruutu.getVasen() != null) {
//            this.ruutu = this.ruutu.getVasen();
//        }
//    }
//
//    public void liikuOikealle() {
//        if (this.ruutu.getOikea() != null) {
//            this.ruutu = this.ruutu.getOikea();
//        }
//    }
}
