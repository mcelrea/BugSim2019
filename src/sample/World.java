package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class World {
    Actor world[][];

    public World(int rows, int cols) {
        world = new Actor[rows][cols];
    }

    public void draw(GraphicsContext gc) {
        for(int row=0; row < world.length; row++) {
            for(int col=0; col < world[row].length; col++) {
                if(world[row][col] != null) {
                    world[row][col].draw(gc);
                }
            }
        }
    }

    public void addActor(Actor a) {
        world[a.getMyLoc().getRow()][a.getMyLoc().getCol()] = a;
    }
}
