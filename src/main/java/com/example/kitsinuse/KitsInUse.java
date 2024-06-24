package com.example.kitsinuse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import java.io.IOException;

public class KitsInUse extends Application {
    public static final int WIDTH = 1024;
    public static final int HEIGHT = 768;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("kitsinuse-view.fxml"));
        Parent root = fxmlLoader.load();

        // Create the NHS logo ImageView
        Image nhsLogo = new Image(getClass().getResourceAsStream("/com/example/kitsinuse/images/nhs_logo.png"));
        ImageView nhsLogoView = new ImageView(nhsLogo);
        nhsLogoView.setFitWidth(250);
        nhsLogoView.setPreserveRatio(true);

        // Create a StackPane to hold both the FXML content and the logo
        StackPane mainLayout = new StackPane();
        mainLayout.getChildren().addAll(root, nhsLogoView);

        // Position the logo in the top right corner
        StackPane.setAlignment(nhsLogoView, Pos.TOP_RIGHT);
        StackPane.setMargin(nhsLogoView, new Insets(10));

        Scene scene = new Scene(mainLayout, WIDTH, HEIGHT);
        stage.setTitle("Kits In Use");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public Button createButton(String text, String imagePath) {
        Button button = new Button(text);
        button.setPrefSize(200, 250); // Set preferred size here for uniformity

        ImageView imageView = loadImage(imagePath); // Pass imagePath to loadImage
        if (imageView != null) {
            imageView.setFitHeight(160);
            imageView.setFitWidth(160);
            button.setGraphic(imageView);
        }
        button.setContentDisplay(javafx.scene.control.ContentDisplay.TOP);

        return button;
    }

    private ImageView loadImage(String imagePath) {
        try {
            Image image = new Image(getClass().getResourceAsStream(imagePath)); // Use imagePath
            return new ImageView(image);
        } catch (Exception e) {
            System.err.println("Error loading image: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}