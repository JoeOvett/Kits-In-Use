package com.example.kitsinuse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.geometry.Insets;

import java.io.IOException;

public class KitsInUse extends Application {
    public static final int WIDTH = 1024;
    public static final int HEIGHT = 768;

    public static Scene createScene(Parent root) {
        return new Scene(root, WIDTH, HEIGHT);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("kitsinuse-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), WIDTH, HEIGHT);
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
}}