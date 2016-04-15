package peli.laatikkopeli.logiikka;

public class Peliolio {

    private Ruutu ruutu;

    public Peliolio(Ruutu ruutu) {
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

}
