package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application {
    private static final double SCENE_WIDTH = 300;
    private static final double SCENE_HEIGHT = 250;
    private static final double MARGIN = 10;
    private static final double BOT_MARGIN = 50;
    private static final double LINE_WIDTH = 3;
    private static final double BOT_WIDTH = SCENE_WIDTH - 2 * (MARGIN + BOT_MARGIN) + 2 * LINE_WIDTH;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);

        scene.setFill(Color.GREEN);

        final Line line1 = new Line(
                MARGIN,
                MARGIN,
                BOT_MARGIN + MARGIN,
                SCENE_HEIGHT - MARGIN
        );
        line1.setStroke(Color.RED);
        line1.setStrokeWidth(LINE_WIDTH);
        root.getChildren().add(line1);

        final Line line2 = new Line(
                BOT_MARGIN + MARGIN,
                SCENE_HEIGHT - MARGIN,
                BOT_WIDTH + BOT_MARGIN + MARGIN,
                SCENE_HEIGHT - MARGIN
        );
        line2.setStroke(Color.RED);
        line2.setStrokeWidth(LINE_WIDTH);
        root.getChildren().add(line2);

        final Line line3 = new Line(
                BOT_WIDTH + BOT_MARGIN + MARGIN,
                SCENE_HEIGHT - MARGIN,
                BOT_WIDTH + 2 * BOT_MARGIN,
                MARGIN
        );
        line3.setStroke(Color.RED);
        line3.setStrokeWidth(LINE_WIDTH);
        root.getChildren().add(line3);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
