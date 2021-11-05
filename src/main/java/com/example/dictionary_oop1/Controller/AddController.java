package com.example.dictionary_oop1.Controller;

import com.example.Database.DictionaryManager;
import com.example.dictionary_oop1.Dictionary;
import com.example.dictionary_oop1.DictionaryManagement;
import com.example.dictionary_oop1.HelloApplication;
import com.example.dictionary_oop1.Word;
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

public class AddController {

    @FXML
    private TextField wordTarget;

    @FXML
    private TextField wordExplain;

    @FXML
    private Label AddMess;

    @FXML
    protected void buttonAdd(ActionEvent event) throws IOException, SQLException {
        if (DictionaryManagement.dictionaryLookup(wordTarget.getText().toLowerCase()).equals("NOT FOUND")) {
            Dictionary.addWord(new Word(wordTarget.getText(), wordExplain.getText()));
            AddMess.setText("Done!");
//            DictionaryManagement.dictionaryExportToFile(wordTarget.getText(), wordExplain.getText());
            DictionaryManager.insertWord(wordTarget.getText(), wordExplain.getText());
        } else AddMess.setText("Invalid word!");
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

    public void changeSceneEdit(ActionEvent e) throws IOException {
        Stage current = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("EditLayout.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        scene.getStylesheets().add((HelloApplication.class.getResource("Back.css")).toExternalForm());
        current.setScene(scene);
    }
}
