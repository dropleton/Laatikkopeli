package theboxgame.theboxgame;

public class Launcher {
    
    public static void main(String[]  args) {
        String map 
                = "    11111          \n"
                + "    1 0 1          \n"
                + "11111  11          \n"
                + "1 3    1           \n"
                + "1 2  2 1111        \n"
                + "1         1        \n"
                + "11111111111        \n"
                + "                   \n"
                + "                   \n"
                + "                   \n"
                + "                   \n"
                + "                   \n"
                + "                   \n"
                + "                   \n"
                + "                   \n"
                + "                   \n"
                + "                   \n"
                + "                   \n"
                + "                   \n"
                + "                   \n";
        Game game = new Game("TheBoxGame!", 400, 400, map);
        game.start();
        
    }
}
