/**
 * Graafisen käyttöliittymän piirtämisen hoitava luokka.
 */
package peli.laatikkopeli.kayttoliittyma;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.WindowConstants;
import peli.laatikkopeli.logiikka.*;

public class Kayttoliittyma extends JPanel implements Runnable {
    int leveys = 800;
    int korkeus = 800;
    Dimension dim = new Dimension(leveys, korkeus);
//    private JPanel panel;
//    private JFrame frame;
//    private Hahmo hahmo;
//    private Pelikentta kentta;
//    private Laatikko laatikko;

    public Kayttoliittyma() {
        setPreferredSize(dim);
        setBackground(Color.black);
//        this.hahmo = hahmo;
//        this.kentta = kentta;
//        this.panel = new JPanel();
    }

    @Override
    public void run() {
        update();
        repaint();
//        frame = new JFrame("Peli");
//        frame.setPreferredSize(new Dimension(kentta.getLeveys() * 100, kentta.getKorkeus() * 100));
//
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        luoKomponentit(frame.getContentPane());
//
//        frame.pack();
//        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        
//        Pelikentta kentta = new Pelikentta(8,8);

//        GridLayout ruudukko = new GridLayout(this.kentta.getKorkeus(), this.kentta.getLeveys());
//        panel.setLayout(ruudukko);
//        for (int i = 0; i < this.kentta.getLeveys(); i++) {
//            for (int j = 0; j < this.kentta.getKorkeus(); j++) {
//                panel.add(new Ruutu(i, j));
////                panel.add(this.kentta.getRuudut()[i][j]);
//            }
//        }
////        frame.setLayout(ruudukko);
////        panel.setLayout(ruudukko);
////        GridLayout ruudukko = new GridLayout(this.kentta.getKorkeus(), this.kentta.getLeveys());
//
////        panel.add(this.kentta);
////        panel.addKeyListener(new NappaimistonKuuntelija(this.hahmo, this.kentta));
////        container.add(panel);
////        for(int i = 0; i < this.kentta.getLeveys(); i++) {
////            for(int j = 0; j < this.kentta.getKorkeus(); j++) {
////                
////                container.add(this.kentta.getRuudut()[i][j]);
////                
////            }
////        }
////        container.setLayout(ruudukko);
////        frame.add(panel);
//        container.add(this.panel);
////        frame.addKeyListener(new NappaimistonKuuntelija(this.hahmo, this.kentta));

    }

//    public JFrame getFrame() {
////        return frame;
//    }
    
    private void update() {
        
    }
}
