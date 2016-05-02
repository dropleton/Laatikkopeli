/**
 * Luokka kertoo tämänhetkisen Staten (eli tällä hetkellä aina GameStaten).
 */

package theboxgame.states;

public class CurrentState {
    private static State currentState;
    
    public CurrentState() {
        currentState = null;
    }
    
    public static void setState(State state) {
        currentState = state;
    }
    
    public static State getState() {
        return currentState;
    }
    
}
