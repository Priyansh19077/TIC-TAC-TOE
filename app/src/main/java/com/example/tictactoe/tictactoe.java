package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class tictactoe extends AppCompatActivity {
    int counter1;
    GameState gm;
    Button b1;
    TextView winner;
    public void insert(View view)
    {
        ImageView counter=(ImageView)view;
        Log.i("Tap",counter.getTag().toString());
        int x=Integer.parseInt(counter.getTag().toString());
        if(gm.arr[x]==10)
        {
            Toast.makeText(getApplicationContext(),"GAME HAS ENDED, PRESS PLAY AGAIN",Toast.LENGTH_SHORT).show();
            return;
        }
        else if(gm.arr[x]!=2)
        {
            Toast.makeText(getApplicationContext(),"PLEASE TAP ON AN EMPTY BLOCK",Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            winner=findViewById(R.id.txt_winner);
            winner.setVisibility(View.INVISIBLE);
        }
        if(counter1==1) {
            counter1^=1;
            counter.setImageResource(R.drawable.cross1);
            gm.set_value(x,1);
        }
        else {
            counter1^=1;
            counter.setImageResource(R.drawable.zero);
            gm.set_value(x,0);
        }
        counter.setTranslationY(-2000);
        counter.animate().translationYBy(2000).setDuration(100);
        if(gm.check_if_cross_wins())
        {
            b1=findViewById(R.id.btn_play_again);
            b1.setVisibility(View.VISIBLE);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    return_to_initial_state();
                }
            });
            winner=findViewById(R.id.txt_winner);
            winner.setVisibility(View.VISIBLE);
            winner.setText("CROSS HAS WON");
            for(int i=0;i<9;i++)
                gm.arr[i]=10;
        }
        else if(gm.check_if_zero_wins())
        {
            b1=findViewById(R.id.btn_play_again);
            b1.setVisibility(View.VISIBLE);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    return_to_initial_state();
                }
            });
            winner=findViewById(R.id.txt_winner);
            winner.setText("ZERO HAS WON");
            winner.setVisibility(View.VISIBLE);
            for(int i=0;i<9;i++)
                gm.arr[i]=10;
        }
        else if(gm.check_if_all_filed())
        {
            b1=findViewById(R.id.btn_play_again);
            b1.setVisibility(View.VISIBLE);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    return_to_initial_state();
                }
            });
            winner=findViewById(R.id.txt_winner);
            winner.setText("IT IS A DRAW");
            winner.setVisibility(View.VISIBLE);
            for(int i=0;i<9;i++)
                gm.arr[i]=10;
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictactoe2);
        counter1=1;
        gm=new GameState();
    }
    public void return_to_initial_state()
    {
        winner.setText("TAP ON ANY BLOCK TO START");
        b1.setVisibility(View.INVISIBLE);
        androidx.gridlayout.widget.GridLayout gl= (androidx.gridlayout.widget.GridLayout) findViewById(R.id.gridLayout);
        for(int i=0;i<9;i++)
            gm.arr[i]=2;
        for(int i=0;i<gl.getChildCount();i++)
        {
          ImageView i1=(ImageView) gl.getChildAt(i);
          i1.setImageDrawable(null);
        }
        counter1=1;
    }
}