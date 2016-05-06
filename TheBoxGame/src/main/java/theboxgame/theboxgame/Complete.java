/**
 * Luokka huolehtii Complete-tekstin piirtämisestä pelin päätyttyä.
 */
package theboxgame.theboxgame;

import java.awt.Graphics;

public class Complete {

    private boolean c;

    public Complete() {
        this.c = false;
    }
    
    /**
     * Metodi piirtää tekstin "complete" kun peli on päättynyt.
     * @param g Luokalta Game saatu graphics-olion ilmentymä
     */

    public void render(Graphics g) {
        if (c) {
            char[] complete = {'c', 'o', 'm', 'p', 'l', 'e', 't', 'e'};
            g.drawChars(complete, 0, complete.length, 10, 30);
        }
    }

    public void setComplete() {
        this.c = true;
    }

    public boolean getComplete() {
        return this.c;
    }
}
