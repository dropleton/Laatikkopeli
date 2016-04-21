package peli.laatikkopeli.kayttoliittyma;

import java.awt.*;
import javax.swing.*;

public class Panel2 extends JPanel implements Runnable {
    Pelikentta kentta;

    public Panel2() {
        setFocusable(true); // Focus on JPanel to receive key events
        requestFocus();
        this.kentta = new Pelikentta(5, 5);
    }

    @Override
    public Dimension getPreferredSize() {
        // Override getPreferredSize by defining own size
        return new Dimension(500, 500);
    }

    @Override
    public void paintComponent(Graphics g) {
        Image image = render();
        paintScreen(g, image);
//        super.paintComponent(g);
//        g.drawString("Hello World", 100, 100);
//        Image RED_LAND;
//        RED_LAND = new ImageIcon("/home/jetolvan/Laatikkopeli/Laatikko.png").getImage();
//        g.drawImage(RED_LAND, 200, 200, null);

    }
    
    @Override
    public void run() {
        update();
        repaint();
    }
    
    private void update() {
        
    }
    
    private Image render() {
        Image dbImage = createImage(500, 500);
        Graphics g = dbImage.getGraphics();
        kentta.draw(g);
        return dbImage;
    }

    private void paintScreen(Graphics g, Image dbImage) {
        g.drawImage(dbImage, 0, 0, null);
    }
    
}
