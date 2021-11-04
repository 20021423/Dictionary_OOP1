package com.example.dictionary_oop1.Controller;

import com.example.dictionary_oop1.API;
import com.example.dictionary_oop1.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;

public class APIController {
    @FXML
    private TextArea input;

    @FXML
    private WebView result;

    @FXML
    protected void buttonEtV(ActionEvent event) throws IOException {
        String in = input.getText();
        result.getEngine().loadContent(API.translate("vi", "en", in));
    }

    @FXML
    protected void buttonVtE(ActionEvent event) throws IOException {
        String in = input.getText();
        result.getEngine().loadContent(API.translate("vi", "en", in));
    }

    public void changeSceneEdit(ActionEvent e) throws IOException {
        Stage current = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("EditLayout.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        scene.getStylesheets().add((HelloApplication.class.getResource("Back.css")).toExternalForm());
        current.setScene(scene);
    }

    public void changeSceneAdd(ActionEvent e) throws IOException {
        Stage current = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("AddLayout.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        scene.getStylesheets().add((HelloApplication.class.getResource("Back.css")).toExternalForm());
        current.setScene(scene);
    }

    public void changeSceneDelete(ActionEvent e) throws IOException {
        Stage current = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("DeleteLayout.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        scene.getStylesheets().add((HelloApplication.class.getResource("Back.css")).toExternalForm());
        current.setScene(scene);
    }

    public void changeSceneList(ActionEvent e) throws IOException {
        Stage current = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("ListLayout.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        scene.getStylesheets().add((HelloApplication.class.getResource("Back.css")).toExternalForm());
        current.setScene(scene);
    }

}
