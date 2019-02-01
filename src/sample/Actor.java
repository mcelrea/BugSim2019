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
    private Image northImage, southImage, westImage, eastImage,
                northWestImage, southWestImage, northEastImage,
                southEastImage;
    private int myDir;
    private World myWorld;
    private Location myLoc;

    public Actor(int row, int col, World world) {
        this.myLoc = new Location(row, col);
        myDir = Location.NORTH;
        myWorld = world;
        setImage("images/actor.png");
    }

    public void setImage(String path) {
        //attempt to load main image
        File myFile = new File(path);
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
        //northEastImage
        iv.setRotate(45);
        northEastImage = iv.snapshot(params, null);
        //southEastImage
        iv.setRotate(135);
        southEastImage = iv.snapshot(params, null);
        //southWestImage
        iv.setRotate(225);
        southWestImage = iv.snapshot(params, null);
        //northWestImage
        iv.setRotate(315);
        northWestImage = iv.snapshot(params, null);
    }

    public Location getMyLoc() {
        return myLoc;
    }

    public void turnRight() {
        myDir += 1;
        if (myDir == 9)
            myDir = Location.NORTH;
    }

    public void act() {
        turnRight();
    }

    public int getMyDir() {
        return myDir;
    }

    public void setMyDir(int myDir) {
        this.myDir = myDir;
    }

    public World getMyWorld() {
        return myWorld;
    }

    public void setMyWorld(World myWorld) {
        this.myWorld = myWorld;
    }

    public void draw(GraphicsContext gc) {

        if (myDir == Location.NORTH) {
            gc.drawImage(northImage,
                    getMyLoc().getCol() * 25,
                    getMyLoc().getRow() * 25);
        }
        else if (myDir == Location.SOUTH) {
            gc.drawImage(southImage,
                    getMyLoc().getCol() * 25,
                    getMyLoc().getRow() * 25);
        }
        else if (myDir == Location.EAST) {
            gc.drawImage(eastImage,
                    getMyLoc().getCol() * 25,
                    getMyLoc().getRow() * 25);
        }
        else if (myDir == Location.WEST) {
            gc.drawImage(westImage,
                    getMyLoc().getCol() * 25,
                    getMyLoc().getRow() * 25);
        }
        else if (myDir == Location.NORTHWEST) {
            gc.drawImage(northWestImage,
                    getMyLoc().getCol() * 25,
                    getMyLoc().getRow() * 25);
        }
        else if (myDir == Location.SOUTHWEST) {
            gc.drawImage(southWestImage,
                    getMyLoc().getCol() * 25,
                    getMyLoc().getRow() * 25);
        }
        else if (myDir == Location.SOUTHEAST) {
            gc.drawImage(southEastImage,
                    getMyLoc().getCol() * 25,
                    getMyLoc().getRow() * 25);
        }
        else if (myDir == Location.NORTHEAST) {
            gc.drawImage(northEastImage,
                    getMyLoc().getCol() * 25,
                    getMyLoc().getRow() * 25);
        }
    }
}
