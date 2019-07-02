package Exercise4;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class FruitSelection extends Application
{
    private String[] fruitNames = {"Apple", "Orange", "Banana", "Pear", "Peach", "Cherry", "Melon", "Grapes", "Pomegranate"};

    private ImageView[] fruitImages = {new ImageView(new Image("Exercise4/fruit/7011130-apples-on-table-and-knife.jpg", 200, 200, true, true)),
            new ImageView(new Image("Exercise4/fruit/orange.jpg", 200, 200, true, true)),
            new ImageView(new Image("Exercise4/fruit/6294218-banana.jpg", 200, 200, true, true)),
            new ImageView(new Image("Exercise4/fruit/7071958-pear.jpg", 200, 200, true, true)),
            new ImageView(new Image("Exercise4/fruit/peach.jpg", 200, 200, true, true)),
            new ImageView(new Image("Exercise4/fruit/1178041-cherries.jpg", 200, 200, true, true)),
            new ImageView(new Image("Exercise4/fruit/4537051-melon.jpg", 200, 200, true, true)),
            new ImageView(new Image("Exercise4/fruit/grape.jpg", 200, 200, true, true)),
            new ImageView(new Image("Exercise4/fruit/3131131-ripe-pomegranate-with-red-seeds-on-wooden.jpg", 200, 200, true, true))};

    private DescriptionPane descriptionPane = new DescriptionPane();

    private ComboBox <String> cbo = new ComboBox <>();

    @Override
    public void start(Stage primaryStage)
    {
        setDisplay(0);

        BorderPane pane = new BorderPane( );

        BorderPane paneForComboBox = new BorderPane( );
        paneForComboBox.setLeft(new Label("Select a fruit: "));
        paneForComboBox.setCenter(cbo);
        pane.setTop(paneForComboBox);
        cbo.setPrefWidth(400);
        cbo.setValue("Apple");
        ObservableList <String> items = FXCollections.observableArrayList(fruitNames);
        cbo.getItems( ).addAll(items);
        pane.setCenter(descriptionPane);

        cbo.setOnAction(e -> setDisplay(items.indexOf(cbo.getValue( ))));

        Scene scene = new Scene(pane, 450, 200);
        primaryStage.setTitle("FruitSelection"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show( ); // Display the stage
    }

    /**
     * Set display information on the description pane
     */
    public void setDisplay(int index)
    {
        descriptionPane.setTitle(fruitNames[index]);
        descriptionPane.setImageView(fruitImages[index]);
    }
}