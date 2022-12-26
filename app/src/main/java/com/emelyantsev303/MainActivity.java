package com.emelyantsev303;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
//Емельянцев Никита, 303

    EditText text;
    CheckBox check1;
    CheckBox check2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.mainEdit);
        check1 = findViewById(R.id.checkBox1);
        check2 = findViewById(R.id.checkBox2);

        String backEdit = getIntent().getStringExtra("backEdit");
        boolean isChk1 = getIntent().getBooleanExtra("backSw1", false);
        boolean isChk2 = getIntent().getBooleanExtra("backSw2", false);

        check1.setChecked(isChk1);
        check2.setChecked(isChk2);
        text.setText(text.getText().toString() + "" + backEdit);
    }

    public void openDialog(View v) {
        String s = text.getText().toString();
        boolean ch1 = check1.isChecked();
        boolean ch2 = check2.isChecked();

        Intent i = new Intent(this, SecondActivity.class);
        i.putExtra("Edit", s);
        i.putExtra("ch1", ch1);
        i.putExtra("ch2", ch2);
        startActivity(i);
    }

    public void exitDialog(View v) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.exit, null);
        dialogBuilder.setView(dialogView);
        AlertDialog exit = dialogBuilder.create();
        exit.show();

        Button yesBtn = dialogView.findViewById(R.id.yesExit);
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });

        Button noBtn = dialogView.findViewById(R.id.noExit);
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exit.cancel();
            }
        });
    }
}