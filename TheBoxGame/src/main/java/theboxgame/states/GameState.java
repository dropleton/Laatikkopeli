package theboxgame.states;

import java.awt.Graphics;
import java.util.ArrayList;
import theboxgame.entities.*;
import theboxgame.theboxgame.Game;

public class GameState extends State {
    private final Player player;
    private final ArrayList<Box> boxes;
    private final Goal goal;
    private final ArrayList<Wall> walls;
    private final ArrayList entities;
    
    public GameState(Game game) {
        super(game);
        this.entities = game.getEntities();
        this.player = game.getPlayer();
        this.boxes = game.getBoxes();
        this.goal = game.getGoal();
        this.walls = game.getWalls();
    }

    @Override
    public void tick() {
//        this.player.tick();
//        this.box.tick();
//        this.goal.tick();
    }

    @Override
    public void render(Graphics g) { 
        this.player.render(g);
        this.goal.render(g);
        for(Box box : this.boxes) {
            box.render(g);
        }
        for(Wall wall : this.walls) {
            wall.render(g);
        }
    }
    
    
}
