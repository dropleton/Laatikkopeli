/**
 * Graafisen käyttöliittymän frame-olioon lisätty kuuntelija, joka
 * huolehtii nuolinäppäinten kuuntelusta.
 */

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
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                hahmo.liikuVasemmalle();
                break;
            case KeyEvent.VK_RIGHT:
                hahmo.liikuOikealle();
                break;
            case KeyEvent.VK_UP:
                hahmo.liikuAlas();
                break;
            case KeyEvent.VK_DOWN:
                hahmo.liikuYlos();
                break;
            default:
                break;
        }

        component.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public String toString() {
        return this.hahmo.toString();
    }
    
}
