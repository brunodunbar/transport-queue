package com.brunodunbar.transportqueue;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Bootstrap extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/App.fxml"));
        Scene scene = new Scene(root, 500, 400);
        scene.getStylesheets().add("/app.css");

        primaryStage.setScene(scene);
        primaryStage.setTitle("Transportadora");
        primaryStage.setResizable(false);
        primaryStage.show();


    }
}
