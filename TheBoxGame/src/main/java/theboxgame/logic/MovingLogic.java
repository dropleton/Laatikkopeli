/**
 * Luokka sisältää Movablejen liikuttamiseen tarvittavan logiikan tarkastuksineen.
 */
package theboxgame.logic;

import java.util.ArrayList;
import theboxgame.entities.*;

public class MovingLogic {

    private Player player;
    private ArrayList<Box> boxes;
    private ArrayList<Wall> walls;
    private ArrayList<Entity> empties;
    private int boxesLeft;

    private WallCollisions wallCollisions;
    private BoxCollisions boxCollisions;

    public MovingLogic(Player player, ArrayList<Wall> walls, ArrayList<Box> boxes, ArrayList<Entity> empties) {
        this.player = player;
        this.boxes = new ArrayList();
        this.walls = new ArrayList();
        this.empties = new ArrayList();

        init(boxes, walls, empties);

        this.boxesLeft = this.boxes.size();
        this.wallCollisions = new WallCollisions();
        this.boxCollisions = new BoxCollisions();
    }

    private void init(ArrayList<Box> boxes, ArrayList<Wall> walls, ArrayList<Entity> entities) {
        for (Box box : boxes) {
            this.boxes.add(box);
        }
        for (Wall wall : walls) {
            this.walls.add(wall);
        }
        for (Entity empty : entities) {
            this.empties.add(empty);
        }
    }

    /**
     * Metodi tarkistaa, ovatko kaikki laatikot maaliruudussa, eli onko peli
     * suoritettu.
     *
     * @return Totuusarvomuuttuja, ovatko kaikki laatikot maalissa vai eivät
     */
    public boolean isCompleted() {
        if (this.boxesLeft <= 0) {
            return true;
        }
        return false;
    }

    /**
     * Metodi siirtää pelaajaa yhden ruudun ylöspäin, jos yläpuolinen ruutu ei
     * ole seinä tai jos yläpuolisen ruudun ollessa laatikko laatikon
     * yläpuolinen ruutu ei ole seinä eikä laatikko.
     */
    public void playerMoveUp() {
        if (this.player.getTile().getUp() != null) {
            if (!wallCollisions.isAboveAWall(this.player)) {
                if (boxCollisions.isAboveABox(player)) {
                    if (!(boxCollisions.isAboveABox(player.getTile().getUp().getEntity()) || wallCollisions.isAboveAWall(player.getTile().getUp().getEntity()))) {
                        this.player.moveUp();
                        moveBoxUp();
                        this.player.setTile(this.player.getTile().getUp());
                    }
                } else {
                    this.player.moveUp();
                    this.player.setTile(this.player.getTile().getUp());
                }
            }
        }
    }

    /**
     * Metodi siirtää pelaajaa yhden ruudun alaspäin, jos alapuolinen ruutu ei
     * ole seinä tai jos alapuolisen ruudun ollessa laatikko laatikon
     * alapuolinen ruutu ei ole seinä eikä laatikko.
     */
    public void playerMoveDown() {
        if (this.player.getTile().getDown() != null) {
            if (!wallCollisions.isUnderAWall(this.player)) {
                if (boxCollisions.isUnderABox(player)) {
                    if (!(boxCollisions.isUnderABox(player.getTile().getDown().getEntity()) || wallCollisions.isUnderAWall(player.getTile().getDown().getEntity()))) {
                        this.player.moveDown();
                        moveBoxDown();
                        this.player.setTile(this.player.getTile().getDown());
                    }
                } else {
                    this.player.moveDown();
                    this.player.setTile(this.player.getTile().getDown());
                }
            }
        }
    }

    /**
     * Metodi siirtää pelaajaa yhden ruudun vasemmalle, jos vasemmanpuolinen
     * ruutu ei ole seinä tai jos vasemmanpuolisen ruudun ollessa laatikko
     * laatikon vasemmanpuolinen ruutu ei ole seinä eikä laatikko.
     */
    public void playerMoveLeft() {
        if (this.player.getTile().getLeft() != null) {
            if (!wallCollisions.isLeftAWall(this.player)) {
                if (boxCollisions.isLeftABox(player)) {
                    if (!(boxCollisions.isLeftABox(player.getTile().getLeft().getEntity()) || wallCollisions.isLeftAWall(player.getTile().getLeft().getEntity()))) {
                        this.player.moveLeft();
                        moveBoxLeft();
                        this.player.setTile(this.player.getTile().getLeft());
                    }
                } else {
                    this.player.moveLeft();
                    this.player.setTile(this.player.getTile().getLeft());
                }
            }
        }
    }

