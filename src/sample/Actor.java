package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Actor {

    //fields or instance variables
    private Image northImage, southImage, westImage, eastImage;
    private float speed;
    private Location myLoc;

    public Actor(int row, int col, World world) {
        this.myLoc = new Location(row, col);
        world.addActor(this);
    }

    public Location getMyLoc() {
        return myLoc;
    }

    public void draw(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillRect(getMyLoc().getCol()*25,
                    getMyLoc().getRow()*25,
                    25,
                    25);
    }
}
