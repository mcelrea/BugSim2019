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

        myWorld.addActor(new Actor(0,0,myWorld));
        myWorld.addActor(new Actor(1,1,myWorld));
        myWorld.addActor(new Actor(2,2,myWorld));
        myWorld.addActor(new Actor(3,3,myWorld));

        //this will keep running and looping forever
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                //clear the screen
                gc.setFill(Color.WHITE);
                gc.fillRect(0,0,800,600);

                //draw the world
                myWorld.draw(gc);
            }
        }.start();

        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}