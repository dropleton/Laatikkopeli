package theboxgame.theboxgame;

import java.util.ArrayList;
import theboxgame.entities.*;

public class MovingLogic {

    private ArrayList<Entity> entities;
    private Tile[][] tiles;
    private int width;
    private int height;
    private Player player;
    private Goal goal;
    private ArrayList<Box> boxes;
    private ArrayList<Wall> walls;

    public MovingLogic(int width, int height, String map) {
        this.entities = new ArrayList();
        this.boxes = new ArrayList();
        this.walls = new ArrayList();
        this.width = width;
        this.height = height;
        this.tiles = new Tile[width][height];
        createTiles();
        setTiles();
        setEntities(map);
    }

    private void createTiles() {
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                this.tiles[i][j] = new Tile(i, j);
            }
        }
        System.out.println("CreateTiles done");
    }

    private void setTiles() {
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                if (j < this.height - 1) {
                    this.tiles[i][j].setUp(this.tiles[i][j + 1]);
                } else if (j > 1) {
                    this.tiles[i][j].setDown(this.tiles[i][j - 1]);
                } else if (i < this.width - 1) {
                    this.tiles[i][j].setRight(this.tiles[i + 1][j]);
                } else if (i > 1) {
                    this.tiles[i][j].setLeft(this.tiles[i - 1][j]);
                }
            }
        }
        System.out.println("SetTiles done");
    }

    private void setEntities(String map) {
        for (int x = 0; x < map.length(); x++) {
            char item = map.charAt(x);

            for (int i = 0; i < this.width; i++) {
                for (int j = 0; j < this.height; j++) {

                    switch (item) {
                        case '\n':
                            break;
                        case ' ':
                            this.tiles[i][j].setEntity(null);
                            break;
                        case '0':
                            this.player = new Player(i * Tile.TILEWIDTH, j * Tile.TILEHEIGHT);
                            this.tiles[i][j].setEntity(player);
                            this.entities.add(player);
                            break;
                        case '1':
                            Wall wall = new Wall(i * Tile.TILEWIDTH, j * Tile.TILEHEIGHT);
                            this.tiles[i][j].setEntity(wall);
                            this.walls.add(wall);
                            this.entities.add(wall);
                            break;
                        case '2':
                            Box box = new Box(i * Tile.TILEWIDTH, j * Tile.TILEHEIGHT);
                            this.tiles[i][j].setEntity(box);
                            this.entities.add(box);
                            this.boxes.add(box);
                            break;
                        case '3':
                            this.goal = new Goal(i * Tile.TILEWIDTH,j * Tile.TILEHEIGHT);
                            this.tiles[i][j].setEntity(goal);
                            this.entities.add(goal);
                            break;
                        default:
                            break;
                    }
                }
            }
        }

        System.out.println("setEntities done");
    }

    public ArrayList getEntities() {
        return this.entities;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Goal getGoal() {
        return this.goal;
    }

    public ArrayList<Box> getBoxes() {
        return this.boxes;
    }

    public ArrayList<Wall> getWalls() {
        return this.walls;
    }

}
