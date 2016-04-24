package theboxgame.entities;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import theboxgame.theboxgame.Game;

public class Player extends Movable{
//    private Image image;
    
    
    public Player(int x, int y) {
        super(x, y);
//        try {
//            this.image = ImageIO.read(getClass().getResource("/Hahmo.png"));
////        URL loc = this.getClass().getResource("/textures/Hahmo.png");
////        ImageIcon icon = new ImageIcon(loc);
////        this.image = icon.getImage();
//        } catch (IOException ex) {
//            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.clearRect(0, 0, 400, 400);
//        g.drawImage(this.image, x, y, null);
        g.drawRect(x, y, width, height);
    }
    
    
    
}
