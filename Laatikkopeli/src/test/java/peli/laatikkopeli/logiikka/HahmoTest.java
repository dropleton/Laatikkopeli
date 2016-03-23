package peli.laatikkopeli.logiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HahmoTest {

    Kentta kentta;
    Hahmo hahmo;
    Kentta pienikentta;
    Hahmo pienihahmo;

    @Before
    public void setUp() {
        this.kentta = new Kentta(3, 4);
        this.hahmo = new Hahmo(this.kentta.getRuudut().get(3));
        this.pienikentta = new Kentta(1, 1);
        this.pienihahmo = new Hahmo(this.pienikentta.getRuudut().get(0));
    }

    public HahmoTest() {
    }

    @Test
    public void konstruktoriAsettaaAloitusruudunOikein() {
        assertEquals(this.hahmo.toString(), "Olen ruudussa (1,4) false");
    }

    @Test
    public void hahmoEiLiikuKentanUlkopuolelle() {
        this.pienihahmo.liikuAlas();
        assertEquals(this.pienihahmo.toString(), "Olen ruudussa (1,1) false");
        this.pienihahmo.liikuOikealle();
        assertEquals(this.pienihahmo.toString(), "Olen ruudussa (1,1) false");
        this.pienihahmo.liikuVasemmalle();
        assertEquals(this.pienihahmo.toString(), "Olen ruudussa (1,1) false");
        this.pienihahmo.liikuYlos();
        assertEquals(this.pienihahmo.toString(), "Olen ruudussa (1,1) false");
    }
}
