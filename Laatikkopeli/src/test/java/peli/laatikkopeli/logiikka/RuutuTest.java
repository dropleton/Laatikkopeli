package peli.laatikkopeli.logiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RuutuTest {

    Ruutu ruutu;

    @Before
    public void setUp() {
        ruutu = new Ruutu(4, 6);
    }

    public RuutuTest() {
    }

    @Test
    public void konstruktoriAsettaaArvotOikein() {
        String tulos = this.ruutu.toString();
        assertEquals("(4,6) false", tulos);

    }
}
