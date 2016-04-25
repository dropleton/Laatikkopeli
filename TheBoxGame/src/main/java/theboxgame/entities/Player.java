package theboxgame.entities;

import java.awt.Graphics;

public class Player extends Movable{
    
    public Player(int x, int y) {
        super(x, y);
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
