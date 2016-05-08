package theboxgame.display;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DisplayTest {

    Display display;

    @Before
    public void setUp() {
        this.display = new Display("Test!", 400, 400);
    }

    public DisplayTest() {
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
    public void displayCreatesJFrame() {
        assertNotEquals(display.getJFrame(), null);
    }
    
    @Test
    public void displayCreatesCanvas() {
        assertNotEquals(display.getCanvas(), null);
    }
}
