package peli.laatikkopeli;

import javax.swing.SwingUtilities;
import peli.laatikkopeli.kayttoliittyma.*;
import peli.laatikkopeli.logiikka.Ruutu;
import peli.laatikkopeli.logiikka.Kentta;
import peli.laatikkopeli.logiikka.Hahmo;
import peli.laatikkopeli.logiikka.Laatikko;

public class Main {

    public static void main(String[] args) {

        Pelikentta kentta = new Pelikentta(8, 6);
        kentta.asetaMaaliruutu(1, 2);
        
        Kayttoliittyma liittyma = new Kayttoliittyma(kentta, kentta.getHahmo());
        SwingUtilities.invokeLater(liittyma);

//        for (Ruutu ruutu : kentta.getRuudut()) {
//            System.out.println(ruutu);
//        }
//        System.out.println("");
//        int i = 13;
//        System.out.println("Tämä ruutu: " + kentta.getRuudut().get(i));
//        System.out.println("Yla: " + kentta.getRuudut().get(i).getYla());
//        System.out.println("Ala: " + kentta.getRuudut().get(i).getAla());
//        System.out.println("Vasen: " + kentta.getRuudut().get(i).getVasen());
//        System.out.println("Oikea: " + kentta.getRuudut().get(i).getOikea());
//
//        System.out.println("");
//        System.out.println(hahmo);
//        hahmo.liikuAlas();
//        System.out.println(hahmo);
//        hahmo.liikuAlas();
//        System.out.println(hahmo);
    }

}
