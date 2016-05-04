package theboxgame.entities;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GoalTest {
    Goal goal;
    
    @Before
    public void setUp() {
        goal = new Goal(20, 30);
    }
    
    public GoalTest() {
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
        assertEquals(goal.getId(), 4);
    }
}
