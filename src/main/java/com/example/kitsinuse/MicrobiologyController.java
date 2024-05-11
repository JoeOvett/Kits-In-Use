package com.example.kitsinuse;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

import static com.example.kitsinuse.KitsInUse.HEIGHT;
import static com.example.kitsinuse.KitsInUse.WIDTH;

public class MicrobiologyController {

    @FXML
    private GridPane microGridPane;

    public void initialize() {
        Button newKitButton = createButton("New Kit", "/com/example/kitsinuse/images/note.png");
        newKitButton.getStyleClass().add("MicroButton");
        microGridPane.add(newKitButton, 0, 0);

        addStyledButton("New Kit", "/com/example/kitsinuse/images/qc.png", 1, 0);
        addStyledButton("Pending QCs", "/com/example/kitsinuse/images/hospital.png", 2, 0);
        addStyledButton("Kits Expired", "/com/example/kitsinuse/images/hospital.png", 0, 1);
        addStyledButton("Kits Discarded", "/com/example/kitsinuse/images/hospital.png", 1, 1);
        addStyledButton("Go Back", "/com/example/kitsinuse/images/hospital.png", 2, 1);

    }
    private void addStyledButton(String text, String imagePath, int column, int row) {
        Button button = createButton(text, imagePath);
        button.getStyleClass().add("MicroButton");
        microGridPane.add(button, column, row);
    }
    private void loadKitsInUseView(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/kitsinuse/kitsinuse-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, WIDTH, HEIGHT);            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadMicrobiologyView(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/kitsinuse/kitsinuse-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Button createButton(String text, String imagePath) {
        Button button = new Button(text);
        button.getStyleClass().add("MicroButton");
        button.setPrefSize(200, 250); // Set preferred size here for uniformity

        // Set the gradient as background with rounded corners

        // Load and set the image if provided
        ImageView imageView = loadImage(imagePath); // Pass imagePath to loadImage
        if (imageView != null) {
            imageView.setFitHeight(80);  // Set image size smaller than the button for aesthetic
            imageView.setFitWidth(80);
            button.setGraphic(imageView);
        }
        button.setContentDisplay(javafx.scene.control.ContentDisplay.TOP);

        return button;
    }

    private ImageView loadImage(String imagePath) {
        try {
            Image image = new Image(getClass().getResourceAsStream(imagePath));  // Ensure the image path is correct
            return new ImageView(image);
        } catch (Exception e) {
            System.err.println("Error loading image: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}