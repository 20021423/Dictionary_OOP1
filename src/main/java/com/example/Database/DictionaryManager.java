package com.example.Database;

import com.example.dictionary_oop1.Dictionary;
import com.example.dictionary_oop1.Word;

import java.sql.*;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *  Ref
 */

public class DictionaryManager {
    public static java.sql.Connection connection;
    public static java.sql.PreparedStatement preparedness;

    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dictionarydb", "root", "tuquanquyet1234");
            System.out.println("Connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Takes words from database to word list.
     */
    public static void getAllWord() throws SQLException {
        String sqlGetAllWord = "SELECT * FROM dictionarydb.dictionary ORDER BY word";
        Statement st = connection.createStatement();
        ResultSet resultSet = st.executeQuery(sqlGetAllWord);
        while (resultSet.next()) {
            String word = resultSet.getString("word");
            String detail = resultSet.getString("detail");
            Word w = new Word(word, detail);
            Dictionary.addWord(w);
        }
        st.close();
    }
}
