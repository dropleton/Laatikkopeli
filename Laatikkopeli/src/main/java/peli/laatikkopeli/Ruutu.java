package peli.laatikkopeli;

public class Ruutu {
    private int x;
    private int y;
    private boolean varattu;

    public Ruutu(int x, int y) {
        this.x = x;
        this.y = y;
        this.varattu = false;
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
    
    
    
}
