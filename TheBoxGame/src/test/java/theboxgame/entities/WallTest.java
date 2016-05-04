package theboxgame.entities;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class WallTest {
    Wall wall;
    
    @Before
    public void setUp() {
        wall = new Wall(20, 30);
    }
    
    public WallTest() {
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
    public void getIdIsOverridden() {
        assertEquals(wall.getId(), 1);
    }
}
