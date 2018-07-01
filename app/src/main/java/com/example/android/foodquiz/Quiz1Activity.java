package com.example.android.foodquiz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz1Activity extends AppCompatActivity {

    public static int score; // the score of the player
    public static String scoreMessage; // stores the score as a String

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);
   }

   // This method goes to quiz2 activity when the continue button is clicked
    public void goToPageTwo(View view)
    {
        Intent quiz2 = new Intent(this, Quiz2Activity.class);
        startActivity(quiz2);
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

    // This method gets the state of the "TRUE" radio button
    public void getTrueForQuizOne(View view)
    {
        // isChecked() gets the state of the TRUE radio button
        // and stores it in quizOneTrue boolean variable
        boolean quizOneTrue = ((RadioButton)view).isChecked();

        if (quizOneTrue)
        {
            view.setEnabled(false); // deactivates TRUE radio button after clicking
            findViewById(R.id.watermelon_radio_false).setEnabled(false); // deactivates FALSE radio button after TRUE is clicked

            Quiz1Activity.score = score; // stores current score
            scoreMessage = "Score: " + Quiz1Activity.score; // stores the current score as a String
            Quiz1Activity.scoreMessage = scoreMessage; // stores current score message
            displayScore(Quiz1Activity.scoreMessage); // displays the current score on the screen

            // Shows a message when the wrong answer is chosen
            Toast.makeText(this, "Sorry! Wrong answer.\nA Watermelon is about 92% water by weight", Toast.LENGTH_LONG).show();
        } // ends if statement
    }

    // This method gets the state of the "False" radio button
    public void getFalseForQuizOne(View view)
    {
        //isChecked() gets the state of the FALSE radio button
        // and stores it in quizOneFalse boolean variable
        boolean quizOneFalse = ((RadioButton)view).isChecked();

        if (quizOneFalse)
        {
            findViewById(R.id.watermelon_radio_true).setEnabled(false); // deactivates TRUE radio button after FALSE is clicked
            view.setEnabled(false); // deactivates FALSE radio button after clicking

            score++; // Increments score by 1

            if (quizOneFalse == true)
            {
                score = score; // score remains constantly at the current score

            } // ends nested if statement

            Quiz1Activity.score = score; // stores current score
            scoreMessage = "Score: " + Quiz1Activity.score; // stores the current score as a String
            Quiz1Activity.scoreMessage = scoreMessage; // stores current score message
            displayScore(Quiz1Activity.scoreMessage); // displays the current score on the screen

            // Shows a message when the correct answer is chosen
            Toast.makeText(this, "Bravo! Good answer.\nA Watermelon is about 92% water by weight", Toast.LENGTH_LONG).show();
        } // ends if statement
    }


    /**
     * This method displays the given text on the screen.
     */
    public void displayScore(String message)
    {
       TextView scoreText = (TextView) findViewById(R.id.score_text_view);
       scoreText.setText(message);
    }
} // ends class Quiz1Activity


