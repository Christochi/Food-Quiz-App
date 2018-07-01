package com.example.android.foodquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz6Activity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz6);
        displayScore(Quiz1Activity.scoreMessage); // displays the current score in the new activity
    }

    // This method goes to quiz7 activity when the continue button is clicked
    public void goToPageSeven(View view)
    {
        Intent quiz7 = new Intent(this, Quiz7Activity.class);
        startActivity(quiz7);
        //finish(); // prevents going to previous activity
    }

    //disable go back button action
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK) {
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    // method sets the text in the EditText
    public void setText(View view)
    {
        editText = (EditText) findViewById(R.id.edit_text_answer);
        String text = editText.getText().toString(); // gets the inputted text and converts to String
        String answer = "Yeast";

        if (text.equals(answer))
        {
            Quiz1Activity.score ++; // Increments score by 1

            view.setEnabled(false); // deactivates text input

            Quiz1Activity.scoreMessage = "Score: " + Quiz1Activity.score; // stores the current score as a String
            displayScore(Quiz1Activity.scoreMessage); // displays the current score on the screen

            // Shows a message when the correct answer is inputted
            Toast.makeText(this, "Bravo! Good answer.\nYeast produces the gas that makes bread rise." +
                    " It does this by feeding on tne sugars in flour and expelling carbondioxide in the process", Toast.LENGTH_LONG).show();
        } // ends if

        if (!text.equals(answer) )
        {
            view.setEnabled(false); // deactivates text input

            Quiz1Activity.scoreMessage = "Score: " + Quiz1Activity.score;
            displayScore(Quiz1Activity.scoreMessage);

            // Shows a message when the wrong answer is inputted
            Toast.makeText(this, "Sorry! Wrong answer.\nYeast produces the gas that makes bread rise." +
                    " It does this by feeding on tne sugars in flour and expelling carbondioxide in the process", Toast.LENGTH_LONG).show();
        } // ends if
    }

    /**
     * This method displays the given text on the screen.
     */
    public void displayScore(String message)
    {
        TextView scoreText = (TextView) findViewById(R.id.score_text_view);
        scoreText.setText(message);
    }
} // ends class Quiz6Activity
