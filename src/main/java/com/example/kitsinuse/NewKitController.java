package com.example.kitsinuse;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class NewKitController {
    public VBox mainVBox;
    public Label titleLabel;
    public GridPane formGridPane;
    @FXML
    public TextField enteredByField;
    @FXML
    private TextField barcodeField;
    public TextField kitDescriptionField;
    public TextField receivedDateField;

    public TextField lotNumberField;
    public TextField expirationDateField;
    public ComboBox supplierBox;
    public ComboBox qualityControlBox;
    public TextField inUseDateField;


    @FXML
    private ComboBox<String> kitDescriptionBox;
    

    public NewKitController() {
    }

    public NewKitController(GridPane newKitGridPane) {
    }



    @FXML
    private void handleSaveAction() {
        // Code to save data
        System.out.println("Data Saved!");
    }

    @FXML
    private void handleClearAction() {
        // Clear all text fields and reset combo boxes
        enteredByField.clear();
        barcodeField.clear();
        kitDescriptionBox.getSelectionModel().clearSelection();
    }

    @FXML
    private void handleExitAction() {
        System.exit(0);
    }
}
