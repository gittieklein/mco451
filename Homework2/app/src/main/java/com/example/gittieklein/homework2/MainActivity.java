package com.example.gittieklein.homework2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Random mGenerator;
    private int mWinningNumber;
    private View mSB_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mGenerator = new Random();
        mSB_container = findViewById(R.id.cl_main);
        startGame();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGame();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void startGame(){
        mWinningNumber = mGenerator.nextInt(3) + 1;
        Snackbar.make (mSB_container, R.string.welcome_new_game, Snackbar.LENGTH_SHORT).show ();
    }

    public void checkIfWinner(View view) {
        Button button = (Button) view;
        int num = Integer.parseInt(button.getText().toString());
        if(num == mWinningNumber)
        {
            Snackbar.make (mSB_container, R.string.you_win, Snackbar.LENGTH_SHORT).show ();
        }
        else
        {
            Snackbar.make (mSB_container, R.string.you_lose, Snackbar.LENGTH_SHORT).show ();
        }
    }
}
