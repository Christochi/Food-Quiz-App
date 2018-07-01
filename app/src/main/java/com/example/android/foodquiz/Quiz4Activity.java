package com.example.android.foodquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz4);
        displayScore(Quiz1Activity.scoreMessage); // displays the current score in the new activity
    }

    // This method goes to quiz5 activity when the continue button is clicked
   public void goToPageFive(View view)
   {
       Intent quiz5 = new Intent(this, Quiz5Activity.class);
       startActivity(quiz5);
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
    public void getTrueForQuizFour(View view)
    {
        // isChecked() gets the state of the TRUE radio button
        // and stores it in quizFourTrue boolean variable
        boolean quizFourTrue = ((RadioButton)view).isChecked();

        if (quizFourTrue)
        {
            Quiz1Activity.score ++; // Increments score by 1

            view.setEnabled(false); // deactivates TRUE radio button after clicking
            findViewById(R.id.chocolate_radio_false).setEnabled(false); // deactivates FALSE radio button after TRUE is clicked

            if (quizFourTrue == true)
            {
                Quiz1Activity.score = Quiz1Activity.score; // score remains constantly at the current score
            } // ends nested if statement

            Quiz1Activity.scoreMessage = "Score: " + Quiz1Activity.score; // stores the current score as a String
            displayScore(Quiz1Activity.scoreMessage); // displays the current score on the screen

            // Shows a message when the correct answer is chosen
            Toast.makeText(this, "Bravo! Good answer.\nThe melting point of chocolate is just below" +
                    " our natural body temperature, which is why it literally melts in our mouth", Toast.LENGTH_LONG).show();
        } // ends if statement
    }

    // This method gets the state of the "False" radio button
    public void getFalseForQuizFour(View view) {
        // isChecked() gets the state of the FALSE radio button
        // and stores it in quizFourFalse boolean variable
        boolean quizFourFalse = ((RadioButton) view).isChecked();

        if (quizFourFalse)
        {
            Quiz1Activity.scoreMessage = "Score: " + Quiz1Activity.score; // stores the current score as a String
            displayScore(Quiz1Activity.scoreMessage); // displays the current score on the screen

            view.setEnabled(false); // deactivates FALSE radio button after clicking
            findViewById(R.id.chocolate_radio_true).setEnabled(false); // deactivates TRUE radio button after FALSE is clicked

            // Shows a message when the wrong answer is chosen
            Toast.makeText(this, "Sorry! Wrong answer.\nThe melting point of chocolate is just below" +
                    " our natural body temperature, which is why it literally melts in our mouth", Toast.LENGTH_LONG).show();
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
} // ends class Quiz4Activity

