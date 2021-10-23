package com.example.dictionary_oop1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 800);
        stage.setTitle("English Dictionary");
        stage.setScene(scene);
        stage.show();

//        ListView listView = new ListView();
//
//        listView.getItems().add("Item 1");
//        listView.getItems().add("Item 2");
//        listView.getItems().add("Item 3");
//
//        HBox hbox = new HBox(listView);
//
//        Scene scene = new Scene(hbox, 300, 120);
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }

    public static void main(String[] args) throws FileNotFoundException {
        DictionaryManagement.insertFromFile();
        launch();
    }
}