package theboxgame.states;

import java.awt.Graphics;
import java.util.ArrayList;
import theboxgame.entities.*;
import theboxgame.theboxgame.Complete;
import theboxgame.theboxgame.Game;

public class GameState extends State {

    private final Player player;
    private final ArrayList<Box> boxes;
    private final Goal goal;
    private final ArrayList<Wall> walls;
    private final ArrayList<Entity> empties;
    private final ArrayList entities;
    private final Complete complete;

    public GameState(Game game) {
        super(game);
        this.entities = game.getEntities();
        this.player = game.getPlayer();
        this.boxes = game.getBoxes();
        this.goal = game.getGoal();
        this.walls = game.getWalls();
        this.empties = game.getEmpties();
        this.complete = game.getComplete();
    }

    @Override
    public void tick() {
//        this.player.tick();
//        this.box.tick();
//        this.goal.tick();
    }

    @Override
    public void render(Graphics g) {
        for(Entity empty : this.empties) {
            empty.render(g);
        }
        for (Wall wall : this.walls) {
            wall.render(g);
        }
        for (Box box : this.boxes) {
            box.render(g);
        }
        this.goal.render(g);
        this.player.render(g);
        this.complete.render(g);
    }

}
