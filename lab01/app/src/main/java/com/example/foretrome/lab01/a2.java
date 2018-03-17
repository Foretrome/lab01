package com.example.foretrome.lab01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class a2 extends AppCompatActivity {

    String hello = "Hello, ";
    String from = "From A3: ";
    TextView tv = null;
    TextView tv2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2);

        tv2 = (TextView) findViewById(R.id.t3);
        displayHello();
    }

    public void gotoA3(View view) {
        Intent startA3 = new Intent(this, a3.class);
        startActivityForResult(startA3, 1);
    }

    public void displayHello() {
        tv = (TextView) findViewById(R.id.t2);
        Intent textToDisplay = getIntent();
        String greetSender = hello + textToDisplay.getStringExtra("Text");
        tv.setText(greetSender);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            String recievedMessage = from + data.getStringExtra("Text2");
            tv2.setText(recievedMessage);
        }
    }
}
