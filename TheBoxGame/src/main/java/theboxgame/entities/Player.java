package theboxgame.entities;

import java.awt.Graphics;

public class Player extends Movable{
    private final int id;
    
    public Player(int x, int y) {
        super(x, y);
        this.id = 0;
    }
    
    public int getId() {
        return this.id;
    }
    
    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.clearRect(0, 0, 400, 400);
        g.drawRect(x, y, width, height);
    }
}
