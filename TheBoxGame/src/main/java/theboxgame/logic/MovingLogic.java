package theboxgame.logic;

import java.util.ArrayList;
import theboxgame.entities.*;
//import theboxgame.input.KeyManager;

public class MovingLogic {
//    private KeyManager manager;

    private Player player;
    private ArrayList<Box> boxes;
    private ArrayList<Wall> walls;
    private ArrayList<Entity> empties;

    public MovingLogic(Player player, ArrayList<Wall> walls, ArrayList<Box> boxes, ArrayList<Entity> empties) {
        this.player = player;
//        this.manager = new KeyManager(this.player);
        this.boxes = new ArrayList();
        this.walls = new ArrayList();
        this.empties = new ArrayList();
        init(boxes, walls, empties);
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

    public Player getPlayer() {
        return this.player;
    }

    public void playerMoveUp() {
        if (this.player.getTile().getUp() != null) {
            if (!collisionToWallUp(this.player)) {
                this.player.moveUp();
                moveBoxUp();
                this.player.setTile(this.player.getTile().getUp());

            }
        }
    }

    public void playerMoveDown() {
        if (this.player.getTile().getDown() != null) {
            if (!collisionToWallDown(this.player)) {
                this.player.moveDown();
                moveBoxDown();
                this.player.setTile(this.player.getTile().getDown());
            }
        }
    }

    public void playerMoveLeft() {
        if (this.player.getTile().getLeft() != null) {
            if (!collisionToWallLeft(this.player)) {
                this.player.moveLeft();
                moveBoxLeft();
                this.player.setTile(this.player.getTile().getLeft());
            }
        }
    }

    public void playerMoveRight() {
        if (this.player.getTile().getRight() != null) {
            if (!collisionToWallRight(this.player)) {
                this.player.moveRight();
                moveBoxRight();
                this.player.setTile(this.player.getTile().getRight());
            }
        }
    }

    public void moveBoxUp() {
        if (this.player.getTile().getUp().getEntity().getId() == 3) {
            for (Box box : this.boxes) {
                if (box.getTile() == this.player.getTile().getUp()) {
                    if (!collisionToWallUp(box)) {
                        if (!collisionToBoxUp(box)) {
                            box.moveUp();
                            box.getTile().setEntity(new Entity(box.getX(), box.getY()));
                            box.setTile(box.getTile().getUp());
                            box.getTile().setEntity(box);
                        }
                    }
                }
            }
        }
    }

    public void moveBoxDown() {
        if (this.player.getTile().getDown().getEntity().getId() == 3) {
            for (Box box : this.boxes) {
                if (box.getTile() == this.player.getTile().getDown()) {
                    if (!collisionToWallDown(box)) {
                        if (!collisionToBoxDown(box)) {
                            box.moveDown();
                            box.getTile().setEntity(new Entity(box.getX(), box.getY()));
                            box.setTile(box.getTile().getDown());
                            box.getTile().setEntity(box);
                        }
                    }
                }
            }
        }
    }

    public void moveBoxLeft() {
        if (this.player.getTile().getLeft().getEntity().getId() == 3) {
            for (Box box : this.boxes) {
                if (box.getTile() == this.player.getTile().getLeft()) {
                    if (!collisionToWallLeft(box)) {
                        if (!collisionToBoxLeft(box)) {
                            box.moveLeft();
                            box.getTile().setEntity(new Entity(box.getX(), box.getY()));
                            box.setTile(box.getTile().getLeft());
                            box.getTile().setEntity(box);
                        }
                    }
                }
            }
        }
    }

    public void moveBoxRight() {
        if (this.player.getTile().getRight().getEntity().getId() == 3) {
            for (Box box : this.boxes) {
                if (box.getTile() == this.player.getTile().getRight()) {
                    if (!collisionToWallRight(box)) {
                        if (!collisionToBoxRight(box)) {
                            box.moveRight();
                            box.getTile().setEntity(new Entity(box.getX(), box.getY()));
                            box.setTile(box.getTile().getRight());
                            box.getTile().setEntity(box);
                        }
                    }
                }
            }
        }
    }

    public boolean collisionToWallUp(Entity entity) {
        if (entity.getTile().getUp().getEntity().getId() == 1) {
            return true;
        }
        return false;
    }

    public boolean collisionToWallDown(Entity entity) {
        if (entity.getTile().getDown().getEntity().getId() == 1) {
            return true;
        }
        return false;
    }

    public boolean collisionToWallRight(Entity entity) {
        if (entity.getTile().getRight().getEntity().getId() == 1) {
            return true;
        }
        return false;
    }

    public boolean collisionToWallLeft(Entity entity) {
        if (entity.getTile().getLeft().getEntity().getId() == 1) {
            return true;
        }
        return false;
    }

    public boolean collisionToBoxRight(Entity e) {
        if (e.getTile().getRight().getRight().getEntity().getId() == 3) {
            return true;
        }
        return false;
    }

    public boolean collisionToBoxLeft(Entity e) {
        if (e.getTile().getLeft().getLeft().getEntity().getId() == 3) {
            return true;
        }
        return false;
    }

    public boolean collisionToBoxUp(Entity e) {
        if (e.getTile().getUp().getUp().getEntity().getId() == 3) {
            return true;
        }
        return false;
    }

    public boolean collisionToBoxDown(Entity e) {
        if (e.getTile().getDown().getDown().getEntity().getId() == 3) {
            return true;
        }
        return false;
    }
}
