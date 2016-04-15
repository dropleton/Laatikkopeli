package peli.laatikkopeli.logiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import peli.laatikkopeli.kayttoliittyma.*;

public class HahmoTest {

    Pelikentta kentta;
    Hahmo hahmo;
    Pelikentta pienikentta;
    Hahmo pienihahmo;

    @Before
    public void setUp() {
        this.kentta = new Pelikentta(3, 4);
        this.hahmo = new Hahmo(this.kentta.getRuudut()[1][2]);
        this.pienikentta = new Pelikentta(1, 1);
        this.pienihahmo = new Hahmo(this.pienikentta.getRuudut()[0][0]);
    }

    public HahmoTest() {
    }

    @Test
    public void konstruktoriAsettaaAloitusruudunOikein() {
        assertEquals(this.hahmo.toString(), "Olen ruudussa (1,2)");
    }

    @Test
    public void hahmoEiLiikuKentanUlkopuolelle() {
        this.pienihahmo.liikuAlas();
        assertEquals(this.pienihahmo.toString(), "Olen ruudussa (0,0)");
        this.pienihahmo.liikuOikealle();
        assertEquals(this.pienihahmo.toString(), "Olen ruudussa (0,0)");
        this.pienihahmo.liikuVasemmalle();
        assertEquals(this.pienihahmo.toString(), "Olen ruudussa (0,0)");
        this.pienihahmo.liikuYlos();
        assertEquals(this.pienihahmo.toString(), "Olen ruudussa (0,0)");
    }
}
