package theboxgame.theboxgame;

public class Launcher {
    
    public static void main(String[]  args) {
        String map 
                = "11111\n"
                + "1 0 1\n"
                + "123 1\n"
                + "11111";
        Game game = new Game("TheBoxGame!", 400, 400, map);
        game.start();
        
    }
}
