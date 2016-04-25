package theboxgame.states;

import java.awt.Graphics;
import theboxgame.entities.*;
import theboxgame.theboxgame.Game;

public class GameState extends State {
    private final Player player;
    private final Box box;
    private final Goal goal;
    private final Wall wall;
    
    public GameState(Game game) {
        super(game);
        this.player = game.getPlayer();
        this.box = game.getBox();
        this.goal = game.getGoal();
        this.wall = game.getWall();
    }

    @Override
    public void tick() {
        this.player.tick();
        this.box.tick();
        this.goal.tick();
    }

    @Override
    public void render(Graphics g) {
        this.player.render(g);
        this.box.render(g);
        this.goal.render(g);
        this.wall.render(g);
    }
    
    
}
