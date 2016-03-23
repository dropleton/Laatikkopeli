package peli.laatikkopeli.logiikka;

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
        if (this.ruutu.getYla() != null) {
            this.ruutu = this.ruutu.getOikea();
        }
    }

    @Override
    public String toString() {
        return "Olen ruudussa " + this.ruutu.toString();
    }
}
