package theboxgame.entities;

import java.awt.Color;
import java.awt.Graphics;

public class Goal extends Entity {

    public Goal(int x, int y) {
        super(x, y);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(x, y, width, height);
    }
    
}
