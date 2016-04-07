package peli.laatikkopeli.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
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
        frame.setPreferredSize(new Dimension(800, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.add(this.kentta);
        frame.addKeyListener(new NappaimistonKuuntelija(this.hahmo, this.kentta));
    }

    public JFrame getFrame() {
        return frame;
    }
}
