/**
 * Yliluokka erilaisille Stateille: tällä hetkellä ainut State on GameState,
 * mutta olisi mahdollisuus toteuttaa mm MenuState.
 */
package theboxgame.states;

import java.awt.Graphics;
import theboxgame.theboxgame.Game;

public abstract class State {

    private Game game;

    public State(Game game) {
        this.game = game;
    }

    /**
     * Staten täytyy voida piirtää itsensä render-metodin avulla.
     *
     * @param g Game-luokasta saatu Graphics-olio
     */
    public abstract void render(Graphics g);

}
