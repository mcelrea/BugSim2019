package sample;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Actor {

    //fields or instance variables
    private Image northImage, southImage, westImage, eastImage;
    private float speed;
    private Location myLoc;

    public Actor(int row, int col, World world) {
        this.myLoc = new Location(row, col);
        world.addActor(this);

        //attempt to load main image
        File myFile = new File("images/actor.png");
        try {
            northImage = new Image(new FileInputStream(myFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //rotate and store the image at different angles
        ImageView iv = new ImageView(northImage);
        iv.setRotate(90);
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        //East facing image
        eastImage = iv.snapshot(params,null);
        //South facing image
        iv.setRotate(180);
        southImage = iv.snapshot(params, null);
        //West facing image
        iv.setRotate(270);
        westImage = iv.snapshot(params, null);
    }

    public Location getMyLoc() {
        return myLoc;
    }

    public void draw(GraphicsContext gc) {

        gc.drawImage(northImage,
                     getMyLoc().getCol()*25,
                     getMyLoc().getRow()*25);
    }
}
