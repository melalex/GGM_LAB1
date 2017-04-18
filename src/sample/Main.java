package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Main extends Application {
    private static final double SCENE_WIDTH = 300;
    private static final double SCENE_HEIGHT = 250;
    private static final double MARGIN = 10;
    private static final double BOT_MARGIN = 50;
    private static final double LINE_WIDTH = 3;
    private static final double BOT_WIDTH = SCENE_WIDTH - 2 * (MARGIN + BOT_MARGIN) + 2 * LINE_WIDTH;

    private static final double EYE_WIDTH = 80;
    private static final double EYE1_MARGIN = 30;
    private static final double EYE2_MARGIN = 40;

    private static final double NOSE_LAMBDA = 2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);

        scene.setFill(Color.GREEN);

        final Line face1 = new Line();
        face1.setStartX(MARGIN);
        face1.setStartY(MARGIN);
        face1.setEndX(BOT_MARGIN + MARGIN);
        face1.setEndY(SCENE_HEIGHT - MARGIN);
        face1.setStroke(Color.RED);
        face1.setStrokeWidth(LINE_WIDTH);
        root.getChildren().add(face1);

        final Line face2 = new Line();
        face2.setStartX(BOT_MARGIN + MARGIN);
        face2.setStartY(SCENE_HEIGHT - MARGIN);
        face2.setEndX(BOT_WIDTH + BOT_MARGIN + MARGIN);
        face2.setEndY(SCENE_HEIGHT - MARGIN);
        face2.setStroke(Color.RED);
        face2.setStrokeWidth(LINE_WIDTH);
        root.getChildren().add(face2);

        final Line face3 = new Line();
        face3.setStartX(BOT_WIDTH + BOT_MARGIN + MARGIN);
        face3.setStartY(SCENE_HEIGHT - MARGIN);
        face3.setEndX(BOT_WIDTH + 2 * BOT_MARGIN);
        face3.setEndY(MARGIN);
        face3.setStroke(Color.RED);
        face3.setStrokeWidth(LINE_WIDTH);
        root.getChildren().add(face3);

        final Line eye1 = new Line();
        final double endEye1X = MARGIN + EYE_WIDTH;
        eye1.setStartX(MARGIN + EYE1_MARGIN);
        eye1.setStartY(MARGIN);
        eye1.setEndX(endEye1X);
        eye1.setEndY(MARGIN);
        eye1.setStroke(Color.BLUE);
        eye1.setStrokeWidth(LINE_WIDTH);
        root.getChildren().add(eye1);

        final Line eye2 = new Line();
        final double startEye2X = SCENE_WIDTH - EYE2_MARGIN - EYE_WIDTH;
        eye2.setStartX(startEye2X);
        eye2.setStartY(MARGIN);
        eye2.setEndX(SCENE_WIDTH - EYE2_MARGIN - MARGIN);
        eye2.setEndY(MARGIN);
        eye2.setStroke(Color.BLUE);
        eye2.setStrokeWidth(LINE_WIDTH);
        root.getChildren().add(eye2);

        final Polygon nose = new Polygon();
        final double noseStartX = (endEye1X + startEye2X) / 2;
        final double endNose1X = divideLine(noseStartX, BOT_MARGIN + MARGIN, NOSE_LAMBDA);
        final double endNose1Y = divideLine(MARGIN, SCENE_HEIGHT - MARGIN, NOSE_LAMBDA);
        final double endNose2X = divideLine(noseStartX, BOT_WIDTH + BOT_MARGIN + MARGIN, NOSE_LAMBDA);
        final double endNose2Y = divideLine(MARGIN, SCENE_HEIGHT - MARGIN, NOSE_LAMBDA);
        nose.getPoints().addAll(
                noseStartX, MARGIN,
                endNose1X,  endNose1Y,
                endNose2X,  endNose2Y
        );
        nose.setFill(Color.YELLOW);
        root.getChildren().add(nose);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private double divideLine(double c1, double c2, double lambda) {
        return (c1 + c2 * lambda) / (1 + lambda);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
