/**
 * Sisältää kaksiulotteisen taulukon Ruutuja, ArrayListiin tallennetut
 * Laatikot ja Hahmon.
 */
package peli.laatikkopeli.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import peli.laatikkopeli.logiikka.*;

public class Pelikentta extends JPanel {

    private int OFFSET;
    private int KOKO;
    private int TORMAYS_OIKEA;
    private int TORMAYS_VASEN;
    private int TORMAYS_YLA;
    private int TORMAYS_ALA;

    private ArrayList laatikot = new ArrayList<>();
    private ArrayList maaliruudut = new ArrayList<>();
    private Hahmo hahmo;
    private int korkeus;
    private int leveys;
    private boolean lapi = false;
    private String level
            = "    ######\n"
            + "    ##   #\n"
            + "    ##$  #\n"
            + "  ####  $##\n"
            + "  ##  $ $ #\n"
            + "#### # ## #   ######\n"
            + "##   # ## #####  ..#\n"
            + "## $  $          ..#\n"
            + "###### ### #@##  ..#\n"
            + "    ##     #########\n"
            + "    ########\n";
//    private int leveys;
//    private int korkeus;
//    private Ruutu[][] ruudut;
//    private ArrayList<Laatikko> laatikot;
//    private Hahmo hahmo;
//    private Ruutu maaliruutu;

