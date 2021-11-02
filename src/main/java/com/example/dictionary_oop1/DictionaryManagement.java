package com.example.dictionary_oop1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement {
    private static ArrayList<Word> arrayList = Dictionary.getWordArrayList();

    public static ArrayList<Word> getArrayList() {
        return arrayList;
    }

    public static void removeWord(Word word) {
        arrayList.remove(word);
    }

    public static void replaceWord(Word word, String newE ) {
        word.setWord_explain(newE);
    }

    public static void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        Dictionary dictionary = new Dictionary();
        dictionary.input();
    }

    public static ArrayList<Word> insertFromFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/main/java/com/example/dictionary_oop1/dictionaries.txt"));
        while (sc.hasNext()) {
            String s = sc.next();
            String k = sc.nextLine();
            arrayList.add(new Word(s, k));
        }
        sc.close();
        return arrayList;
    }

    public static String dictionaryLookup(String temp) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getWord_target().equals(temp)) {
                return arrayList.get(i).getWord_explain();
            }
        }
        return "NOT FOUND";
    }

    public static Word dictionaryLookup2(String temp) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getWord_target().equals(temp)) {
                return arrayList.get(i);
            }
        }
        return null;
    }

    public static ArrayList<Word> dictionarySearcher(String temp) {
        ArrayList<Word> result = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getWord_target().startsWith(temp)) {
                result.add(arrayList.get(i));
            }
        }
        for (int i = 0; i < j; i++) {
            System.out.println(result.get(i).getWord_target());
        }
        return result;
    }

    public static void dictionaryExportToFile(String wordT, String wordE) throws IOException {
        File file = new File("src/main/java/com/example/dictionary_oop1/dictionaries.txt");
        FileOutputStream dict = new FileOutputStream(file);
        String temp = "";
        temp = wordT + " " + wordE + "\n";
        dict.write(temp.getBytes());
        dict.close();
    }

    public static void deleteWord() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap tu ban muon xoa: ");
        String temp = sc.next();
        boolean flag = false;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getWord_target().equals(temp)) {
                flag = true;
                arrayList.remove(arrayList.get(i));
            }
        }
        if (!flag) {
            System.out.println("NOT FOUND!");
        }
    }

    public static void editWord() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap tu ban muon sua: ");
        String temp = sc.next();
        boolean flag = false;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getWord_target().equals(temp)) {
                flag = true;
                System.out.print("Ban muon sua thanh: ");
                String editEnglish = sc.next();
                String editVietnamese = sc.nextLine();
                arrayList.get(i).setWord_target(editEnglish);
                arrayList.get(i).setWord_explain(editVietnamese);
                break;
            }
        }
        if (!flag) {
            System.out.println("NOT FOUND");
        }
    }
}