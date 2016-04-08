package peli.laatikkopeli.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.*;
import peli.laatikkopeli.logiikka.*;

public class Pelikentta extends JPanel {

    private int leveys;
    private int korkeus;
    private Ruutu[][] ruudut;
    private ArrayList<Laatikko> laatikot;
    private Hahmo hahmo;

    public Pelikentta(int korkeus, int leveys) {
        super.setBackground(Color.WHITE);
        this.hahmo = null;
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.ruudut = new Ruutu[leveys][korkeus];
        this.laatikot = new ArrayList();
        luoKentta();
    }

    private void luoKentta() {
        for (int i = 0; i < this.leveys; i++) {
            for (int j = 0; j < this.korkeus; j++) {
                this.ruudut[i][j] = new Ruutu(i, j);
            }
        }
        asetaYlapuolinenRuutu();
        asetaAlapuolinenRuutu();
        asetaVasemmanpuoleinenRuutu();
        asetaOikeanpuoleinenRuutu();

        this.hahmo = new Hahmo(this.ruudut[0][0]);

        asetaLaatikot();
    }

    public void asetaYlapuolinenRuutu() {
//        for (Ruutu ruutu : this.ruudut) {
//            int x = ruutu.getX();
//            int y = ruutu.getY() + 1;
//            for (Ruutu yla : this.ruudut) {
//                if (yla.getX() == x && yla.getY() == y) {
//                    ruutu.setYla(yla);
//                    break;
//                }
//            }
//        }

        for (int i = 0; i < this.leveys; i++) {
            for (int j = 0; j < this.korkeus; j++) {
                int x = this.ruudut[i][j].getX();
                int y = this.ruudut[i][j].getY() + 1;
                if (y < this.korkeus) {
                    this.ruudut[i][j].setYla(this.ruudut[x][y]);
                    System.out.println("tämä: " + this.ruudut[i][j] + " ylä: " + this.ruudut[x][y]);
                }
            }
        }
    }

    public void asetaAlapuolinenRuutu() {
//        for (Ruutu ruutu : this.ruudut) {
//            int x = ruutu.getX();
//            int y = ruutu.getY() - 1;
//            for (Ruutu ala : this.ruudut) {
//                if (ala.getX() == x && ala.getY() == y) {
//                    ruutu.setAla(ala);
//                    break;
//                }
//            }
//        }
        for (int i = 0; i < this.leveys; i++) {
            for (int j = 0; j < this.korkeus; j++) {
                int x = this.ruudut[i][j].getX();
                int y = this.ruudut[i][j].getY() - 1;
                if (y >= 0) {
                    this.ruudut[i][j].setAla(this.ruudut[x][y]);
                    System.out.println("tämä: " + this.ruudut[i][j] + " ala: " + this.ruudut[x][y]);

                }
            }
        }
    }

    public void asetaVasemmanpuoleinenRuutu() {
//        for (Ruutu ruutu : this.ruudut) {
//            int x = ruutu.getX() - 1;
//            int y = ruutu.getY();
//            for (Ruutu vasen : this.ruudut) {
//                if (vasen.getX() == x && vasen.getY() == y) {
//                    ruutu.setVasen(vasen);
//                    break;
//                }
//            }
//        }
        for (int i = 0; i < this.leveys; i++) {
            for (int j = 0; j < this.korkeus; j++) {
                int x = this.ruudut[i][j].getX() - 1;
                int y = this.ruudut[i][j].getY();
                if (x >= 0) {
                    this.ruudut[i][j].setVasen(this.ruudut[x][y]);
                    System.out.println("tämä: " + this.ruudut[i][j] + " vasen: " + this.ruudut[x][y]);

                }
            }
        }
    }

    public void asetaOikeanpuoleinenRuutu() {
//        for (Ruutu ruutu : this.ruudut) {
//            int x = ruutu.getX() + 1;
//            int y = ruutu.getY();
//            for (Ruutu oikea : this.ruudut) {
//                if (oikea.getX() == x && oikea.getY() == y) {
//                    ruutu.setOikea(oikea);
//                    break;
//                }
//            }
//        }
        for (int i = 0; i < this.leveys; i++) {
            for (int j = 0; j < this.korkeus; j++) {
                int x = this.ruudut[i][j].getX() + 1;
                int y = this.ruudut[i][j].getY();
                if (x < this.leveys) {
                    this.ruudut[i][j].setOikea(this.ruudut[x][y]);
                    System.out.println("tämä: " + this.ruudut[i][j] + " oikea: " + this.ruudut[x][y]);

                }
            }
        }
    }

    public void asetaLaatikot() {
        Laatikko laatikko = new Laatikko(this.ruudut[1][2]);
        this.laatikot.add(laatikko);
    }

    public Ruutu[][] getRuudut() {
        return this.ruudut;
    }

    public void asetaMaaliruutu(int x, int y) {
//        for (Ruutu ruutu : this.ruudut) {
//            if (ruutu.getX() == x && ruutu.getY() == y) {
//                ruutu.asetaMaaliruuduksi(true);
//            }
//        }
        this.ruudut[x][y].asetaMaaliruuduksi(true);
    }

    public Ruutu getMaaliruutu() {
//        for (Ruutu ruutu : this.ruudut) {
//            if (ruutu.onkoMaaliruutu()) {
//                return ruutu;
//            }
//        }
//        return null;
        for (int i = 0; i < this.korkeus; i++) {
            for (int j = 0; j < this.leveys; j++) {
                if (this.ruudut[i][j].onkoMaaliruutu()) {
                    return this.ruudut[i][j];
                }
            }
        }
        return null;
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

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        for (int i = 0; i < this.leveys; i++) {
            for (int j = 0; j < this.korkeus; j++) {
                this.ruudut[i][j].piirra(graphics);
            }
        }
        hahmo.piirra(graphics);
        for (Laatikko laatikko : this.laatikot) {
            laatikko.piirra(graphics);
        }
    }
}
