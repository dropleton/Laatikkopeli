package peli.laatikkopeli;

import java.util.ArrayList;

public class Kentta {

    private int leveys;
    private int korkeus;
    private ArrayList<Ruutu> ruudut;

    public Kentta(int leveys, int korkeus) {
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.ruudut = new ArrayList();
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

    @Override
    public String toString() {
        return this.leveys + ", " + this.korkeus;
    }

}