    /**
     * Metodi siirtää pelaajaa yhden ruudun oikealle, jos oikeanpuolinen ruutu
     * ei ole seinä tai jos oikeanpuolisen ruudun ollessa laatikko laatikon
     * oikeanpuolinen ruutu ei ole seinä eikä laatikko.
     */
    public void playerMoveRight() {
        if (this.player.getTile().getRight() != null) {
            if (!wallCollisions.isRightAWall(this.player)) {
                if (boxCollisions.isRightABox(player)) {
                    if (!(boxCollisions.isRightABox(player.getTile().getRight().getEntity()) || wallCollisions.isRightAWall(player.getTile().getRight().getEntity()))) {
                        this.player.moveRight();
                        moveBoxRight();
                        this.player.setTile(this.player.getTile().getRight());
                    }
                } else {
                    this.player.moveRight();
                    this.player.setTile(this.player.getTile().getRight());
                }
            }
        }
    }

    /**
     * Metodi siirtää laatikkoa ylöspäin, jos laatikko ei törmää seinään tai
     * toiseen laatikkoon.
     */
    public void moveBoxUp() {
        if (this.player.getTile().getUp().getEntity().getId() == 3) {
            for (Box box : this.boxes) {
                if (box.getTile() == this.player.getTile().getUp()) {
                    if (!wallCollisions.isAboveAWall(box)) {
                        if (!boxCollisions.isAboveABox(box)) {
                            box.moveUp();
                            box.getTile().setEntity(new Entity(box.getX(), box.getY()));
                            box.setTile(box.getTile().getUp());
                            if (!isBoxInGoal(box)) {
                                box.getTile().setEntity(box);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Metodi siirtää laatikkoa alaspäin, jos laatikko ei törmää seinään tai
     * toiseen laatikkoon.
     */
    public void moveBoxDown() {
        if (this.player.getTile().getDown().getEntity().getId() == 3) {
            for (Box box : this.boxes) {
                if (box.getTile() == this.player.getTile().getDown()) {
                    if (!wallCollisions.isUnderAWall(box)) {
                        if (!boxCollisions.isUnderABox(box)) {
                            box.moveDown();
                            box.getTile().setEntity(new Entity(box.getX(), box.getY()));
                            box.setTile(box.getTile().getDown());
                            if (!isBoxInGoal(box)) {
                                box.getTile().setEntity(box);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Metodi siirtää laatikkoa vasemmalle, jos laatikko ei törmää seinään tai
     * toiseen laatikkoon.
     */
    public void moveBoxLeft() {
        if (this.player.getTile().getLeft().getEntity().getId() == 3) {
            for (Box box : this.boxes) {
                if (box.getTile() == this.player.getTile().getLeft()) {
                    if (!wallCollisions.isLeftAWall(box)) {
                        if (!boxCollisions.isLeftABox(box)) {
                            box.moveLeft();
                            box.getTile().setEntity(new Entity(box.getX(), box.getY()));
                            box.setTile(box.getTile().getLeft());
                            if (!isBoxInGoal(box)) {
                                box.getTile().setEntity(box);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Metodi siirtää laatikkoa oikealle, jos laatikko ei törmää seinään tai
     * toiseen laatikkoon.
     */
    public void moveBoxRight() {
        if (this.player.getTile().getRight().getEntity().getId() == 3) {
            for (Box box : this.boxes) {
                if (box.getTile() == this.player.getTile().getRight()) {
                    if (!wallCollisions.isRightAWall(box)) {
                        if (!boxCollisions.isRightABox(box)) {
                            box.moveRight();
                            box.getTile().setEntity(new Entity(box.getX(), box.getY()));
                            box.setTile(box.getTile().getRight());
                            if (!isBoxInGoal(box)) {
                                box.getTile().setEntity(box);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Metodi tarkistaa, onko laatikko maaliruudussa.
     *
     * @param box Kutsujametodilta saatu laatikko
     * @return Totuusarvomuuttuja, kertoo onko laatikko maalissa vai ei
     */
    public boolean isBoxInGoal(Box box) {
        if (box.getTile().getEntity().getId() == 4) {
            box = null;
            boxesLeft--;
            return true;
        }
        return false;
    }

}