    public Pelikentta() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        luoMaailma();

//        super.setBackground(Color.WHITE);
//
//        this.hahmo = null;
//        this.korkeus = korkeus;
//        this.leveys = leveys;
//        this.ruudut = new Ruutu[leveys][korkeus];
//        this.laatikot = new ArrayList();
//        this.maaliruutu = null;
//        luoKentta();
    }

    public int getKorkeus() {
        return this.korkeus;
    }

    public int getLeveys() {
        return this.leveys;
    }

    public final void luoMaailma() {
        int x = OFFSET;
        int y = OFFSET;

        Laatikko l;

        for (int i = 0; i < this.level.length(); i++) {
            char tavara = level.charAt(i);

            switch (tavara) {
                case '\n':
                    y += KOKO;
                    if (this.leveys < x) {
                        this.leveys = x;
                    }   x += OFFSET;
                    break;
                case '#':
                    l = new Laatikko(x, y);
                    this.laatikot.add(l);
                    x += KOKO;
                    break;
                case '$':
                    break;
                case '@':
                    hahmo = new Hahmo(x, y);
                    x += KOKO;
                    break;
                case ' ':
                    x += KOKO;
                    break;
                default:
                    break;
            }
            korkeus = y;
        }
    }

    public void rakennaMaailma(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(0, 0, this.getLeveys(), this.getKorkeus());

        ArrayList maailma = new ArrayList();
        maailma.addAll(this.laatikot);
        maailma.add(this.hahmo);

        for (int i = 0; i < maailma.size(); i++) {
            Peliolio olio = (Peliolio) maailma.get(i);

            if (olio instanceof Hahmo || olio instanceof Laatikko) {
                g.drawImage(olio.getImage(), olio.getX() + 2, olio.getY() + 2, this);
            } else {
                g.drawImage(olio.getImage(), olio.getX(), olio.getY(), this);
            }

            if (lapi) {
                g.setColor(Color.black);
                g.drawString("Peli suoritettu", 25, 20);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        rakennaMaailma(g);
    }

    class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            if (lapi) {
                return;
            }

            int nappain = e.getKeyCode();

            switch (nappain) {
                case KeyEvent.VK_LEFT:
                    if (tormaakoSeinaan(hahmo, TORMAYS_VASEN)) {
                        return;
                    }   if (tormaakoLaatikkoon(TORMAYS_VASEN)) {
                        return;
                    }   hahmo.liiku(-KOKO, 0);
                    break;
                case KeyEvent.VK_RIGHT:
                    if (tormaakoSeinaan(hahmo, TORMAYS_OIKEA)) {
                        return;
                    }   if (tormaakoLaatikkoon(TORMAYS_OIKEA)) {
                        return;
                    }   hahmo.liiku(KOKO, 0);
                    break;
                case KeyEvent.VK_UP:
                    if (tormaakoSeinaan(hahmo, TORMAYS_YLA)) {
                        return;
                    }   if (tormaakoLaatikkoon(TORMAYS_YLA)) {
                        return;
                    }   hahmo.liiku(0, -KOKO);
                    break;
                case KeyEvent.VK_DOWN:
                    if (tormaakoSeinaan(hahmo, TORMAYS_ALA)) {
                        return;
                    }   if (tormaakoLaatikkoon(TORMAYS_ALA)) {
                        return;
                    }   hahmo.liiku(0, KOKO);
                    break;
                default:
                    break;
            }
            repaint();
        }

        private boolean tormaakoSeinaan(Peliolio olio, int tyyppi) {

        }

        private boolean tormaakoLaatikkoon(int tyyppi) {
            if (tyyppi == TORMAYS_VASEN) {
                for (int i = 0; i < laatikot.size(); i++) {
                    Laatikko laatikko = (Laatikko) laatikot.get(i);
                    if (hahmo.voiLiikkuaVasemmalle(laatikko)) {
                        for (int j = 0; j < laatikot.size(); j++) {
                            Laatikko olio = (Laatikko) laatikot.get(j);
                            if (!laatikko.equals(olio)) {
                                if (!laatikko.voiLiikkuaVasemmalle(olio)) {
                                    return true;
                                }
                            }
                            if (tormaakoSeinaan(laatikko, TORMAYS_VASEN)) {
                                return true;
                            }
                        }
                    }
                    laatikko.liiku(-KOKO, 0);
                    onkoLapi();
                }
                return false;

            } else if (tyyppi == TORMAYS_OIKEA) {
                for (int i = 0; i < laatikot.size(); i++) {
                    Laatikko laatikko = (Laatikko) laatikot.get(i);
                    if (hahmo.voiLiikkuaOikealle(laatikko)) {
                        for (int j = 0; j < laatikot.size(); j++) {
                            Laatikko olio = (Laatikko) laatikot.get(j);
                            if (!laatikko.equals(olio)) {
                                if (!laatikko.voiLiikkuaOikealle(olio)) {
                                    return true;
                                }
                            }
                            if (tormaakoSeinaan(laatikko, TORMAYS_OIKEA)) {
                                return true;
                            }
                        }
                    }
                    laatikko.liiku(KOKO, 0);
                    onkoLapi();
                }
                return false;
            } else if (tyyppi == TORMAYS_YLA) {
                for (int i = 0; i < laatikot.size(); i++) {
                    Laatikko laatikko = (Laatikko) laatikot.get(i);
                    if (hahmo.voiLiikkuaYlos(laatikko)) {
                        for (int j = 0; j < laatikot.size(); j++) {
                            Laatikko olio = (Laatikko) laatikot.get(j);
                            if (!laatikko.equals(olio)) {
                                if (!laatikko.voiLiikkuaYlos(olio)) {
                                    return true;
                                }
                            }
                            if (tormaakoSeinaan(laatikko, TORMAYS_YLA)) {
                                return true;
                            }
                        }
                    }
                    laatikko.liiku(0, -KOKO);
                    onkoLapi();
                }
                return false;
            } else if (tyyppi == TORMAYS_ALA) {
                for (int i = 0; i < laatikot.size(); i++) {
                    Laatikko laatikko = (Laatikko) laatikot.get(i);
                    if (hahmo.voiLiikkuaAlas(laatikko)) {
                        for (int j = 0; j < laatikot.size(); j++) {
                            Laatikko olio = (Laatikko) laatikot.get(j);
                            if (!laatikko.equals(olio)) {
                                if (!laatikko.voiLiikkuaAlas(olio)) {
                                    return true;
                                }
                            }
                            if (tormaakoSeinaan(laatikko, TORMAYS_ALA)) {
                                return true;
                            }
                        }
                    }
                    laatikko.liiku(0, KOKO);
                    onkoLapi();
                }
                return false;
            }
            return false;
        }
    }

    public void onkoLapi() {
        int yht = laatikot.size();
        int suoritetut = 0;

        for (int i = 0; i < yht; i++) {
            Laatikko laatikko = (Laatikko) laatikot.get(i);
            for (int j = 0; j < yht; j++) {
                Maaliruutu ruutu = (Maaliruutu) maaliruudut.get(j);
                if (laatikko.getX() == ruutu.getX() && laatikko.getY() == ruutu.getY()) {
                    suoritetut += 1;
                }
            }
        }

        if (yht == suoritetut) {
            lapi = true;
            repaint();
        }
    }

