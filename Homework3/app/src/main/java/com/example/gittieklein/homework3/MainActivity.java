package com.example.gittieklein.homework3;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    GridGameAdapter mObjGridGameAdapter;
    View sbContainer = findViewById(R.id.activity_main);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpBoard();
        
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGame();
            }
        });
    }

    private void startGame()
    {
        mObjGridGameAdapter.startGame();
        Snackbar.make(sbContainer, "New Game", Snackbar.LENGTH_SHORT);
    }

    private void setUpBoard()
    {
        RecyclerView objRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        objRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager objLayoutManager = new GridLayoutManager(this,4);
        objLayoutManager.setAutoMeasureEnabled(true);

        mObjGridGameAdapter = new GridGameAdapter();

        objRecyclerView.setLayoutManager(objLayoutManager);
        objRecyclerView.setAdapter(mObjGridGameAdapter);
    }


    public void buttonClicked(View view) {
        Button currentButton = (Button) view;
        String msg;

        boolean winner = mObjGridGameAdapter.checkIfWinner(Integer.parseInt(currentButton.getText().toString()));
        if(winner)
            msg = "You Win! \n You clicked on " + currentButton.getText().toString();
        else
            msg = "You clicked on " + currentButton.getText().toString();

        Snackbar.make(sbContainer, msg, Snackbar.LENGTH_SHORT).show();

    }
}
