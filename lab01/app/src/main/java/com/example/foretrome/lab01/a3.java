package com.example.foretrome.lab01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class a3 extends AppCompatActivity {

    EditText textToPass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a3);

        textToPass2 = (EditText) findViewById(R.id.t4);
    }

    public void gotoA2(View view) {
        //Intent startA2 = new Intent(this, a2.class);
        //startActivity(startA2);
        Intent i = new Intent();
        i.putExtra("Text2", textToPass2.getText().toString());
        setResult(RESULT_OK, i);
        finish();
    }
/*
    public void returnToA2(View view) {
        Intent i = new Intent();
        i.putExtra("Text2", textToPass2.getText().toString());
        setResult(RESULT_OK, i);
        finish();
    }*/
}
