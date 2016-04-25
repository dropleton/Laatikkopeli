package theboxgame.entities;

import java.awt.Graphics;

public class Entity {
    protected int x, y, width, height;
    protected Entity up, down, left, right;

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 20;
        this.height = 20;
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
    
    public void setUp(Entity entity) {
        this.up = entity;
    }
    
    public void setDown(Entity entity) {
        this.down = entity;
    }
    
    public void setLeft(Entity entity) {
        this.left = entity;
    }
    
    public void setRight(Entity entity) {
        this.right = entity;
    }
}
