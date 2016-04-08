package peli.laatikkopeli.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import peli.laatikkopeli.kayttoliittyma.*;

public class LaatikkoTest {

    Pelikentta kentta;
    Laatikko laatikko;

    @Before
    public void setUp() {
        this.kentta = new Pelikentta(2, 3);
    }

    public LaatikkoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriAsettaaRuudunOikein() {
        assertEquals(kentta.getLaatikot().get(0).toString(), "Olen laatikko ja ruudussa (0,0) false");
    }

    @Test
    public void laatikkoaVoiSiirtaa() {
        kentta.getLaatikot().get(0).siirraYlos();
        assertEquals(this.kentta.getLaatikot().get(0).toString(), "Olen laatikko ja ruudussa (0,1) false");
        kentta.getLaatikot().get(0).siirraOikealle();
        assertEquals(this.kentta.getLaatikot().get(0).toString(), "Olen laatikko ja ruudussa (1,1) false");
        kentta.getLaatikot().get(0).siirraAlas();
        assertEquals(this.kentta.getLaatikot().get(0).toString(), "Olen laatikko ja ruudussa (1,0) false");
        kentta.getLaatikot().get(0).siirraVasemmalle();
        assertEquals(this.kentta.getLaatikot().get(0).toString(), "Olen laatikko ja ruudussa (0,0) false");
    }

}
