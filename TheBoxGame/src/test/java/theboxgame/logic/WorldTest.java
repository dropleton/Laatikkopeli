package theboxgame.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import theboxgame.entities.Player;

public class WorldTest {
    World world;

    @Before
    public void setUp() {
        String map
                = " 1 \n"
                + "   \n"
                + " 34\n"
                + "   \n"
                + " 2 \n";
        int width = 4;
        int height = 5;
        this.world = new World(width, height, map);
    }

    public WorldTest() {
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

    @Test
    public void worldCreatesTiles() {
        assertNotEquals(world.getTiles(), null);
        assertEquals(world.getTiles().length, 4);
    }
    
    @Test
    public void worldSetsNeighbourTiles() {
        assertNotEquals(world.getTiles()[2][3].getUp(), null);
        assertNotEquals(world.getTiles()[2][3].getDown(), null);
        assertNotEquals(world.getTiles()[2][3].getLeft(), null);
        assertNotEquals(world.getTiles()[2][3].getRight(), null);
    }
    
    @Test
    public void worldDoesntSetNeighbourTilesOutsideTheWorld() {
        assertEquals(world.getTiles()[3][4].getRight(), null);
        assertEquals(world.getTiles()[3][4].getDown(), null);
        assertEquals(world.getTiles()[0][0].getUp(), null);
        assertEquals(world.getTiles()[0][0].getLeft(), null);
    }
    
    @Test
    public void worldContainsPlayer() {
        assertEquals(world.getPlayer().toString(), "Player");
    }
    
    @Test
    public void worldContainsBoxes() {
        assertNotEquals(world.getBoxes(), null);
    }
    
    @Test
    public void worldContainsWalls() {
        assertNotEquals(world.getWalls(), null);
    }
    
    @Test
    public void worldContainsEmpties() {
        assertNotEquals(world.getEmpties(), null);
    }
    
    @Test
    public void worldContainsGoal() {
        assertEquals(world.getGoal().toString(), "Goal");
    }
}
