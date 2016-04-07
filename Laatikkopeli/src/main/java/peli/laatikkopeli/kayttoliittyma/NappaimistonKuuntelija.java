package peli.laatikkopeli.kayttoliittyma;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import peli.laatikkopeli.logiikka.*;

public class NappaimistonKuuntelija implements KeyListener {

    private Hahmo hahmo;
    private Component component;

    public NappaimistonKuuntelija(Hahmo hahmo, Component component) {
        this.hahmo = hahmo;
        this.component = component;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            hahmo.liikuVasemmalle();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hahmo.liikuOikealle();
        }

        component.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
