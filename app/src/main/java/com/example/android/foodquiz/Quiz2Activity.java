package com.example.android.foodquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.foodquiz.Quiz1Activity.score;
import static com.example.android.foodquiz.Quiz1Activity.scoreMessage;

public class Quiz2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);
        displayScore(Quiz1Activity.scoreMessage); // displays the current score in the new activity
    }

    // This method goes to quiz3 activity when the continue button is clicked
    public void goToPageThree(View view)
    {
        Intent quiz3 = new Intent(this, Quiz3Activity.class);
        startActivity(quiz3);
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
    public void getTrueForQuizTwo(View view)
    {
        // isChecked() gets the state of the TRUE radio button
        // and stores it in quizTwoTrue boolean variable
        boolean quizTwoTrue = ((RadioButton)view).isChecked();

        if (quizTwoTrue)
        {
            Quiz1Activity.score ++; // Increments score by 1

            view.setEnabled(false); // deactivates TRUE radio button after clicking
            findViewById(R.id.milk_radio_false).setEnabled(false); // deactivates FALSE radio button after TRUE is clicked

            if (quizTwoTrue == true)
            {
                Quiz1Activity.score = Quiz1Activity.score; // score remains constantly at the current score
            } // ends nested if statement

            Quiz1Activity.scoreMessage = "Score: " + Quiz1Activity.score; // stores the current score as a String
            //Log.v("Quiz2Activity", "Score: " + Quiz1Activity.score);
            displayScore(Quiz1Activity.scoreMessage); // displays the current score on the screen

            // Shows a message when the correct answer is chosen
            Toast.makeText(this, "Bravo! Good answer.\nFor a long time, drinking fresh milk was considered a luxury" +
                    " because milk was difficult to preserve", Toast.LENGTH_LONG).show();
        } // ends if statement
    }

    // This method gets the state of the "False" radio button
    public void getFalseForQuizTwo(View view)
    {
        // isChecked() gets the state of the FALSE radio button
        // and stores it in quizTwoFalse boolean variable
        boolean quizTwoFalse = ((RadioButton)view).isChecked();

        if (quizTwoFalse)
        {
            Quiz1Activity.scoreMessage = "Score: " + Quiz1Activity.score; // stores the current score as a String
            displayScore(Quiz1Activity.scoreMessage); // displays the current score on the screen

            view.setEnabled(false); // deactivates FALSE radio button after clicking
            findViewById(R.id.milk_radio_true).setEnabled(false); // deactivates TRUE radio button after FALSE is clicked

            // Shows a message when the wrong answer is chosen
            Toast.makeText(this, "Sorry! Wrong answer.\nFor a long time, drinking fresh milk was considered a luxury" +
                    " because milk was difficult to preserve", Toast.LENGTH_LONG).show();
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
} // ends class Quiz2Activity


