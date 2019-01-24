package sample;

public class Bug extends Actor {

    public Bug(int row, int col, World world) {
        super(row,col,world);
        setImage("images/bug.png");
    }

    @Override
    public void act() {
        Location nextLoc = getMyLoc().getAdjacentLocation(getMyDir());
        System.out.println("Current Location: " + getMyLoc());
        System.out.println("Next Location   : " + nextLoc);
        System.out.println("-------------------------------------");
        if(getMyWorld().isValid(nextLoc)) {
            getMyWorld().remove(getMyLoc());//erase me from the world
            getMyLoc().setLocation(nextLoc);
            getMyWorld().put(this);
        }
        else {
            turnRight();
        }
    }
}
