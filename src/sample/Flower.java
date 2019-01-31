package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Flower extends Actor{

    Color myColor;

    public Flower(int row, int col, World world, Color color){
        super(row, col, world);
        myColor = color;
    }

    private void lighten() {
        double changeBlue = myColor.getBlue()+0.04;
        double changeRed = myColor.getRed()+0.04;
        double changeGreen = myColor.getRed()+0.04;
        if(changeBlue > 1)
            changeBlue = 1;
        if(changeRed > 1)
            changeRed = 1;
        if(changeGreen > 1)
            changeGreen = 1;

        myColor = new Color(changeRed,changeGreen,changeBlue, 1);
    }

    @Override
    public void act() {
        lighten();
        if(myColor.getRed() == 1 && myColor.getGreen() == 1 && myColor.getBlue() == 1) {
            Actor disMeQuestionMark = getMyWorld().get(getMyLoc());
            if(disMeQuestionMark == this) {
                getMyWorld().remove(getMyLoc()); //pull myself out of the world
                setMyWorld(null);
                System.out.println("Removed Flower from " + getMyLoc());
            }
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(myColor);
        gc.fillOval(getMyLoc().getCol()*25,
                getMyLoc().getRow()*25,
                25,
                25);
    }
}
