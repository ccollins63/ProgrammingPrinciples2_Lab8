package Exercise2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DistanceConverter extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        VBox vBox  = new VBox();
        HBox hBox1 = new HBox();
        HBox hBox2 = new HBox();
        Scene scene = new Scene(vBox, 400, 200);

        TextField mileTextField  = new TextField();
        TextField kilometerTextField = new TextField();

        hBox1.getChildren().addAll(new Label("Input"), mileTextField);
        hBox2.getChildren().addAll(new Label("Output"), kilometerTextField);

        hBox1.setAlignment(Pos.CENTER);
        hBox2.setAlignment(Pos.CENTER);

        hBox1.setSpacing(20);
        hBox2.setSpacing(20);

        vBox.getChildren().addAll(hBox1, hBox2);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);

        scene.setOnKeyPressed(event ->
        {
            if (event.getCode() == KeyCode.ENTER && (kilometerTextField.getText() == null || kilometerTextField.getText().trim().isEmpty()))
            {
                double kilometers = milesToKilometers(Double.parseDouble(mileTextField.getText()));
                kilometerTextField.setText(Double.toString(kilometers));
            }

            else if (event.getCode() == KeyCode.ENTER && (mileTextField.getText() == null || mileTextField.getText().trim().isEmpty()))
            {
                double miles = milesToKilometers(Double.parseDouble(kilometerTextField.getText()));
                mileTextField.setText(Double.toString(miles));
            }
        });

        primaryStage.setTitle("DistanceConverter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public double milesToKilometers(double miles)
    {
        double kilometers = miles * 1.6;
        return kilometers;
    }

    public double kilometersToMiles(double kilometer)
    {
        double miles = kilometer / 1.6;
        return miles;
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
