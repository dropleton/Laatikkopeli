package peli.laatikkopeli;

import peli.laatikkopeli.logiikka.Ruutu;
import peli.laatikkopeli.logiikka.Kentta;
import peli.laatikkopeli.logiikka.Hahmo;

public class Main {

    public static void main(String[] args) {
        Kentta kentta = new Kentta(4, 8);
        kentta.asetaMaaliruutu(3, 5);
        for (Ruutu ruutu : kentta.getRuudut()) {
            System.out.println(ruutu);
        }
        System.out.println("");
        int i = 13;
        System.out.println("Tämä ruutu: " + kentta.getRuudut().get(i));
        System.out.println("Yla: " + kentta.getRuudut().get(i).getYla());
        System.out.println("Ala: " + kentta.getRuudut().get(i).getAla());
        System.out.println("Vasen: " + kentta.getRuudut().get(i).getVasen());
        System.out.println("Oikea: " + kentta.getRuudut().get(i).getOikea());

        System.out.println("");

        Hahmo hahmo = new Hahmo(kentta.getRuudut().get(0));
        System.out.println(hahmo);
        hahmo.liikuAlas();
        System.out.println(hahmo);
        hahmo.liikuAlas();
        System.out.println(hahmo);

    }

}
