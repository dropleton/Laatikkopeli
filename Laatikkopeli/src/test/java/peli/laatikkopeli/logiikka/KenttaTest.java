//package peli.laatikkopeli.logiikka;
//
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//public class KenttaTest {
//
//    Kentta kentta;
//
//    @Before
//    public void setUp() {
//        this.kentta = new Kentta(4, 5);
//    }
//
//    public KenttaTest() {
//    }
//
//    @Test
//    public void konstruktoriAsettaaKentanKoonOikein() {
//        String vastaus = this.kentta.toString();
//        assertEquals("4, 5", vastaus);
//    }
//
//    @Test
//    public void ylareunanRuudullaEiYlapuolistaRuutua() {
//        this.kentta.asetaYlapuolinenRuutu();
//        for (Ruutu ruutu : this.kentta.getRuudut()) {
//            if (ruutu.getY() == 5) {
//                assertEquals(null, ruutu.getYla());
//            }
//        }
//    }
//
//    @Test
//    public void alareunanRuudullaEiAlapuolistaRuutua() {
//        this.kentta.asetaAlapuolinenRuutu();
//        for (Ruutu ruutu : this.kentta.getRuudut()) {
//            if (ruutu.getY() == 1) {
//                assertEquals(null, ruutu.getAla());
//            }
//        }
//    }
//
//    @Test
//    public void vasemmanReunanRuudullaEiVasemmanpuolistaRuutua() {
//        this.kentta.asetaVasemmanpuoleinenRuutu();
//        for (Ruutu ruutu : this.kentta.getRuudut()) {
//            if (ruutu.getX() == 1) {
//                assertEquals(null, ruutu.getVasen());
//            }
//        }
//    }
//
//    @Test
//    public void oikeanReunanRuudullaEiOikeanpuolistaRuutua() {
//        this.kentta.asetaOikeanpuoleinenRuutu();
//        for (Ruutu ruutu : this.kentta.getRuudut()) {
//            if (ruutu.getX() == 5) {
//                assertEquals(null, ruutu.getOikea());
//            }
//        }
//    }
//
//    @Test
//    public void maaliruudunAsetusOnnistuu() {
//        this.kentta.asetaMaaliruutu(1, 4);
//        String vastaus = this.kentta.getMaaliruutu().toString();
//        assertEquals(vastaus, "(1,4) true");
//    }
//
//    @Test
//    public void maaliruutuOnNullJosSitaEiOleAsetettu() {
//        assertEquals(this.kentta.getMaaliruutu(), null);
//    }
//
//}
