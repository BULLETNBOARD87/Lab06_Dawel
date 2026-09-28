package com.mycompany.lab06_francesco2;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    public static double bill = 0;
    
    @Override
    public void start(Stage stage) {
        
        ComboBox beverageSelector = new ComboBox();
        ComboBox appetizerSelector = new ComboBox();
        ComboBox mainCouseSelector = new ComboBox();
        ComboBox dessertSelector = new ComboBox();
        
        Slider slider = new Slider(0, 0.2, 0);
        slider.setOrientation(Orientation.HORIZONTAL);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickUnit(0.05);
        
        double[] beveragePrices = {2.5,2,1.75,2.95,1.5,2.5};
        double[] appetizerPrices = {4.50,3.75,5.25,3.00,6.95};
        double[] mainCoursePrices = {15.00, 13.50, 13.95, 11.90, 18.99, 11.75, 12.25};
        double[] dessertPrices = {5.95,4.50,4.75,3.25,5.98};
        
        beverageSelector.setPrefWidth(100);
        
        Label label1 = new Label("Category");
        Label label2 = new Label("Items");
        Label label3 = new Label("Beverages");
        Label label4 = new Label("Appetizers");
        Label label5 = new Label("Main Courses");
        Label label6 = new Label("Desserts");
        Label label7 = new Label("Price");
        Label label8 = new Label("0");
        
        Button clearButton = new Button("Clear");
        
        GridPane gridPane = new GridPane();
        
        beverageSelector.getItems().addAll("Coffee", "Tea", "Soft Drink", "Water", "Milk", "Juice");
        appetizerSelector.getItems().addAll("Soup","Salad","Spring Rolls","Garlic Bread","Chips and Salsa");
        mainCouseSelector.getItems().addAll("Steak","Grilled Chicken","Chicken Alfredo","Turkey Club","Shrimp Scampi","Pasta","Fish and Chips");
        dessertSelector.getItems().addAll("Apple Pie","Carrot Cake","Mud Pie", "Pudding", "Apple Crisp");
       
        gridPane.add(label1, 0,0);
        gridPane.add(label2, 1,0);
        gridPane.add(label3, 0,1);
        gridPane.add(label4, 0,2);
        gridPane.add(label5, 0,3);
        gridPane.add(label6, 0,4);
        gridPane.add(clearButton, 0,5);
        gridPane.add(slider, 0,6);
        gridPane.add(label7, 0,7);
        gridPane.add(label8, 1,7);
        gridPane.add(beverageSelector, 1,1);
        gridPane.add(appetizerSelector, 1,2);
        gridPane.add(mainCouseSelector, 1,3);
        gridPane.add(dessertSelector, 1,4);
        
        beverageSelector.setOnAction(e -> {
            double tip = slider.getValue();
            int index = beverageSelector.getSelectionModel().getSelectedIndex();
            bill += beveragePrices[index];
            double tipIncrease = beveragePrices[index] * tip;
            label8.setText( String.valueOf(bill + tipIncrease));
        });
        appetizerSelector.setOnAction(e -> {
            double tip = slider.getValue();
            int index = appetizerSelector.getSelectionModel().getSelectedIndex();
            bill += appetizerPrices[index];
            double tipIncrease = appetizerPrices[index] * tip;
            label8.setText( String.valueOf(bill + tipIncrease));
        });
        mainCouseSelector.setOnAction(e -> {
            double tip = slider.getValue();
            int index = mainCouseSelector.getSelectionModel().getSelectedIndex();
            bill += mainCoursePrices[index];
            double tipIncrease = mainCoursePrices[index] * tip;
            label8.setText( String.valueOf(bill + tipIncrease));
        });
        dessertSelector.setOnAction(e -> {
            double tip = slider.getValue();
            int index = dessertSelector.getSelectionModel().getSelectedIndex();
            bill += dessertPrices[index];
            double tipIncrease = dessertPrices[index] * tip;
            label8.setText( String.valueOf(bill + tipIncrease));
        });
        clearButton.setOnAction(e -> {
            bill = 0;
            beverageSelector.getSelectionModel().clearSelection();
            appetizerSelector.getSelectionModel().clearSelection();
            mainCouseSelector.getSelectionModel().clearSelection();
            dessertSelector.getSelectionModel().clearSelection();
            slider.setValue(0);

            label8.setText( String.valueOf(bill));
        });
        
        Scene scene = new Scene(gridPane, 300, 300);
        stage.setScene(scene);
        stage.setTitle("Resturant Price Calculator");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}