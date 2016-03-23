package peli.laatikkopeli.logiikka;

public class Ruutu {

    private int x;
    private int y;
    private boolean varattu;
    private boolean onMaaliruutu;
    private Ruutu yla;
    private Ruutu ala;
    private Ruutu vasen;
    private Ruutu oikea;

    public Ruutu(int x, int y) {
        this.x = x;
        this.y = y;
        this.varattu = false;
        this.onMaaliruutu = false;
        this.yla = null;
        this.ala = null;
        this.vasen = null;
        this.oikea = null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVarattu() {
        return varattu;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setVarattu(boolean varattu) {
        this.varattu = varattu;
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

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ") " + this.onMaaliruutu;
    }
}
