package com.emelyantsev303;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    EditText text;
    Switch switch1;
    Switch switch2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        text = findViewById(R.id.mainEdit);
        switch1 = findViewById(R.id.switch1);
        switch2 = findViewById(R.id.switch2);

        String edit = getIntent().getStringExtra("Edit");
        text.setText(text.getText().toString() + "" + edit);

        boolean isChk1 = getIntent().getBooleanExtra("ch1", false);
        boolean isChk2 = getIntent().getBooleanExtra("ch2", false);
        switch1.setChecked(isChk1);
        switch2.setChecked(isChk2);
    }

    public void okDialog(View v) {
        String s = text.getText().toString();
        boolean sw1 = switch1.isChecked();
        boolean sw2 = switch2.isChecked();

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("backEdit", s);
        intent.putExtra("backSw1", sw1);
        intent.putExtra("backSw2", sw2);

        startActivity(intent);
    }

    public void cancelDialog(View v) {
        finish();
    }
}