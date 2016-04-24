package theboxgame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import theboxgame.entities.Player;

public class KeyManager implements KeyListener {
    private Player player;
    
    public KeyManager(Player player) {
        this.player = player;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                this.player.moveUp();
                break;
            case KeyEvent.VK_DOWN:
                this.player.moveDown();
                break;
            case KeyEvent.VK_RIGHT:
                this.player.moveRight();
                break;
            case KeyEvent.VK_LEFT:
                this.player.moveLeft();
                break;
            default:
                break;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    
    
}
