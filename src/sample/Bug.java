package sample;

public class Bug extends Actor {

    public Bug(int row, int col, World world) {
        super(row,col,world);
        setImage("images/bug.png");
    }

    @Override
    public void act() {
        if(getMyDir() == Location.NORTH){
            getMyLoc().setRow(getMyLoc().getRow()-1);
        }
    }
}
