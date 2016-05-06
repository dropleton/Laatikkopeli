package theboxgame.logic;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import theboxgame.entities.*;

public class MovingLogicTest {
    Goal goal;
    Player player;
    ArrayList<Box> boxes;
    ArrayList<Wall> walls;
    ArrayList<Entity> empties;
    World world;
    MovingLogic logic;

    @Before
    public void setUp() {
        String map
                = " 1 \n"
                + "   \n"
                + " 34\n"
                + "  1\n"
                + " 2 \n"
                + " 3 \n"
                + " 3 \n"
                + "   \n";
        int width = 4;
        int height = 5;
        this.world = new World(width, height, map);
        this.goal = world.getGoal();
        this.player = world.getPlayer();
        this.boxes = world.getBoxes();
        this.walls = world.getWalls();
        this.empties = world.getEmpties();
        this.logic = new MovingLogic(this.player, this.walls, this.boxes, this.empties);
    }

    public MovingLogicTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @After
    public void tearDown() {
    }

    public Box getBox() {
        Box theBox = new Box(1, 2);
        for (Box box : boxes) {
            if (box.getTile().toString().equals("1,2")) {
                theBox = box;
            }
        }
        return theBox;
    }

    @Test
    public void movingThePlayerIsPossible() {
        logic.playerMoveUp();
        assertEquals(player.getTile().toString(), "1,3");
        logic.playerMoveDown();
        assertEquals(player.getTile().toString(), "1,4");
        logic.playerMoveLeft();
        assertEquals(player.getTile().toString(), "0,4");
        logic.playerMoveRight();
        assertEquals(player.getTile().toString(), "1,4");
    }

    @Test
    public void playerCanMoveBoxes() {
        Box theBox = getBox();
        logic.playerMoveUp();
        logic.playerMoveUp();
        assertEquals(player.getTile().toString(), "1,2");
        assertEquals(theBox.getTile().toString(), "1,1");
    }

    @Test
    public void playerCannotMoveAWall() {
        Wall theWall = new Wall(2, 3);
        for (Wall wall : walls) {
            if (wall.getTile().toString().equals("2,3")) {
                theWall = wall;
            }
        }
        logic.playerMoveUp();
        logic.playerMoveRight();
        assertEquals(player.getTile().toString(), "1,3");
        assertEquals(theWall.getTile().toString(), "2,3");
    }

    @Test
    public void boxDisappearsInTheGoal() {
        Box theBox = getBox();
        logic.playerMoveLeft();
        logic.playerMoveUp();
        logic.playerMoveUp();
        logic.playerMoveRight();
        logic.playerMoveRight();
        //now the player and the box should both be in the goal tile
        assertEquals(theBox.getTile().toString(), "2,2");
        assertEquals(player.getTile().toString(), "2,2");
    }
    
    @Test
    public void playerCanMoveOnlyOneBoxAtATime() {
        player.moveDown();
        assertEquals(player.getTile().toString(), "1,4");
    }
}
