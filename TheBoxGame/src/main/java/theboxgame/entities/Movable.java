/**
 * Luokka perii luokan Entity, minkä lisäksi se toteuttaa liikkumiseen tarvittavat metodit. 
 */

package theboxgame.entities;

import java.awt.Graphics;

public class Movable extends Entity {

    public Movable(int x, int y) {
        super(x, y);
    }

    /**
     * Metodi liikuttaa liikkuvaa oliota yhden Tilen verran vasemmalle.
     */
    public void moveLeft() {
        this.x = this.x - Tile.TILEWIDTH;
    }

    /**
     * Metodi liikuttaa liikkuvaa oliota yhden Tilen verran oikealle.
     */
    public void moveRight() {
        this.x = this.x + Tile.TILEWIDTH;
    }

    /**
     * Metodi liikuttaa liikkuvaa oliota yhden Tilen verran ylöspäin.
     */
    public void moveUp() {
        this.y = this.y - Tile.TILEHEIGHT;
    }

    /**
     * Metodi liikuttaa liikkuvaa oliota yhden Tilen verran alaspäin.
     */
    public void moveDown() {
        this.y = this.y + Tile.TILEHEIGHT;
    }

    @Override
    public void render(Graphics g) {

    }

}
