package peli.laatikkopeli.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.WindowConstants;
import peli.laatikkopeli.logiikka.*;

public class Kayttoliittyma implements Runnable {
    private JPanel panel;
    private JFrame frame;
    private Hahmo hahmo;
    private Pelikentta kentta;
//    private Laatikko laatikko;

    public Kayttoliittyma(Pelikentta kentta, Hahmo hahmo) {
        this.hahmo = hahmo;
        this.kentta = kentta;
        this.panel = new JPanel();
    }

    @Override
    public void run() {
        frame = new JFrame("Peli");
        frame.setPreferredSize(new Dimension(kentta.getLeveys() * 100, kentta.getKorkeus() * 100));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        
        GridLayout ruudukko = new GridLayout(this.kentta.getKorkeus(), this.kentta.getLeveys());
//        frame.setLayout(ruudukko);
//        panel.setLayout(ruudukko);
//        GridLayout ruudukko = new GridLayout(this.kentta.getKorkeus(), this.kentta.getLeveys());

//        panel.add(this.kentta);
//        panel.addKeyListener(new NappaimistonKuuntelija(this.hahmo, this.kentta));
//        container.add(panel);
//        for(int i = 0; i < this.kentta.getLeveys(); i++) {
//            for(int j = 0; j < this.kentta.getKorkeus(); j++) {
//                
//                container.add(this.kentta.getRuudut()[i][j]);
//                
//            }
//        }
        container.add(this.kentta);
        frame.addKeyListener(new NappaimistonKuuntelija(this.hahmo, this.kentta));
        
    }

    public JFrame getFrame() {
        return frame;
    }
}
