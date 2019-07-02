package Exercise5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleSize extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();

        Circle circle = new Circle(200, 200, 50, Color.color(Math.random(), Math.random(), Math.random()));
        Slider slider = new Slider(0, 200, 50);
        slider.setBlockIncrement(5.0);
        Label sizeSlider = new Label(Double.toString(slider.getValue()));
        sizeSlider.setLayoutX(20);
        sizeSlider.setLayoutY(20);

        pane.getChildren().addAll(circle, slider, sizeSlider);

        slider.setOnDragDetected(event ->
        {
            circle.setRadius(slider.getValue());
            sizeSlider.setText(Double.toString(slider.getValue()));
        });

        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("CircleSize");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
