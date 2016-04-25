package theboxgame.entities;

import java.awt.Color;
import java.awt.Graphics;

public class Box extends Movable {
    private final int id;

    public Box(int x, int y) {
        super(x, y);
        this.id = 2;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
//        g.clearRect(x, y, width, height);
//        g.setColor(Color.gray);
//        g.fillRect(x, y, width, height);

    }
    
    
}
