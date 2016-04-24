package theboxgame.entities;

import java.awt.Graphics;

public class Box extends Movable {

    public Box(int x, int y) {
        super(x, y);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.clearRect(x, y, width, height);
        g.fillRect(x, y, width, height);

    }
    
    
}
