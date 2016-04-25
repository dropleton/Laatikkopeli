package theboxgame.theboxgame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.logging.*;
import theboxgame.display.Display;
import theboxgame.entities.*;
import theboxgame.input.KeyManager;
import theboxgame.states.*;

public class Game implements Runnable {

    private Display display;

    private Thread thread;
    private boolean running = false;

    public int width, height;
    public String title;

    private BufferStrategy bs;
    private Graphics g;

    private State gameState;

    //Entities
    private Player player;
    private ArrayList<Box> boxes;
    private Goal goal;
    private ArrayList<Wall> walls;
    private ArrayList<Entity> entities;

    private KeyManager keyManager;

    private Render render;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        this.player = new Player(100, 100);
        this.boxes = new ArrayList();
        this.goal = new Goal(300, 200);
        this.walls = new ArrayList();
        this.entities = new ArrayList();
        this.keyManager = new KeyManager(this.player);
    }

    private void init() {
        setEntities();
        this.display = new Display(title, width, height);
        this.display.getJFrame().addKeyListener(this.keyManager);
        
        this.gameState = new GameState(this);
        CurrentState.setState(this.gameState);
    }
    
    private void setEntities() {
        addEntities();
        for(int i = 0; i < this.entities.size(); i++) {
            for(int j = 0; j < this.entities.size(); j++) {
//                if(this.entities.get(i).getX())
            }
        }
    }
    
    private void addEntities() {
        this.entities.add(this.player);
        this.entities.add(this.goal);
        
        for(Box box : this.boxes) {
            this.entities.add(box);
        }
        
        for(Wall wall : this.walls) {
            this.entities.add(wall);
        }
    }

    private void tick() {
        if (CurrentState.getState() != null) {
            CurrentState.getState().tick();
        }
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        if (CurrentState.getState() != null) {
            CurrentState.getState().render(g);
        }

        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        this.render = new Render();

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
//            this.render.render(this.display, this.width, this.height);
                render();
                ticks++;
                delta--;
            }

            if (timer >= 1000000000) {
                System.out.println("Ticks and frames: " + ticks);
                ticks = 0;
                timer = 0;
            }

        }

        stop();
    }

    public synchronized void start() {
        if (running) {
            return;
        }
        this.running = true;
        this.thread = new Thread(this);
        this.thread.start();
    }

    public synchronized void stop() {
        if (!running) {
            return;
        }
        try {
            this.thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Player getPlayer() {
        return this.player;
    }
    
    public Box getBox() {
        return this.box;
    }
    
    public Goal getGoal() {
        return this.goal;
    }
    
    public Wall getWall() {
        return this.wall;
    }
    
}
