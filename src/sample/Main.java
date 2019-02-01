package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    private static final String version = "0.0.0.1";
    private World myWorld = new World(20,20);

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Bug Sim " + version);
        Group root = new Group();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        Canvas canvas = new Canvas(800,600);
        root.getChildren().add(canvas);
        final GraphicsContext gc = canvas.getGraphicsContext2D();

        myWorld.put(new Bug(5,5, myWorld));
        myWorld.put(new Bug(7,5, myWorld));
        myWorld.put(new Bug(5,7, myWorld));
        myWorld.put(new Bug(1,5, myWorld));
        myWorld.put(new Bug(2,8, myWorld));
        myWorld.put(new BoxBug(6,6,2,myWorld));

        //this will keep running and looping forever
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                //clear the screen
                gc.setFill(Color.WHITE);
                gc.fillRect(0,0,800,600);

                //make the world act
                myWorld.act();

                //draw the world
                myWorld.draw(gc);

                //tell my program to stop running for x milliseconds

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();

        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
