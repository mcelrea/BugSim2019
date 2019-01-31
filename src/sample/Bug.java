package sample;

import javafx.scene.paint.Color;

public class Bug extends Actor {

    public Bug(int row, int col, World world) {
        super(row,col,world);
        setImage("images/bug.png");
    }

    @Override
    public void act() {
        Location nextLoc = getMyLoc().getAdjacentLocation(getMyDir());
        //System.out.println("Current Location: " + getMyLoc());
        //System.out.println("Next Location   : " + nextLoc);
        //System.out.println("-------------------------------------");
        if(getMyWorld().isValid(nextLoc) && (getMyWorld().get(nextLoc) == null || getMyWorld().get(nextLoc) instanceof Flower)) {
            getMyWorld().remove(getMyLoc());//erase me from the world
            Location oldLoc = new Location(getMyLoc().getRow(), getMyLoc().getCol()); //remember my original location before move
            getMyLoc().setLocation(nextLoc);//change internal location
            getMyWorld().put(this);//put me back into the world at new location
            getMyWorld().put(new Flower(oldLoc.getRow(),oldLoc.getCol(),getMyWorld(), Color.AQUAMARINE));
        }
        else {
            turnRight();
        }
    }
}
