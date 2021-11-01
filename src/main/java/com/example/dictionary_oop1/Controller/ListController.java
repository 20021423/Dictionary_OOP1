package com.example.dictionary_oop1.Controller;

import com.example.dictionary_oop1.DictionaryManagement;
import com.example.dictionary_oop1.HelloApplication;
import com.example.dictionary_oop1.TextToSpeech;
import com.example.dictionary_oop1.Word;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class ListController {
    private static String currentword = "";

    @FXML
    private WebView WebText;


    @FXML
    TextField textField;

    @FXML
    ListView<String> listView = new ListView<String>();

    @FXML
    protected void buttonSearch(ActionEvent event) {
        listView.getItems().clear();
        String input = textField.getText();
        ArrayList<Word> list = DictionaryManagement.dictionarySearcher(input);
        for (int i = 0; i < list.size(); i++) {
            listView.getItems().add(list.get(i).getWord_target());
        }
    }

    @FXML
    protected void buttonSpeak(ActionEvent event) {
        TextToSpeech tts = new TextToSpeech("kevin16");
        tts.speak(currentword);
    }

    @FXML
    protected void handleItemClicks() {
        listView.setOnMouseClicked(event -> {
            String selectedItem = listView.getSelectionModel().getSelectedItem();
            WebText.getEngine().loadContent(DictionaryManagement.dictionaryLookup(selectedItem));
            currentword = selectedItem;
        });
    }

    public void changeSceneAPI(ActionEvent e) throws IOException {
        Stage current = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("APILayout.fxml"));
        Scene scene = new Scene(loader.load(),600,400);
        scene.getStylesheets().add((HelloApplication.class.getResource("Back.css")).toExternalForm());
        current.setScene(scene);
    }

    public void changeSceneEdit(ActionEvent e) throws IOException {
        Stage current = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("EditLayout.fxml"));
        Scene scene = new Scene(loader.load(),600,400);
        scene.getStylesheets().add((HelloApplication.class.getResource("Back.css")).toExternalForm());
        current.setScene(scene);
    }

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
}
