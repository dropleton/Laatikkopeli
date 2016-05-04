/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theboxgame.entities;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class EntityTest {
    Entity entity;
    
    @Before
    public void setUp() {
        entity = new Entity(20, 30);
    }
    
    public EntityTest() {
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
        assertEquals(entity.toString(), "(20 30)");
        assertEquals(entity.getId(), 0);
    }
    
    @Test
    public void setTileSetsTheTile() {
        Tile tile = new Tile(20, 30);
        entity.setTile(tile);
        assertEquals(entity.getTile().toString(), "20,30");
    }
    
    @Test
    public void setTileDoesntSetWrongTile() {
        
    }
}
