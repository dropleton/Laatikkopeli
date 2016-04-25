package theboxgame.worlds;

import theboxgame.entities.Entity;

public class World {
    private int width, height;
    private int[][] tiles;
    
    public World() {
        loadWorld();
    }
    
    private void loadWorld() {
        this.width = 5;
        this.height = 5;
        this.tiles = new int[this.width][this.height];
    }
    
    public void render() {
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                
            }
        }
    }
    
}
