package peli.laatikkopeli.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.*;
import peli.laatikkopeli.logiikka.*;

public class Pelikentta extends JPanel {

    private int leveys;
    private int korkeus;
    private ArrayList<Ruutu> ruudut;
    private ArrayList<Laatikko> laatikot;
    private Hahmo hahmo;

    public Pelikentta(int korkeus, int leveys) {
        super.setBackground(Color.WHITE);
        this.hahmo = null;
        this.korkeus = korkeus * 10;
        this.leveys = leveys * 10;
        this.ruudut = new ArrayList();
        this.laatikot = new ArrayList();
        luoKentta();
    }

    private void luoKentta() {
        for (int i = 1; i <= this.leveys; i++) {
            for (int j = 1; j <= this.korkeus; j++) {
                this.ruudut.add(new Ruutu(i, j));
            }
        }
        asetaYlapuolinenRuutu();
        asetaAlapuolinenRuutu();
        asetaVasemmanpuoleinenRuutu();
        asetaOikeanpuoleinenRuutu();
        
        this.hahmo = new Hahmo(this.ruudut.get(20));

        asetaLaatikot();
    }

    public void asetaYlapuolinenRuutu() {
        for (Ruutu ruutu : this.ruudut) {
            int x = ruutu.getX();
            int y = ruutu.getY() + 1;
            for (Ruutu yla : this.ruudut) {
                if (yla.getX() == x && yla.getY() == y) {
                    ruutu.setYla(yla);
                    break;
                }
            }
        }
    }

    public void asetaAlapuolinenRuutu() {
        for (Ruutu ruutu : this.ruudut) {
            int x = ruutu.getX();
            int y = ruutu.getY() - 1;
            for (Ruutu ala : this.ruudut) {
                if (ala.getX() == x && ala.getY() == y) {
                    ruutu.setAla(ala);
                    break;
                }
            }
        }
    }

    public void asetaVasemmanpuoleinenRuutu() {
        for (Ruutu ruutu : this.ruudut) {
            int x = ruutu.getX() - 1;
            int y = ruutu.getY();
            for (Ruutu vasen : this.ruudut) {
                if (vasen.getX() == x && vasen.getY() == y) {
                    ruutu.setVasen(vasen);
                    break;
                }
            }
        }
    }

    public void asetaOikeanpuoleinenRuutu() {
        for (Ruutu ruutu : this.ruudut) {
            int x = ruutu.getX() + 1;
            int y = ruutu.getY();
            for (Ruutu oikea : this.ruudut) {
                if (oikea.getX() == x && oikea.getY() == y) {
                    ruutu.setOikea(oikea);
                    break;
                }
            }
        }
    }

    public void asetaLaatikot() {
        Laatikko laatikko = new Laatikko(this.ruudut.get(4));
        this.laatikot.add(laatikko);
    }

    public ArrayList<Ruutu> getRuudut() {
        return this.ruudut;
    }

    public void asetaMaaliruutu(int x, int y) {
        for (Ruutu ruutu : this.ruudut) {
            if (ruutu.getX() == x && ruutu.getY() == y) {
                ruutu.asetaMaaliruuduksi(true);
            }
        }
    }

    public Ruutu getMaaliruutu() {
        for (Ruutu ruutu : this.ruudut) {
            if (ruutu.onkoMaaliruutu()) {
                return ruutu;
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
        for(Ruutu ruutu : this.ruudut) {
            ruutu.piirra(graphics);
        }
        hahmo.piirra(graphics);
        for(Laatikko laatikko : this.laatikot) {
            laatikko.piirra(graphics);
        }
    }
}