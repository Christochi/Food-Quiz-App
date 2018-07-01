package com.example.android.foodquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class lastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        printScore("Thank you for trying my app.I hope you liked it." +
                "\n\n                  Total " + Quiz1Activity.scoreMessage + " out of 10");
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

    // This method prints the score on a new activity
    public void printScore(String message)
    {
        TextView textView = (TextView) findViewById(R.id.score_details);
        textView.setText(message);
    }
}
