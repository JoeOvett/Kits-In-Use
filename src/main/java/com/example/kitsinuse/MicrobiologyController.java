package com.example.kitsinuse;

import javafx.fxml.FXML;
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

public class MicrobiologyController {


    @FXML
    private GridPane microGridPane;

    @FXML
    public void initialize() {
        // Initialize with buttons, similar to your main page setup
        microGridPane.add(createButton("New Kit", "path/to/image2.png"), 0, 0);
        microGridPane.add(createButton("View Kits", "path/to/image3.png"), 1, 0);
        microGridPane.add(createButton("Edit Kits", "path/to/image4.png"), 2, 0);
        microGridPane.add(createButton("Delete Kits", "path/to/image5.png"), 0, 1);
        microGridPane.add(createButton("Search Kits", "path/to/image6.png"), 1, 1);
        microGridPane.add(createButton("Back", "path/to/image7.png"), 2, 1);
    }

    public Button createButton(String text, String imagePath) {
        Button button = new Button(text);
        button.setPrefSize(200, 250);  // Set a preferred size for the button

        // Create a gradient background
        LinearGradient gradient = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("#01cdfe")),  // Light pink
                new Stop(1, Color.web("#fffb96")));  // Dark purple

        // Set the gradient as background with rounded corners
        button.setBackground(new Background(new BackgroundFill(gradient, new CornerRadii(20), Insets.EMPTY)));

        // Load and set the image if provided
        ImageView imageView = loadImage("/com/example/kitsinuse/images/hospital.png");
        if (imageView != null) {
            imageView.setFitHeight(80);  // Set image size smaller than the button for aesthetic
            imageView.setFitWidth(80);
            button.setGraphic(imageView);
        }

        button.setStyle("-fx-font-weight: bold; -fx-text-fill: white;");  // Set text style

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