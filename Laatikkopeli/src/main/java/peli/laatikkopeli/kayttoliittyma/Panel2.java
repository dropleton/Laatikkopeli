package peli.laatikkopeli.kayttoliittyma;

//import java.awt.*;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import javax.swing.*;
//
//public class Panel2 extends JPanel implements Runnable, KeyListener {
//
//    Pelikentta kentta;
//    NappaimistonKuuntelija kuuntelija;
//
//    public Panel2() {
//        setFocusable(true); // Focus on JPanel to receive key events
//        requestFocus();
//        this.kentta = new Pelikentta(5, 5);
//        this.kuuntelija = new NappaimistonKuuntelija(this.kentta.getHahmo(), this.kentta);
//        addKeyListener(this.kuuntelija);
//    }
//
//    @Override
//    public Dimension getPreferredSize() {
//        // Override getPreferredSize by defining own size
//        return new Dimension(500, 500);
//    }
//
//    @Override
//    public void paintComponent(Graphics g) {
//        Image image = render();
//        paintScreen(g, image);
//    }
//
//    @Override
//    public void run() {
//        update();
//        repaint();
//    }
//
//    private void update() {
////        this.kentta.getHahmo().piirra(graphics);
//    }
//
//    private Image render() {
//        Image dbImage = createImage(500, 500);
//        Graphics g = dbImage.getGraphics();
//        kentta.draw(g);
//        return dbImage;
//    }
//
//    private void paintScreen(Graphics g, Image dbImage) {
//        g.drawImage(dbImage, 0, 0, null);
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//        switch (e.getKeyCode()) {
//            case KeyEvent.VK_LEFT:
//                this.kentta.getHahmo().liikuVasemmalle();
//                break;
//            case KeyEvent.VK_RIGHT:
//                this.kentta.getHahmo().liikuOikealle();
//                break;
//            case KeyEvent.VK_UP:
//                this.kentta.getHahmo().liikuAlas();
//                break;
//            case KeyEvent.VK_DOWN:
//                this.kentta.getHahmo().liikuYlos();
//                break;
//            default:
//                break;
//        }
//
//        repaint();
//    }
//
//    @Override
//    public void keyTyped(KeyEvent e) {
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//
//    }
//}
