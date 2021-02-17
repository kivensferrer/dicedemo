package com.example.dicedemo;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class ExDialog extends AppCompatDialogFragment {
    private String result;
    private String mode;
    private String displayText;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Result for " + mode + " game mode").setMessage(result).setPositiveButton(displayText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return builder.create();
    }

    public ExDialog(String result, int opponentsDie, int yourDie, String mode) {
        if(result == "tied"){
            this.result = "It's a tie at " + (opponentsDie+1) + "!";
            displayText = "Try again!";
        }else if(result == "win"){
            this.result = "You: "+ (yourDie+1) + "\nOpponent: " + (opponentsDie+1) + "\n\nYOU WIN!";
            displayText = "Try my luck again!";
        }else{
            this.result = "You: "+ (yourDie+1) + "\nOpponent: " + (opponentsDie+1) + "\n\nYOU LOSE!";
            displayText = "Try again!\n(Fingers Crossed)";
        }

        this.mode = mode;
    }
}
