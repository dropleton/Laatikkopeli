package peli.laatikkopeli.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import peli.laatikkopeli.kayttoliittyma.*;

public class PeliolioTest {
    Pelikentta kentta;
    
    @Before
    public void setUp() {
        this.kentta = new Pelikentta(1, 1);
    }
    
    public PeliolioTest() {
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
    public void peliolioEiSiirryKentanUlkopuolelle() {
        this.kentta.getHahmo().liikuAlas();
        assertEquals(kentta.getHahmo().toString(), "Olen ruudussa (0,0)");
        this.kentta.getHahmo().liikuOikealle();
        assertEquals(kentta.getHahmo().toString(), "Olen ruudussa (0,0)");
        this.kentta.getHahmo().liikuVasemmalle();
        assertEquals(kentta.getHahmo().toString(), "Olen ruudussa (0,0)");
        this.kentta.getHahmo().liikuYlos();
        assertEquals(kentta.getHahmo().toString(), "Olen ruudussa (0,0)");
    }
    
}
