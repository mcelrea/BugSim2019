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

    public void act() {
        for(int row=0; row < world.length; row++) {
            for(int col=0; col < world[row].length; col++) {
                if(world[row][col] != null) {
                    world[row][col].act();
                }
            }
        }
    }

    public void put(Actor a) {
        world[a.getMyLoc().getRow()][a.getMyLoc().getCol()] = a;
    }

    public boolean isValid(Location loc) {
        return loc.getRow() >= 0 && loc.getRow() < world.length &&
            loc.getCol() >= 0 && loc.getCol() < world[loc.getRow()].length;
    }

    public Actor remove(Location loc) {
        //grab whatever is in that location
        Actor a = world[loc.getRow()][loc.getCol()];

        //erase that location in the world
        world[loc.getRow()][loc.getCol()] = null;

        return a;
    }

    public Actor get(Location loc) {
        return world[loc.getRow()][loc.getCol()];
    }
}
