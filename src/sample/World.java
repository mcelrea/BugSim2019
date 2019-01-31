package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

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
        ArrayList<Actor> allActors = getAllActors();
        for(Actor a: allActors) {
            a.act();
        }
        /*
         for (int i=0; i < allActors.size(); i++) {
            allActors.get(i).act();
         }
         */
    }

    public Actor put(Actor a) {
        Actor deadActor = world[a.getMyLoc().getRow()][a.getMyLoc().getCol()];
        world[a.getMyLoc().getRow()][a.getMyLoc().getCol()] = a;
        return deadActor;
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

    public ArrayList<Actor> getAllActors() {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        for(int row=0; row < world.length; row++) {
            for (int col = 0; col < world[row].length; col++) {
                if(world[row][col] != null) {
                    actors.add(world[row][col]);
                }
            }
        }
        return actors;
    }

    public Actor get(Location loc) {
        return world[loc.getRow()][loc.getCol()];
    }
}
