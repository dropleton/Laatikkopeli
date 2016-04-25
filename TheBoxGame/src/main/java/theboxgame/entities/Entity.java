package theboxgame.entities;

import java.awt.Graphics;

public class Entity {
    protected int x, y;
    public static int width = 20, height = 20;

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void tick() {
        
    }
    
    public void render(Graphics g) {
        
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    

}
