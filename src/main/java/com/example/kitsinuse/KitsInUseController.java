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
        // Create and style the Microbiology button
        Button microbiologyButton = kits.createButton("Microbiology", "/com/example/kitsinuse/images/germs.png");
        microbiologyButton.getStyleClass().add("LandingButton"); // Add the CSS class
        microbiologyButton.setOnAction(this::loadMicrobiologyView);
        rootGridPane.add(microbiologyButton, 0, 0);

        // Add other buttons with similar style
        addStyledButton("Biochemistry", "/com/example/kitsinuse/images/blood-test.png", 1, 0);
        addStyledButton("Haematology", "/com/example/kitsinuse/images/blood-zoom.png", 2, 0);
        addStyledButton("Immunology", "/com/example/kitsinuse/images/drug-test.png", 0, 1);
        addStyledButton("Histology", "/com/example/kitsinuse/images/microscope.png", 1, 1);
        addStyledButton("Transfusion", "/com/example/kitsinuse/images/blood-transfusion.png", 2, 1);
    }
    private void addStyledButton(String text, String imagePath, int column, int row) {
        Button button = kits.createButton(text, imagePath);
        button.getStyleClass().add("LandingButton");
        rootGridPane.add(button, column, row);
    }
    private void loadMicrobiologyView(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/kitsinuse/microbiology-view.fxml"));
            Parent root = loader.load();
            Scene scene = kits.createScene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}