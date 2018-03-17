package com.example.foretrome.lab01;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.Serializable;

public class a1 extends AppCompatActivity {

    EditText textToPass;
    String[] items = new String[]{"A1", "A2", "A3"};
    ArrayAdapter<String> adapter;
    Spinner s;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1);

        textToPass = findViewById(R.id.t1);
        s = findViewById(R.id.s1);
        dropDownMenu();
        SharedPreferences sharedPref = getSharedPreferences("pref", MODE_PRIVATE);
        int spinnerValue = sharedPref.getInt("userChoice", i);
        if (spinnerValue != -1) {
            s.setSelection(spinnerValue);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //outState.putInt("s1", s.getSelectedItemPosition());
        int userChoice = s.getSelectedItemPosition();
        SharedPreferences sharedPref = getSharedPreferences("pref", 0);
        SharedPreferences.Editor prefEditor = sharedPref.edit();
        prefEditor.putInt("userChoice", userChoice);
        prefEditor.apply();
    }

    public void gotoA2(View view) {
        Intent startA2 = new Intent(this, a2.class);
        startA2.putExtra("Text", textToPass.getText().toString());
        startActivity(startA2);
    }

    public void dropDownMenu() {
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        s.setAdapter(adapter);
    }
}
