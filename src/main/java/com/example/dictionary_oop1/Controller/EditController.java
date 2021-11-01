package com.example.dictionary_oop1.Controller;

import com.example.dictionary_oop1.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EditController {
    public void changeSceneAdd(ActionEvent e) throws IOException {
        Stage current = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("AddLayout.fxml"));
        Scene scene = new Scene(loader.load(),600,400);
        scene.getStylesheets().add((HelloApplication.class.getResource("Back.css")).toExternalForm());
        current.setScene(scene);
    }

    public void changeSceneDelete(ActionEvent e) throws IOException {
        Stage current = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("DeleteLayout.fxml"));
        Scene scene = new Scene(loader.load(),600,400);
        scene.getStylesheets().add((HelloApplication.class.getResource("Back.css")).toExternalForm());
        current.setScene(scene);
    }

    public void changeSceneList(ActionEvent e) throws IOException {
        Stage current = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("ListLayout.fxml"));
        Scene scene = new Scene(loader.load(),600,400);
        scene.getStylesheets().add((HelloApplication.class.getResource("Back.css")).toExternalForm());
        current.setScene(scene);
    }

    public void changeSceneAPI(ActionEvent e) throws IOException {
        Stage current = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("APILayout.fxml"));
        Scene scene = new Scene(loader.load(),600,400);
        scene.getStylesheets().add((HelloApplication.class.getResource("Back.css")).toExternalForm());
        current.setScene(scene);
    }
}
