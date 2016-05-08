package theboxgame.theboxgame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CompleteTest {
    Complete complete;

    @Before
    public void setUp() {
        this.complete = new Complete();
    }

    public CompleteTest() {
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
    public void constructorSetsTheBooleanToFalse() {
        assertEquals(complete.getComplete(), false);
    }
    
    @Test
    public void setCompleteSetsTheBooleanTrue() {
        complete.setComplete();
        assertEquals(complete.getComplete(), true);
    }
}
