package peli.laatikkopeli.kayttoliittyma;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import peli.laatikkopeli.logiikka.*;

public class NappaimistonKuuntelijaTest {

    Pelikentta kentta;
    Hahmo hahmo;
    NappaimistonKuuntelija kuuntelija;
    
    @Before
    public void setUp() {
        this.kentta = new Pelikentta(2, 3);
        this.hahmo = new Hahmo(this.kentta.getRuudut()[0][1]);
        this.kuuntelija = new NappaimistonKuuntelija(this.hahmo, this.kentta);
    }

    public NappaimistonKuuntelijaTest() {
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
    public void konstruktoriAsettaaArvotOikein() {
        assertEquals(this.kuuntelija.toString(), "Olen ruudussa (0,1) false");
    }
    
//    @Test
//    public void nappaimetLiikuttavatHahmoa() {
//        this.hahmo.liikuYlos();
//        
//    }
}
