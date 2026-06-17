package com.example.cando_basededatos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader =
                new FXMLLoader(
                        Main.class.getResource("principal.fxml"));

        Scene scene = new Scene(loader.load());

        scene.getStylesheets().add(
                Main.class.getResource("estilos.css")
                        .toExternalForm());

        stage.setTitle("Sistema de Productos");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}