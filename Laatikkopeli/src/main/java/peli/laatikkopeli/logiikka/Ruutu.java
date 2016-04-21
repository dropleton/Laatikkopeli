/**
 * Luokka sisältää tiedot yksittäisen Ruudun koordinaateista,
 * maaliruudun sijainnin ja Ruudussa mahdollisesti olevan 
 * Peliolion.
 */

package peli.laatikkopeli.logiikka;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import peli.laatikkopeli.kayttoliittyma.NappaimistonKuuntelija;

public class Ruutu extends JLabel { //HUOM HUOM HUOM 

    private NappaimistonKuuntelija kuuntelija;
    private int rivi;
    private int sarake;
    private Peliolio olio;
    private boolean onMaaliruutu;
    private Ruutu yla;
    private Ruutu ala;
    private Ruutu vasen;
    private Ruutu oikea;

    public Ruutu(int x, int y) {
        this.rivi = x;
        this.sarake = y;
        this.olio = null;
        this.onMaaliruutu = false;
        this.yla = null;
        this.ala = null;
        this.vasen = null;
        this.oikea = null;
        setPreferredSize(new Dimension(100, 100));
    }

//    @Override
    public int getRivi() {
        return this.rivi;
    }
    
//    @Override
    public int getSarake() {
        return this.sarake;
    }

    public void setX(int x) {
        this.rivi = x;
    }

    public void setY(int y) {
        this.sarake = y;
    }

    public boolean onkoMaaliruutu() {
        return onMaaliruutu;
    }

    public void asetaMaaliruuduksi(boolean onMaaliruutu) {
        this.onMaaliruutu = onMaaliruutu;
    }

    public void setYla(Ruutu ruutu) {
        this.yla = ruutu;
    }

    public Ruutu getYla() {
        return yla;
    }

    public void setAla(Ruutu ruutu) {
        this.ala = ruutu;
    }

    public Ruutu getAla() {
        return ala;
    }

    public void setVasen(Ruutu ruutu) {
        this.vasen = ruutu;
    }

    public Ruutu getVasen() {
        return vasen;
    }

    public void setOikea(Ruutu ruutu) {
        this.oikea = ruutu;
    }

    public Ruutu getOikea() {
        return oikea;
    }
    
    public void asetaOlio(Peliolio olio) {
        this.olio = olio;
    }
    
    public Peliolio getOlio() {
        return this.olio;
    }

    public void piirra(Graphics graphics) {
        int piirrettavax = this.rivi * 100;
        int piirrettavay = this.sarake * 100;
        if (this.onMaaliruutu) {
            graphics.setColor(Color.green);
            graphics.fillRect(piirrettavax, piirrettavay, 100, 100);
        } else {
            graphics.setColor(Color.black);
            graphics.fillRect(piirrettavax, piirrettavay, 100, 100);
            graphics.setColor(Color.white);
            graphics.drawRect(piirrettavax, piirrettavay, 1, 1);
        }
    }

    @Override
    public String toString() {
        return "(" + this.rivi + "," + this.sarake + ")";
    }
}
