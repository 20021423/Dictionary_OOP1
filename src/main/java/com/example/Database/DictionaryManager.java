package com.example.Database;

import com.example.dictionary_oop1.Dictionary;
import com.example.dictionary_oop1.Word;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DictionaryManager {
    /**
     * Reference: https://openplanning.net/10167/java-jdbc
     */
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
     * Inserts word to the database.
     */
    public static void insertWord(final String word, final String detail) throws SQLException {
        final String sqlInsertData = "insert into dictionary (word, detail) value (?, ?)";

        preparedness = connection.prepareStatement(sqlInsertData);
        preparedness.setString(1, word);
        preparedness.setString(2, detail);
        preparedness.executeUpdate();

        System.out.println("Inserted successfully");
    }

    /**
     * Deletes a word from the database.
     */
    public static void deleteWord(String word) throws SQLException {
        String sqlDeleteData = "delete from dictionary where word = ?";
        preparedness = connection.prepareStatement(sqlDeleteData);
        preparedness.setString(1, word);
        preparedness.executeUpdate();
    }

    /**
     * Fixes a Word's detail.
     */
    public static void fixWord(String word, String detail) throws SQLException {
        String sqlFixData = "update dictionary set detail = ? where word = ? ";
        preparedness = connection.prepareStatement(sqlFixData);
        preparedness.setString(1, detail);
        preparedness.setString(2, word);
        preparedness.executeUpdate();
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
