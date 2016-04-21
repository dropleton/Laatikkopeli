package peli.laatikkopeli.kayttoliittyma;

import java.awt.*;
import javax.swing.*;

public class Ikkuna {
    
    private static void luoIkkuna() {
        JFrame f = new JFrame();
        f.setTitle("Testi");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
//        Kayttoliittyma liittyma = new Kayttoliittyma();
        f.add(new Panel2());
        f.pack();
        f.setLocationRelativeTo(null);
        
    }
    
    public static void main(String[] args) {
        luoIkkuna();
    }
    
}
