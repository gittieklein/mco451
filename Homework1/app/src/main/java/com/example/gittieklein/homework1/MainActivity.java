package com.example.gittieklein.homework1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void getNumber(View view) {
        EditText et = (EditText) findViewById(R.id.editText);
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(et.getText().toString());
    }

}
