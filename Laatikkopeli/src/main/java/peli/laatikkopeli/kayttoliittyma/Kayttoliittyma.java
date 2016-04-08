package peli.laatikkopeli.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.WindowConstants;
import peli.laatikkopeli.logiikka.*;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Hahmo hahmo;
    private Pelikentta kentta;
//    private Laatikko laatikko;

    public Kayttoliittyma(Pelikentta kentta, Hahmo hahmo) {
        this.hahmo = hahmo;
        this.kentta = kentta;
    }

    @Override
    public void run() {
        frame = new JFrame("Otsikko");
        frame.setPreferredSize(new Dimension(kentta.getLeveys() * 100, kentta.getKorkeus() * 100));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
//        GridLayout ruudukko = new GridLayout(this.kentta.getKorkeus(), this.kentta.getLeveys());
//        container.setLayout(ruudukko);
//        for(Ruutu ruutu : this.kentta.getRuudut()) {
//            
//            container.add(new JButton("porkkana"));
//        }
        container.add(this.kentta);
        frame.addKeyListener(new NappaimistonKuuntelija(this.hahmo, this.kentta));
    }

    public JFrame getFrame() {
        return frame;
    }
}
