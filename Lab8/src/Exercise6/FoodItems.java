package Exercise6;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;


public class FoodItems extends Application
{
    private ArrayList<String> listOrder = new ArrayList<>();
    private ListView<String> listItem   = new ListView<>();
    private String[][] menuCollection   = new String[4][3];
    private TextArea areaOrderField     = new TextArea();

    public void start(Stage primaryStage)
    {
        String[] menuGenre = {"Appetizer","Entree","Drink","Dessert"};

        String[] menuAppetizer    = {"Nachos", "Cheese Sticks", "Yogurt"};
        String[] menuEntree       = {"Burger", "Steak", "Chicken Strips"};
        String[] menuDrink        = {"Coke", "Sweet Tea", "Water"};
        String[] menuDessert      = {"Cookie Skillet", "Ice Cream", "Fudge Cake"};

        HBox pane = new HBox();
        pane.setPadding(new Insets(10, 10, 10, 10));

        VBox paneMenu = new VBox();
        paneMenu.setPadding(new Insets(10, 10, 10, 10));

        ComboBox<String> boxGenre = new ComboBox<>();

        VBox paneOrder          = new VBox();
        paneOrder.setPadding(new Insets(10, 10, 10, 10));

        HBox paneButton = new HBox();
        paneButton.setPadding(new Insets(10, 10, 10, 10));
        Button btSubmit = new Button("Submit");
        Button btClear  = new Button("Clear");

        menuCollection[0] = menuAppetizer;
        menuCollection[1] = menuEntree;
        menuCollection[2] = menuDrink;
        menuCollection[3] = menuDessert;

        ObservableList<String> genres = FXCollections.observableArrayList(menuGenre);
        boxGenre.getItems().addAll(genres);
        boxGenre.setValue("Food Type");

        boxGenre.setOnAction(event -> setGenre(genres.indexOf(boxGenre.getValue())));

        btClear.setOnAction(event -> clearOrder());
        btSubmit.setOnAction(event -> primaryStage.close());

        listItem.getSelectionModel().selectedItemProperty().addListener(ov -> addItem());

        paneButton.setSpacing(10);
        paneButton.getChildren().addAll(btSubmit,btClear);

        paneMenu.getChildren().addAll(boxGenre,listItem);

        paneOrder.getChildren().addAll(areaOrderField,paneButton);

        pane.getChildren().addAll(paneMenu,paneOrder);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setGenre(int index)
    {
        listItem.getItems().clear();
        listItem.getItems().addAll(FXCollections.observableArrayList(menuCollection[index]));
    }

    private void addItem()
    {
        listOrder.add(listItem.getSelectionModel().getSelectedItem());
        displayOrder();
    }

    private void displayOrder()
    {
        areaOrderField.clear();
        String display = "";

        for (int i = 0; i < listOrder.size(); i++)
        {
            display += listOrder.get(i) + "\n";
        }

        areaOrderField.setText(display);
    }

    private void clearOrder()
    {
        listOrder.clear();
        areaOrderField.clear();
    }

    public static void main(String args[])
    {
        launch(args);
    }
}