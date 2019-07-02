package Exercise1;

import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;

public class SelectGeometricFigure extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        BorderPane borderPane    = new BorderPane();
        Pane stackPane           = new Pane();
        HBox buttonBox           = new HBox();

        Circle circle       = new Circle(250, 250, 50);
        circle.setStroke(Color.TRANSPARENT);
        circle.setFill(Color.TRANSPARENT);

        Rectangle rectangle = new Rectangle(250, 250, 50, 75);
        rectangle.setStroke(Color.TRANSPARENT);
        rectangle.setFill(Color.TRANSPARENT);

        Ellipse ellipse     = new Ellipse(250, 250, 50, 75);
        ellipse.setStroke(Color.TRANSPARENT);
        ellipse.setFill(Color.TRANSPARENT);

        RadioButton rbCircle    = new RadioButton("Circle");
        RadioButton rbRectangle = new RadioButton("Rectangle");
        RadioButton rbEllipse   = new RadioButton("Ellipse");
        CheckBox chkFill        = new CheckBox("Fill");

        ToggleGroup group = new ToggleGroup();
        rbCircle.setToggleGroup(group);
        rbRectangle.setToggleGroup(group);
        rbEllipse.setToggleGroup(group);

        buttonBox.getChildren().addAll(rbCircle, rbRectangle, rbEllipse, chkFill);
        stackPane.getChildren().addAll(circle, rectangle, ellipse);
        borderPane.setCenter(stackPane);
        borderPane.setBottom(buttonBox);

        rbCircle.setOnAction(event ->
        {
            if (!chkFill.isSelected() && rbCircle.isSelected())
            {
                circle.setStroke(Color.BLACK);
                rectangle.setStroke(Color.TRANSPARENT);
                ellipse.setStroke(Color.TRANSPARENT);
                circle.setFill(Color.TRANSPARENT);
                rectangle.setFill(Color.TRANSPARENT);
                ellipse.setFill(Color.TRANSPARENT);
            }

            else if (chkFill.isSelected() && rbCircle.isSelected())
            {
                circle.setFill(Color.BLACK);
                rectangle.setFill(Color.TRANSPARENT);
                ellipse.setFill(Color.TRANSPARENT);
            }
        });

        rbRectangle.setOnAction(event ->
        {
            if (!chkFill.isSelected() && rbRectangle.isSelected())
            {
                circle.setStroke(Color.TRANSPARENT);
                rectangle.setStroke(Color.BLACK);
                ellipse.setStroke(Color.TRANSPARENT);
                circle.setFill(Color.TRANSPARENT);
                rectangle.setFill(Color.TRANSPARENT);
                ellipse.setFill(Color.TRANSPARENT);
            }

            else if (chkFill.isSelected() && rbRectangle.isSelected())
            {
                rectangle.setFill(Color.BLACK);
                circle.setFill(Color.TRANSPARENT);
                ellipse.setFill(Color.TRANSPARENT);
            }
        });

        rbEllipse.setOnAction(event ->
        {
            if (!chkFill.isSelected() && rbEllipse.isSelected())
            {
                circle.setStroke(Color.TRANSPARENT);
                rectangle.setStroke(Color.TRANSPARENT);
                ellipse.setStroke(Color.BLACK);
                circle.setFill(Color.TRANSPARENT);
                rectangle.setFill(Color.TRANSPARENT);
                ellipse.setFill(Color.TRANSPARENT);
            }

            else if (chkFill.isSelected() && rbEllipse.isSelected())
            {
                ellipse.setFill(Color.BLACK);
                circle.setFill(Color.TRANSPARENT);
                rectangle.setFill(Color.TRANSPARENT);
            }
        });

        chkFill.setOnAction(event ->
        {
            if (chkFill.isSelected() && rbCircle.isSelected())
            {
                circle.setStroke(Color.BLACK);
                rectangle.setStroke(Color.TRANSPARENT);
                ellipse.setStroke(Color.TRANSPARENT);
                circle.setFill(Color.BLACK);
                rectangle.setFill(Color.TRANSPARENT);
                ellipse.setFill(Color.TRANSPARENT);
            }

            if (chkFill.isSelected() && rbRectangle.isSelected())
            {
                circle.setStroke(Color.TRANSPARENT);
                rectangle.setStroke(Color.BLACK);
                ellipse.setStroke(Color.TRANSPARENT);
                circle.setFill(Color.TRANSPARENT);
                rectangle.setFill(Color.BLACK);
                ellipse.setFill(Color.TRANSPARENT);
            }

            if (chkFill.isSelected() && rbEllipse.isSelected())
            {
                circle.setStroke(Color.TRANSPARENT);
                rectangle.setStroke(Color.TRANSPARENT);
                ellipse.setStroke(Color.BLACK);
                circle.setFill(Color.TRANSPARENT);
                rectangle.setFill(Color.TRANSPARENT);
                ellipse.setFill(Color.BLACK);
            }

            if (!chkFill.isSelected())
            {
                circle.setFill(Color.TRANSPARENT);
                rectangle.setFill(Color.TRANSPARENT);
                ellipse.setFill(Color.TRANSPARENT);
            }
        });

        Scene scene = new Scene(borderPane, 500, 500);
        primaryStage.setTitle("SelectGeometricFigure");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
