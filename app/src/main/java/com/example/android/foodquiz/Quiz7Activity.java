package com.example.android.foodquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz7Activity extends AppCompatActivity {

    // checkbox variables
    CheckBox bread;
    CheckBox potato;
    CheckBox spag;
    CheckBox shawarma;
    CheckBox macaroni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz7);
        displayScore(Quiz1Activity.scoreMessage); // displays the current score in the new activity
    }

   // This method goes to quiz8 activity when the continue button is clicked
   public void goToPageEight(View view)
   {
        Intent quiz8 = new Intent(this, Quiz8Activity.class);
        startActivity(quiz8);
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
    public void pastaCheckBox(View view)
   {
       bread = (CheckBox) findViewById(R.id.bread_checkbox);
       boolean isBread = bread.isChecked(); // isChecked() gets the state of the bread checkbox and stores it in isBread boolean variable

       potato = (CheckBox) findViewById(R.id.potato_checkbox);
       boolean isPotato = potato.isChecked(); // isChecked() gets the state of the potato checkbox and stores it in isPotato boolean variable

       spag = (CheckBox) findViewById(R.id.spag_checkbox);
       boolean isSpag = spag.isChecked(); // isChecked() gets the state of the spag checkbox and stores it in isSpag boolean variable

       shawarma = (CheckBox) findViewById(R.id.shawarma_checkbox);
       boolean isShawarma = shawarma.isChecked(); // isChecked() gets the state of the bread checkbox and stores it in isShawarma boolean variable

       macaroni = (CheckBox) findViewById(R.id.macaroni_checkbox);
       boolean isMacaroni = macaroni.isChecked(); // isChecked() gets the state of the bread checkbox and stores it in isMacaroni boolean variable

       // Gives 2 points if spag and macaroni are checked as correct answers
       if(isSpag & isMacaroni & !isBread & !isPotato & !isShawarma)
       {
           Quiz1Activity.score++; // Increments score by 1
           Quiz1Activity.score++; // Increments score by 1

           Quiz1Activity.scoreMessage = "Score: " + Quiz1Activity.score; // stores the current score as a String
           displayScore(Quiz1Activity.scoreMessage); // displays the current score on the screen

           spag.setEnabled(false); // deactivates spag checkbox after clicking
           macaroni.setEnabled(false); // deactivates macaroni checkbox after clicking
           bread.setEnabled(false); // deactivates bread checkbox after spag and macaroni are checked
           potato.setEnabled(false); // deactivates potato checkbox after spag and macaroni are checked
           shawarma.setEnabled(false); // deactivates shawarma checkbox after spag and macaroni are checked

           // Shows a message when the correct answers are checked
           Toast.makeText(this, "Bravo! Correct answer.\nYou really love Pasta."
                   , Toast.LENGTH_LONG).show();
       } // ends if statement

       // Gives 1 point if one incorrect and one correct answer is checked
       if((isBread || isPotato || isShawarma) && (isSpag || isMacaroni))
       {
           Quiz1Activity.score++; // Increments score by 1

           Quiz1Activity.scoreMessage = "Score: " + Quiz1Activity.score; // stores the current score as a String
           displayScore(Quiz1Activity.scoreMessage); // displays the current score on the screen

           spag.setEnabled(false); // deactivates spag checkbox after clicking
           macaroni.setEnabled(false); // deactivates macaroni checkbox after clicking
           bread.setEnabled(false); // deactivates bread checkbox after spag and macaroni are checked
           potato.setEnabled(false); // deactivates potato checkbox after spag and macaroni are checked
           shawarma.setEnabled(false); // deactivates shawarma checkbox after spag and macaroni are checked

           // Shows a message when one correct and incorrect answer is checked
           Toast.makeText(this, "Mehn! You are almost correct.\nEat more Pasta."
                   , Toast.LENGTH_LONG).show();
       } // ends if

       // reduces points by 2 if 2 incorrect answers are checked
       if((isBread || isPotato) && (isShawarma || isBread) && (isShawarma || isPotato))
       {
           Quiz1Activity.scoreMessage = "Score: " + Quiz1Activity.score; // stores the current score as a String
           displayScore(Quiz1Activity.scoreMessage);

           spag.setEnabled(false);
           macaroni.setEnabled(false);
           bread.setEnabled(false);
           potato.setEnabled(false);
           shawarma.setEnabled(false);

           // Shows a message when the correct answer is chosen
           Toast.makeText(this, "Sorry! Wrong answer.\nStart eating Pasta. You will love it."
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
} // ends class Quiz7Activity
