package edu.utsa.cs3443.rlj700_lab4.model;

import android.app.Activity;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class Trivia {

    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String descriptionAnswer;
    private String correctAnswer;

    public String getQuestion() {
        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getDescriptionAnswer() {
        return descriptionAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public Trivia loadTrivia(Activity mainActivity) {
        AssetManager manager = mainActivity.getAssets();
        BufferedReader reader = null;

        try {
            InputStream input = manager.open("trivia.csv");
            reader = new BufferedReader(new InputStreamReader(input));

            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            // Randomly select a line from the list
            Random random = new Random();
            int lineNumber = random.nextInt(lines.size());
            String selectedLine = lines.get(lineNumber);

            // Process the selected line
            String[] lineSplit = selectedLine.split(",");
            this.question = lineSplit[0].trim();
            this.option1 = lineSplit[1].trim();
            this.option2 = lineSplit[2].trim();
            this.option3 = lineSplit[3].trim();
            this.descriptionAnswer = lineSplit[4].trim();

            identifyCorrectAnswer();
        } catch (IOException e) {
            Log.d("Exception: ", "IO Exception");
        } finally {
            if (reader != null) {
                try {
                    reader.close(); // Close the BufferedReader
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    private void identifyCorrectAnswer() {
        // takes all the options and checks if the description contains any of the options, if so, that
        // option becomes the correctAnswer
        if (this.descriptionAnswer.contains(this.option1)) {
            setCorrectAnswer(this.option1);
        } else if (this.descriptionAnswer.contains(this.option2)) {
            setCorrectAnswer(this.option2);
        } else {
            setCorrectAnswer(this.option3);
        }
    }

    private void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
