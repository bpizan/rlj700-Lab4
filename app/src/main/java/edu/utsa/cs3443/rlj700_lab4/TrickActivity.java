package edu.utsa.cs3443.rlj700_lab4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import edu.utsa.cs3443.rlj700_lab4.model.Trivia;

public class TrickActivity extends AppCompatActivity implements View.OnClickListener {

    private Trivia trivia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trick);
        loadQuestion();
        setupQuestionText();
        setupButtons();
    }

    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;
        String userAnswer = clickedButton.getText().toString();

        if (userAnswer.equalsIgnoreCase(trivia.getCorrectAnswer())) {
            showToast("Correct!");
        } else {
            showToast("Incorrect. The correct answer is: " + trivia.getCorrectAnswer());
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void loadQuestion() {
        trivia = new Trivia();
        trivia.loadTrivia(this);
    }

    private void setupQuestionText() {
        TextView questionTextView = findViewById(R.id.questionText);
        questionTextView.setText(trivia.getQuestion());
    }

    private void setupButtons() {
        Button answerButton1 = findViewById(R.id.button1);
        Button answerButton2 = findViewById(R.id.button2);
        Button answerButton3 = findViewById(R.id.button3);

        answerButton1.setText(trivia.getOption1());
        answerButton2.setText(trivia.getOption2());
        answerButton3.setText(trivia.getOption3());

        answerButton1.setOnClickListener(this);
        answerButton2.setOnClickListener(this);
        answerButton3.setOnClickListener(this);
    }
}
