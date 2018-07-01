package com.example.android.foodquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz8Activity extends AppCompatActivity {

    // checkbox variables
    CheckBox cherry;
    CheckBox plum;
    CheckBox orange;
    CheckBox pear;
    CheckBox grape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz8);
        displayScore(Quiz1Activity.scoreMessage); // displays the current score in the new activity
    }

    // This method goes to last activity when the continue button is clicked
    public void lastPage(View view)
    {
        Intent last = new Intent(this, lastActivity.class);
        startActivity(last);
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

    // checkbox method for the 5 checkboxes
    public void tomatoCheckBox(View view)
    {
        cherry = (CheckBox) findViewById(R.id.cherry_checkbox);
        boolean isCherry = cherry.isChecked(); // isChecked() gets the state of the cherry checkbox and stores it in isCherry boolean variable

        plum = (CheckBox) findViewById(R.id.plum_checkbox);
        boolean isPlum = plum.isChecked(); // isChecked() gets the state of the plum checkbox and stores it in isPlum boolean variable

        orange = (CheckBox) findViewById(R.id.orange_checkbox);
        boolean isOrange = orange.isChecked(); // isChecked() gets the state of the orange checkbox and stores it in isOrange boolean variable

        pear = (CheckBox) findViewById(R.id.pear_checkbox);
        boolean isPear = pear.isChecked(); // isChecked() gets the state of the pear checkbox and stores it in isPear boolean variable

        grape = (CheckBox) findViewById(R.id.grape_checkbox);
        boolean isGrape = grape.isChecked(); // isChecked() gets the state of the grape checkbox and stores it in isGrape boolean variable

        // Gives 2 points if cherry and plum are checked as correct answers
        if(isCherry & isPlum & !isOrange & !isPear & !isGrape)
        {
            Quiz1Activity.score++; // Increments score by 1
            Quiz1Activity.score++; // Increments score by 1

            Quiz1Activity.scoreMessage = "Score: " + Quiz1Activity.score; // stores the current score as a String
            displayScore(Quiz1Activity.scoreMessage); // displays the current score on the screen

            cherry.setEnabled(false); // deactivates cherry checkbox after clicking
            plum.setEnabled(false); // deactivates plum checkbox after clicking
            orange.setEnabled(false); // deactivates orange checkbox after spag and macaroni are checked
            pear.setEnabled(false); // deactivates pear checkbox after spag and macaroni are checked
            grape.setEnabled(false); // deactivates grape checkbox after spag and macaroni are checked

            // Shows a message when the correct answers are checked
            Toast.makeText(this, "Bravo! Correct answer.\nAre you a Vegetarian???"
                    , Toast.LENGTH_LONG).show();
        } // ends if

        // Gives 1 point if one incorrect and one correct answer is checked
        if((isOrange || isPear || isGrape) && (isCherry || isPlum))
        {
            Quiz1Activity.score++; // Increments score by 1

            Quiz1Activity.scoreMessage = "Score: " + Quiz1Activity.score; // stores the current score as a String
            displayScore(Quiz1Activity.scoreMessage); // displays the current score on the screen

            cherry.setEnabled(false);
            plum.setEnabled(false);
            orange.setEnabled(false);
            pear.setEnabled(false);
            grape.setEnabled(false);

            // Shows a message when one correct and incorrect answer is checked
            Toast.makeText(this, "Mehn! You are almost correct.\nEat more Vegetables"
                    , Toast.LENGTH_LONG).show();
        } // ends if

        // reduces points by 2 if 2 incorrect answers are checked
        if((isOrange || isPear) && (isOrange || isGrape) && (isGrape || isPear))
        {
            Quiz1Activity.scoreMessage = "Score: " + Quiz1Activity.score;
            displayScore(Quiz1Activity.scoreMessage);

            cherry.setEnabled(false);
            plum.setEnabled(false);
            orange.setEnabled(false);
            pear.setEnabled(false);
            grape.setEnabled(false);

            // Shows a message when the correct answer is chosen
            Toast.makeText(this, "Sorry! Wrong answer.\nStart eating Vegetables. It is healthy!"
                    , Toast.LENGTH_LONG).show();
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
} // ends class Quiz8Activity