///**
// * Metodi lisää Ruudut taulukkoon, asettaa jokaiselle Ruudulle sen
// * naapuriruudut ja lisää lopuksi Laatikot, Hahmon ja Maaliruudun muiden
// * metodikutsujen avulla.
// */
//    private void luoKentta() {
//        for (int i = 0; i < this.leveys; i++) {
//            for (int j = 0; j < this.korkeus; j++) {
//                this.ruudut[i][j] = new Ruutu(i, j);
//            }
//        }
//        asetaRuudut();
//        asetaHahmo();
//        asetaLaatikot();
//        asetaMaaliruutu();
//    }
///**
// * Asettaa jokaiselle ruudulle naapuriruudut.
// */
//    public void asetaRuudut() {
//        for (int i = 0; i < this.leveys; i++) {
//            for (int j = 0; j < this.korkeus; j++) {
////                if(this.ruudut[i][j].onkoMaaliruutu()) {
////                    
////                }
//                asetaYlapuolinenRuutu(i, j);
//                asetaAlapuolinenRuutu(i, j);
//                asetaVasemmanpuoleinenRuutu(i, j);
//                asetaOikeanpuoleinenRuutu(i, j);
//            }
//        }
//    }
//
//    public void asetaYlapuolinenRuutu(int i, int j) {
//        int x = this.ruudut[i][j].getX();
//        int y = this.ruudut[i][j].getY() + 1;
//        if (y < this.korkeus) {
//            this.ruudut[i][j].setYla(this.ruudut[x][y]);
//            System.out.println("tämä: " + this.ruudut[i][j] + " ylä: " + this.ruudut[x][y]);
//        }
//    }
//
//    public void asetaAlapuolinenRuutu(int i, int j) {
//        int x = this.ruudut[i][j].getX();
//        int y = this.ruudut[i][j].getY() - 1;
//        if (y >= 0) {
//            this.ruudut[i][j].setAla(this.ruudut[x][y]);
//            System.out.println("tämä: " + this.ruudut[i][j] + " ala: " + this.ruudut[x][y]);
//
//        }
//    }
//
//    public void asetaVasemmanpuoleinenRuutu(int i, int j) {
//        int x = this.ruudut[i][j].getX() - 1;
//        int y = this.ruudut[i][j].getY();
//        if (x >= 0) {
//            this.ruudut[i][j].setVasen(this.ruudut[x][y]);
//            System.out.println("tämä: " + this.ruudut[i][j] + " vasen: " + this.ruudut[x][y]);
//        }
//    }
//
//    public void asetaOikeanpuoleinenRuutu(int i, int j) {
//        int x = this.ruudut[i][j].getX() + 1;
//        int y = this.ruudut[i][j].getY();
//        if (x < this.leveys) {
//            this.ruudut[i][j].setOikea(this.ruudut[x][y]);
//            System.out.println("tämä: " + this.ruudut[i][j] + " oikea: " + this.ruudut[x][y]);
//
//        }
//    }
//
///**
// * Asettaa Pelikentalle 2-7 laatikkoa satunnaisesti valittuihin Ruutuihin.
// */
//    public void asetaLaatikot() {
//        Random random = new Random();
//        // laatikoiden maara valilla 2..7
//        int lkm = random.nextInt((7 - 2) + 1) + 2;
//        for (int i = 1; i <= lkm; i++) {
//            Laatikko laatikko = new Laatikko(arvoRuutu());
//            this.laatikot.add(laatikko);
//        }
//    }
//    
//    /**
//     * Asettaa Hahmon satunnaisesti valittuun ruutuun.
//     */
//    public void asetaHahmo() {
//        this.hahmo = new Hahmo(arvoRuutu());
//    }
//    
//    /**
//     * Arpoo satunnaisesti Ruudun Hahmon ja Laatikon asettamista varten.
//     * @return satunnaisesti valittu Ruutu
//     */
//    public Ruutu arvoRuutu() {
//        Random random = new Random();
//        int x = random.nextInt(this.leveys);
//        int y = random.nextInt(this.korkeus);
//        return this.ruudut[x][y];
//    }
//
//    public ArrayList<Laatikko> getLaatikot() {
//        return this.laatikot;
//    }
//
//    public Ruutu[][] getRuudut() {
//        return this.ruudut;
//    }
//
//    public void asetaMaaliruutu() {
//        arvoRuutu().asetaMaaliruuduksi(true);
//    }
//
//    public Ruutu getMaaliruutu() {
//        return this.maaliruutu;
//    }
//
//    public Hahmo getHahmo() {
//        return this.hahmo;
//    }
//
//    public int getKorkeus() {
//        return this.korkeus;
//    }
//
//    public int getLeveys() {
//        return this.leveys;
//    }
//
//    @Override
//    public String toString() {
//        return this.leveys + ", " + this.korkeus;
//    }
//    
//    public void draw(Graphics g) {
//        for(int i = 0; i < this.leveys; i++) {
//            for(int j = 0; j < this.korkeus; j++) {
//                this.ruudut[i][j].piirra(g);
//            }
//        }
//        hahmo.piirra(g);
////        for(Laatikko laatikko : this.laatikot) {
////            laatikko.piirra(g);
////        }
//    }
}
