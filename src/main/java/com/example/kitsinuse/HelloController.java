package com.example.kitsinuse;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;


public class HelloController {
    @FXML
    private GridPane gridPane;

    @FXML
    private Label welcomeText;

    @FXML
    public void initialize() {
        // called after all @FXML annotated members have been set.
        gridPane.setPadding(new Insets(20, 20, 20, 20));
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to Kits In Use!");
    }
}
