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
        Button btn_higher = findViewById(R.id.btn_higher);
        Button btn_lower = findViewById(R.id.btn_lower);
        final ImageView comp = findViewById(R.id.comp);
        //-------------------------------------------------------------------

        final int [] diceArray = {R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6};

        final int[] diceArrayLoser = {R.drawable.dice1_loser,
                R.drawable.dice2_loser,
                R.drawable.dice3_loser,
                R.drawable.dice4_loser,
                R.drawable.dice5_loser,
                R.drawable.dice6_loser};

        final int[] diceArrayWinner = {R.drawable.dice1_winner,
                R.drawable.dice2_winner,
                R.drawable.dice3_winner,
                R.drawable.dice4_winner,
                R.drawable.dice5_winner,
                R.drawable.dice6_winner};
        // we want to pick one of the dices in array randomly and replace it with left and right
        // image view inside your app!
        // Click listener look for an event on your view components.
        btn_higher.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               comp.setImageResource(R.drawable.opponent);
               Random rand = new Random();
               int opponentsDie = rand.nextInt(6);
               int yourDie = rand.nextInt(6);
               if(opponentsDie > yourDie){
                   leftDie.setImageResource(diceArrayWinner[opponentsDie]);
                   rightDie.setImageResource(diceArrayLoser[yourDie]);
               }else if(opponentsDie < yourDie){
                   leftDie.setImageResource(diceArrayLoser[opponentsDie]);
                   rightDie.setImageResource(diceArrayWinner[yourDie]);
                   comp.setImageResource(R.drawable.loser);
               }else{
                   leftDie.setImageResource(diceArray[opponentsDie]);
                   rightDie.setImageResource(diceArray[yourDie]);
               }

               if(opponentsDie == yourDie){
                   openDialog("tied", opponentsDie, yourDie, "higher");
               }else if(yourDie > opponentsDie){
                   openDialog("win", opponentsDie, yourDie, "higher");
               }else {
                   openDialog("lose", opponentsDie, yourDie, "higher");
               }

           }
       });

        btn_lower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comp.setImageResource(R.drawable.opponent);
                Random rand = new Random();
                int opponentsDie = rand.nextInt(6);
                int yourDie = rand.nextInt(6);

                for(int i = 0; i<20; i++){
                    int x = rand.nextInt(6);
                    int y = rand.nextInt(6);
                    leftDie.setImageResource(diceArray[x]);
                    rightDie.setImageResource(diceArray[y]);
                }

                if(opponentsDie < yourDie){
                    leftDie.setImageResource(diceArrayWinner[opponentsDie]);
                    rightDie.setImageResource(diceArrayLoser[yourDie]);
                }else if(opponentsDie > yourDie){
                    leftDie.setImageResource(diceArrayLoser[opponentsDie]);
                    rightDie.setImageResource(diceArrayWinner[yourDie]);
                    comp.setImageResource(R.drawable.loser);
                }else{
                    leftDie.setImageResource(diceArray[opponentsDie]);
                    rightDie.setImageResource(diceArray[yourDie]);
                }
                if(opponentsDie == yourDie){
                    openDialog("tied", opponentsDie, yourDie, "lower");
                }else if(yourDie < opponentsDie){
                    openDialog("win", opponentsDie, yourDie, "lower");
                }else {
                    openDialog("lose", opponentsDie, yourDie, "lower");
                }
            }
        });
    }

    public void openDialog(String result, int opponentsDie, int yourDie, String mode){
        ExDialog dialog = new ExDialog(result, opponentsDie, yourDie, mode);
        dialog.show(getSupportFragmentManager(), "Example Dialog!");
    }


}
