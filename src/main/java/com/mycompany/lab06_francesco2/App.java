package com.mycompany.lab06_francesco2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
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

    @Override
    public void start(Stage stage) {
        Label bagLabel = new Label("Select Bag to Purchase");
        Label quantityLabel = new Label("Select Amount to Purchase");
        Label orderLabel = new Label(" ");
    
        VBox vbox = new VBox();
        HBox hbox = new HBox();
        
        Button orderButton = new Button("Order");
        Button clearButton = new Button("Clear");
        
        ListView<String> bags = new ListView<>();
        bags.setPrefHeight(140);
        
        RadioButton radio1 = new RadioButton("Small");
        RadioButton radio2 = new RadioButton("Medium");
        RadioButton radio3 = new RadioButton("Large");
        
        ToggleGroup sizeSelector = new ToggleGroup();
        sizeSelector.getToggles().addAll(radio1, radio2, radio3);
        
        GridPane bagPane = new GridPane();
        vbox.getChildren().addAll(radio1, radio2, radio3);
        hbox.getChildren().addAll(orderButton, clearButton);
        ComboBox quantities = new ComboBox();
        quantities.getItems().addAll("1","2","3","4","5","6","7","8","9","10");
        bags.getItems().addAll("Full Decorative", "Beaded", "Pirate Design", "Fringed", "Leather", "Plain");
        
        bagPane.add(bagLabel, 0, 0);
        bagPane.add(quantityLabel, 0, 2);
        bagPane.add(bags, 0, 1);
        bagPane.add(quantities, 1, 2);
        bagPane.add(vbox, 1, 1);
        bagPane.add(hbox, 0, 3);
        bagPane.add(orderLabel, 0, 4);
        
        orderButton.setOnAction(e -> 
        {
            String bagSelection = bags.getSelectionModel().getSelectedItem();
            String sizeSelection = "";
            String numSelected = (String) quantities.getValue();
            
            if (radio1.isSelected())
            {
                sizeSelection = "Small";
            }
            if (radio2.isSelected())
            {
                sizeSelection = "Medium";
            }
            if (radio3.isSelected())
            {
                sizeSelection = "Large";
            }
            
            orderLabel.setText("You ordered " + numSelected + " " + sizeSelection + " " + bagSelection + "Bags.");
        });
        
        clearButton.setOnAction(e -> 
        {
            orderLabel.setText(" ");
        });
        
        Scene scene = new Scene(bagPane, 350, 250);
        stage.setScene(scene);
        stage.setTitle("Bag Selector");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}