/**
 * Luokka sisaltaa kaikki Entity-oliot ja Tilet, sekä hoitaa pelikentän muodostamisen.
 */
package theboxgame.logic;

import java.util.ArrayList;
import theboxgame.entities.*;

public class World {

    private Tile[][] tiles;
    private int width;
    private int height;
    private Player player;
    private Goal goal;
    private ArrayList<Box> boxes;
    private ArrayList<Wall> walls;
    private ArrayList<Entity> empties;

    public World(int width, int height, String map) {
        this.boxes = new ArrayList();
        this.walls = new ArrayList();
        this.empties = new ArrayList();
        this.width = width;
        this.height = height;
        this.tiles = new Tile[width][height];
        createTiles();
        setTiles();
        setEntities(map);
    }

    /**
     * Metodi luo kaksiulotteiseen Tilearrayhin tarvittavat Tilet.
     *
     */
    private void createTiles() {
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                this.tiles[i][j] = new Tile(i, j);
            }
        }
        System.out.println("CreateTiles done");
    }

    /**
     * Metodi asettaa jokaiselle Tilelle sen ylä-, ala-, oikean- ja
     * vasemmanpuoleisen Tilen.
     */
    private void setTiles() {
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                if (j < this.height - 1) {
                    this.tiles[i][j].setDown(this.tiles[i][j + 1]);
                }
                if (j >= 1) {
                    this.tiles[i][j].setUp(this.tiles[i][j - 1]);
                }
                if (i < this.width - 1) {
                    this.tiles[i][j].setRight(this.tiles[i + 1][j]);
                }
                if (i >= 1) {
                    this.tiles[i][j].setLeft(this.tiles[i - 1][j]);
                }
            }
        }
        System.out.println("SetTiles done");
    }

    /**
     * Metodi asettaa jokaiseen Tileen kartan mukaisen Entityn.
     *
     * @param map Luokan Game kautta saatu pelikentän kartta
     */
    private void setEntities(String map) {
        int i = 0;
        int j = 0;
        for (int x = 0; x < map.length(); x++) {
            char item = map.charAt(x);

            if (i < this.width && j < this.height) {
                switch (item) {
                    case '\n':
                        j++;
                        i = 0;
                        break;
                    case ' ':
                        Entity empty = new Entity(i * Tile.TILEWIDTH, j * Tile.TILEHEIGHT);
                        this.tiles[i][j].setEntity(empty);
                        empty.setTile(this.tiles[i][j]);
                        this.empties.add(empty);
                        i++;
                        break;
                    case '2':
                        this.player = new Player(i * Tile.TILEWIDTH, j * Tile.TILEHEIGHT);
                        this.tiles[i][j].setEntity(player);
                        this.player.setTile(this.tiles[i][j]);
                        i++;
                        break;
                    case '1':
                        Wall wall = new Wall(i * Tile.TILEWIDTH, j * Tile.TILEHEIGHT);
                        this.tiles[i][j].setEntity(wall);
                        wall.setTile(this.tiles[i][j]);
                        this.walls.add(wall);
                        i++;
                        break;
                    case '3':
                        Box box = new Box(i * Tile.TILEWIDTH, j * Tile.TILEHEIGHT);
                        this.tiles[i][j].setEntity(box);
                        box.setTile(this.tiles[i][j]);
                        this.boxes.add(box);
                        i++;
                        break;
                    case '4':
                        this.goal = new Goal(i * Tile.TILEWIDTH, j * Tile.TILEHEIGHT);
                        this.tiles[i][j].setEntity(goal);
                        this.goal.setTile(this.tiles[i][j]);
                        i++;
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.println("SetEntities done");
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

    public ArrayList<Entity> getEmpties() {
        return this.empties;
    }
    
    public Tile[][] getTiles() {
        return this.tiles;
    }

}
