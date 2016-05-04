package theboxgame.entities;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {
    Player player;
    
    @Before
    public void setUp() {
        player = new Player(20, 30);
    }
    
    public PlayerTest() {
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
        assertEquals(player.getId(), 2);
    }
}
