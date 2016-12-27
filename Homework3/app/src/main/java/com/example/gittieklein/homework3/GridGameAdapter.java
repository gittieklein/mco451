package com.example.gittieklein.homework3;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;

/**
 * Created by Gittie Klein on 12/27/2016.
 */

public class GridGameAdapter extends RecyclerView.Adapter<GridGameAdapter.ViewHolder>
{
    private boolean[] mSquare;
    private Random mGenerator;
    private int mWinningNumber;

    public GridGameAdapter()
    {
        mSquare = new boolean[16];
        mGenerator = new Random();
        startGame();
    }

    private void startGame()
    {
        mWinningNumber = mGenerator.nextInt(16);
        mSquare[mWinningNumber] = true;
    }

    public void startNewGame()
    {
        mSquare[mWinningNumber] = false;
        startGame();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.rv_item, parent, false);
        return new ViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        holder.mButton.setText(Integer.toString(position));
    }

    @Override
    public int getItemCount() {
        return mSquare.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private final Button mButton;

        public ViewHolder (View itemView)
        {
            super(itemView);
            mButton = (Button) itemView.findViewById(R.id.button);
        }
    }

    public boolean checkIfWinner(int num) {
        return mSquare[num];
    }


}

