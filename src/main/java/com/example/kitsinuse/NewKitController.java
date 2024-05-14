package com.example.kitsinuse;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class NewKitController {
    @FXML
    public VBox mainVBox;
    @FXML
    public Label titleLabel;
    @FXML
    public GridPane formGridPane;
    @FXML
    public TextField enteredByField;
    @FXML
    private TextField barcodeField;
    @FXML
    public TextField kitDescriptionField;
    @FXML
    public TextField receivedDateField;
    @FXML
    public TextField lotNumberField;
    @FXML
    public TextField expirationDateField;
    @FXML
    public ComboBox<String> supplierBox;
    @FXML
    public ComboBox<String> qualityControlBox;
    @FXML
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
        receivedDateField.clear();
        lotNumberField.clear();
        expirationDateField.clear();
        supplierBox.getSelectionModel().clearSelection();
        qualityControlBox.getSelectionModel().clearSelection();
        inUseDateField.clear();
    }

    @FXML
    private void handleExitAction() {
        System.exit(0);
    }
}
