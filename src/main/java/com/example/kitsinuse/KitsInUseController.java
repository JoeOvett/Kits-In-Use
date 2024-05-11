package com.example.kitsinuse;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Node;

import java.io.IOException;

public class KitsInUseController {
    @FXML
    private GridPane rootGridPane;

    private KitsInUse kits = new KitsInUse();

    @FXML
    public void initialize() {
        // Dynamically add buttons to the VBox
        Button microbiologyButton = kits.createButton("Microbiology", "path/to/image1.png");
        microbiologyButton.setOnAction(this::loadMicrobiologyView);
        rootGridPane.add(microbiologyButton, 0, 0);
        rootGridPane.add(kits.createButton("Biochemistry", "path/to/image2.png"), 1, 0);
        rootGridPane.add(kits.createButton("Haematology", "path/to/image3.png"), 2, 0);
        rootGridPane.add(kits.createButton("Immunology", "path/to/image4.png"), 0, 1);
        rootGridPane.add(kits.createButton("Histology", "path/to/image5.png"), 1, 1);
        rootGridPane.add(kits.createButton("Transfusion", "path/to/image6.png"), 2, 1);
        //rootVBox.getChildren().add(kits.createButton("Exit", "path/to/image6.png"));
    }

    private void loadMicrobiologyView(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/kitsinuse/microbiology-view.fxml"));
            Parent root = loader.load();
            Scene scene = KitsInUse.createScene(root);  // Ensure this method correctly sets the scene size
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}