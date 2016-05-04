package theboxgame.entities;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MovableTest {

    Movable movable;

    @Before
    public void setUp() {
        movable = new Movable(20, 30);
    }

    public MovableTest() {
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

    }

    @Test
    public void movableCanBeMoved() {
        movable.moveUp();
        assertEquals(movable.toString(), "(20 10)");
        movable.moveDown();
        assertEquals(movable.toString(), "(20 30)");
        movable.moveLeft();
        assertEquals(movable.toString(), "(0 30)");
        movable.moveRight();
        assertEquals(movable.toString(), "(20 30)");
    }
}
