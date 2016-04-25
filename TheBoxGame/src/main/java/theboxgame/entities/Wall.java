package theboxgame.entities;

import java.awt.Color;
import java.awt.Graphics;

public class Wall extends Entity {

    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(x, y, width, height);
    }
    
}
