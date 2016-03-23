package peli.laatikkopeli;

public class Maaliruutu extends Ruutu {
    private int x;
    private int y;
    
    public Maaliruutu(int x, int y) {
        super(x, y);
    }
    
    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + "), maaliruutu";
    }
    
}
