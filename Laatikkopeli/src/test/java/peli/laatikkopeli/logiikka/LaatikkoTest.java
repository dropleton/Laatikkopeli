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
    int i;

    @Before
    public void setUp() {
        this.kentta = new Pelikentta(2, 2);
        i = kentta.getLaatikot().size() - 1;
        this.laatikko = new Laatikko(this.kentta.getRuudut()[0][0]);
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
        assertEquals(this.laatikko.toString(), "Olen laatikko ja ruudussa (0,0)");
    }

//    @Test
//    public void laatikkoaVoiSiirtaa() {
//
//        this.laatikko.liikuYlos();
//        assertEquals(this.laatikko.toString(), "Olen laatikko ja ruudussa (0,1)");
//        this.laatikko.liikuOikealle();
//        assertEquals(this.laatikko.toString(), "Olen laatikko ja ruudussa (1,1)");
//        this.laatikko.liikuAlas();
//        assertEquals(this.laatikko.toString(), "Olen laatikko ja ruudussa (1,0)");
//        this.laatikko.liikuVasemmalle();
//        assertEquals(this.laatikko.toString(), "Olen laatikko ja ruudussa (0,0)");
//    }

}
