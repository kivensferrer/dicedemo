package com.example.dicedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.util.Log;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // we have two images left dice and right dice
        // link the code to those two image view inside your layout.....(activity main)
        final ImageView leftDie = findViewById(R.id.Left_dice);
        final ImageView rightDie = findViewById(R.id.right_dice);
        Button rollButton = findViewById(R.id.roll_button);
        //-------------------------------------------------------------------

        final int [] diceArray = {R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6};
        // we want to pick one of the dices in array randomly and replace it with left and right
        // image view inside your app!
        // Click listener look for an event on your view components.
       rollButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Random rand = new Random();
               int randLeftDie = rand.nextInt(6);
               int randRightDie = rand.nextInt(6);
               Log.d("left die",String.valueOf(randLeftDie));
               Log.d("right die",String.valueOf(randRightDie));

                leftDie.setImageResource(diceArray[randLeftDie]);
               rightDie.setImageResource(diceArray[randRightDie]);
               // we need to create a random integer for picking the dices randomly!


           }
       });
    }



}
