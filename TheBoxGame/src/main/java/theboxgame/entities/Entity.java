package theboxgame.entities;

import java.awt.Graphics;

public abstract class Entity {
    protected int x, y, width, height;

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 20;
        this.height = 20;
    }
    
    public abstract void tick();
    
    public abstract void render(Graphics g);
    
}
