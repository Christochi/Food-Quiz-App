package com.example.android.foodquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz5);
        displayScore(Quiz1Activity.scoreMessage); // displays the current score in the new activity
    }

    // This method goes to quiz6 activity when the continue button is clicked
    public void goToPageSix(View view)
    {
        Intent quiz6 = new Intent(this, Quiz6Activity.class);
        startActivity(quiz6);
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
    public void getTrueForQuizFive(View view)
    {
        // isChecked() gets the state of the TRUE radio button
        // and stores it in quizFiveTrue boolean variable
        boolean quizFiveTrue = ((RadioButton)view).isChecked();

        if (quizFiveTrue)
        {
            Quiz1Activity.score ++; // Increments score by 1
            view.setEnabled(false); // deactivates TRUE radio button after clicking
            findViewById(R.id.aeroplane_radio_false).setEnabled(false); // deactivates FALSE radio button after TRUE is clicked

            if (quizFiveTrue == true)
            {
              Quiz1Activity.score = Quiz1Activity.score; // score remains constantly at the current score
            } // ends nested if statement

            Quiz1Activity.scoreMessage = "Score: " + Quiz1Activity.score; // stores the current score as a String
            displayScore(Quiz1Activity.scoreMessage); // displays the current score on the screen

            // Shows a message when the correct answer is chosen
            Toast.makeText(this, "Bravo! Good answer.\nOur Senses of smell and taste diminishes" +
                    " by 20% to 50% at high altitudes", Toast.LENGTH_LONG).show();
        } // ends if statement
    }

    // This method gets the state of the "False" radio button
    public void getFalseForQuizFive(View view)
    {
        //isChecked() gets the state of the FALSE radio button
        // and stores it in quizFiveFalse boolean variable
        boolean quizFiveFalse = ((RadioButton)view).isChecked();

        if (quizFiveFalse)
        {
            Quiz1Activity.scoreMessage = "Score: " + Quiz1Activity.score; // stores the current score as a String
            displayScore(Quiz1Activity.scoreMessage); // displays the current score on the screen

            view.setEnabled(false); // deactivates FALSE radio button after clicking
            findViewById(R.id.aeroplane_radio_true).setEnabled(false); // deactivates TRUE radio button after FALSE is clicked

            // Shows a message when the wrong answer is chosen
            Toast.makeText(this, "Sorry! Wrong answer.\nOur Senses of smell and taste diminishes" +
                    " by 20% to 50% at high altitudes", Toast.LENGTH_LONG).show();
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
} // ends class Quiz5Activity
