package theboxgame.entities;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TileTest {
    Tile tile;
    
    @Before
    public void setUp() {
        tile = new Tile(20, 30);
    }
    
    public TileTest() {
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
    public void constructorSetsValuesRight() {
        assertEquals(tile.toString(), "20,30");
        assertEquals(Tile.TILEWIDTH, 20);
        assertEquals(Tile.TILEHEIGHT, 20);
    }
    
    @Test
    public void setEntitySetsTheEntity() {
        Entity e = new Entity(20, 30);
        tile.setEntity(e);
        assertEquals(tile.getEntity().toString(), "(20 30)");
    }
    
    @Test
    public void setNeighboursSetsTheNeighbours() {
        Tile up = new Tile(20, 10);
        Tile down = new Tile(20, 50);
        Tile left = new Tile(0, 30);
        Tile right = new Tile(40, 30);
        tile.setUp(up);
        tile.setDown(down);
        tile.setLeft(left);
        tile.setRight(right);
        assertEquals(tile.getUp().toString(), "20,10");
        assertEquals(tile.getDown().toString(), "20,50");
        assertEquals(tile.getLeft().toString(), "0,30");
        assertEquals(tile.getRight().toString(), "40,30");
    }
}
