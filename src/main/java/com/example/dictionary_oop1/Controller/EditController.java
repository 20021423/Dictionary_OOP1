package com.example.dictionary_oop1.Controller;

import com.example.Database.DictionaryManager;
import com.example.dictionary_oop1.DictionaryManagement;
import com.example.dictionary_oop1.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class EditController {

    @FXML
    private TextField wordT;

    @FXML
    private TextField wordE;

    @FXML
    private Label mess;

    @FXML
    protected void buttonEdit(ActionEvent event) throws IOException, SQLException {
        boolean flag = DictionaryManagement.dictionaryLookup(wordT.getText()).equals("NOT FOUND");
        if (!flag) {
            DictionaryManager.fixWord(wordT.getText(), wordE.getText());
            DictionaryManagement.replaceWord(Objects.requireNonNull(DictionaryManagement.dictionaryLookup2(wordT.getText())), wordE.getText());
            mess.setText("Done!");
        } else {
            mess.setText("Invalid Word!");
        }
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

    public void changeSceneAPI(ActionEvent e) throws IOException {
        Stage current = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("APILayout.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        scene.getStylesheets().add((HelloApplication.class.getResource("Back.css")).toExternalForm());
        current.setScene(scene);
    }
}
