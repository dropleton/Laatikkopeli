/**
 * Sisältää kaksiulotteisen taulukon Ruutuja, ArrayListiin tallennetut 
 * Laatikot ja Hahmon.
 */

package peli.laatikkopeli.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import peli.laatikkopeli.logiikka.*;

public class Pelikentta extends JPanel {

    private int leveys;
    private int korkeus;
    private Ruutu[][] ruudut;
    private ArrayList<Laatikko> laatikot;
    private Hahmo hahmo;
    private Ruutu maaliruutu;

    public Pelikentta(int korkeus, int leveys) {
        super.setBackground(Color.WHITE);

        this.hahmo = null;
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.ruudut = new Ruutu[leveys][korkeus];
        this.laatikot = new ArrayList();
        this.maaliruutu = null;
        luoKentta();
    }
/**
 * Metodi lisää Ruudut taulukkoon, asettaa jokaiselle Ruudulle sen
 * naapuriruudut ja lisää lopuksi Laatikot, Hahmon ja Maaliruudun muiden
 * metodikutsujen avulla.
 */
    private void luoKentta() {
        for (int i = 0; i < this.leveys; i++) {
            for (int j = 0; j < this.korkeus; j++) {
                this.ruudut[i][j] = new Ruutu(i, j);
            }
        }
        asetaRuudut();
        asetaHahmo();
        asetaLaatikot();
        asetaMaaliruutu();
    }
/**
 * Asettaa jokaiselle ruudulle naapuriruudut.
 */
    public void asetaRuudut() {
        for (int i = 0; i < this.leveys; i++) {
            for (int j = 0; j < this.korkeus; j++) {
//                if(this.ruudut[i][j].onkoMaaliruutu()) {
//                    
//                }
                asetaYlapuolinenRuutu(i, j);
                asetaAlapuolinenRuutu(i, j);
                asetaVasemmanpuoleinenRuutu(i, j);
                asetaOikeanpuoleinenRuutu(i, j);
            }
        }
    }

    public void asetaYlapuolinenRuutu(int i, int j) {
        int x = this.ruudut[i][j].getX();
        int y = this.ruudut[i][j].getY() + 1;
        if (y < this.korkeus) {
            this.ruudut[i][j].setYla(this.ruudut[x][y]);
            System.out.println("tämä: " + this.ruudut[i][j] + " ylä: " + this.ruudut[x][y]);
        }
    }

    public void asetaAlapuolinenRuutu(int i, int j) {
        int x = this.ruudut[i][j].getX();
        int y = this.ruudut[i][j].getY() - 1;
        if (y >= 0) {
            this.ruudut[i][j].setAla(this.ruudut[x][y]);
            System.out.println("tämä: " + this.ruudut[i][j] + " ala: " + this.ruudut[x][y]);

        }
    }

    public void asetaVasemmanpuoleinenRuutu(int i, int j) {
        int x = this.ruudut[i][j].getX() - 1;
        int y = this.ruudut[i][j].getY();
        if (x >= 0) {
            this.ruudut[i][j].setVasen(this.ruudut[x][y]);
            System.out.println("tämä: " + this.ruudut[i][j] + " vasen: " + this.ruudut[x][y]);
        }
    }

    public void asetaOikeanpuoleinenRuutu(int i, int j) {
        int x = this.ruudut[i][j].getX() + 1;
        int y = this.ruudut[i][j].getY();
        if (x < this.leveys) {
            this.ruudut[i][j].setOikea(this.ruudut[x][y]);
            System.out.println("tämä: " + this.ruudut[i][j] + " oikea: " + this.ruudut[x][y]);

        }
    }

/**
 * Asettaa Pelikentalle 2-7 laatikkoa satunnaisesti valittuihin Ruutuihin.
 */
    public void asetaLaatikot() {
        Random random = new Random();
        // laatikoiden maara valilla 2..7
        int lkm = random.nextInt((7 - 2) + 1) + 2;
        for (int i = 1; i <= lkm; i++) {
            Laatikko laatikko = new Laatikko(arvoRuutu());
            this.laatikot.add(laatikko);
        }
    }
    
    /**
     * Asettaa Hahmon satunnaisesti valittuun ruutuun.
     */
    public void asetaHahmo() {
        this.hahmo = new Hahmo(arvoRuutu());
    }
    
    /**
     * Arpoo satunnaisesti Ruudun Hahmon ja Laatikon asettamista varten.
     * @return satunnaisesti valittu Ruutu
     */
    public Ruutu arvoRuutu() {
        Random random = new Random();
        int x = random.nextInt(this.leveys);
        int y = random.nextInt(this.korkeus);
        return this.ruudut[x][y];
    }

    public ArrayList<Laatikko> getLaatikot() {
        return this.laatikot;
    }

    public Ruutu[][] getRuudut() {
        return this.ruudut;
    }

    public void asetaMaaliruutu() {
        arvoRuutu().asetaMaaliruuduksi(true);
    }

    public Ruutu getMaaliruutu() {
        return this.maaliruutu;
    }

    public Hahmo getHahmo() {
        return this.hahmo;
    }

    public int getKorkeus() {
        return this.korkeus;
    }

    public int getLeveys() {
        return this.leveys;
    }

    @Override
    public String toString() {
        return this.leveys + ", " + this.korkeus;
    }
    
    public void draw(Graphics g) {
        for(int i = 0; i < this.leveys; i++) {
            for(int j = 0; j < this.korkeus; j++) {
                this.ruudut[i][j].piirra(g);
            }
        }
        hahmo.piirra(g);
//        for(Laatikko laatikko : this.laatikot) {
//            laatikko.piirra(g);
//        }
    }
}
