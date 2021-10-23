package com.example.dictionary_oop1;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import java.util.Scanner;

public class TextToSpeech {

    private String voiceName = "kevin16";
    private Voice voice;

    public TextToSpeech() {

    }

    public TextToSpeech(String name) {
        this.voiceName = name;
    }

    public void setVoiceName(String voiceName) {
        this.voiceName = voiceName;
    }


    public void speak(String word) {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        this.voice = VoiceManager.getInstance().getVoice(this.voiceName);
        this.voice.allocate();
        this.voice.speak(word);
    }

    public static void main(String[] args) throws InterruptedException {
        TextToSpeech textToSpeech = new TextToSpeech("kevin16");
        textToSpeech.speak("Hello it's me");
        textToSpeech.setVoiceName("kevin");
        textToSpeech.speak("hello it's me");
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
            String s = sc.next();
            textToSpeech.speak(s);
            Thread.sleep(2000);
        }
    }
}
