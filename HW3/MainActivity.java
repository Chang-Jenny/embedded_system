package com.example.hw3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
                implements View.OnClickListener,
                View.OnTouchListener{

    View myLayout;
    Button btn;
    TextView txv;
    int counter=0;
    float x1=0;
    float x2=0;
    float y1=0;
    float y2=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        txv = (TextView) findViewById(R.id.txv);
        myLayout = (View) findViewById(R.id.myLayout);

        btn.setOnClickListener(this);
        myLayout.setOnTouchListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn){
            counter=0;
            txv.setText(""+counter);
            Toast.makeText(this,"Zerooooooo!",Toast.LENGTH_SHORT).show();
        } else{
            txv.setText("Error!!!");
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            x1 = event.getX();
            y1 = event.getY();
        }
        if(event.getAction() == MotionEvent.ACTION_UP){
            x2 = event.getX();
            y2 = event.getY();
            if(x1-x2>50){
                counter-=1;
                txv.setText(""+counter);
            } else if(x2-x1>50){
                counter+=1;
                txv.setText(""+counter);
            }
            if(y1-y2>50){
                counter+=2;
                txv.setText(""+counter);
            } else if(y2-y1>50){
                counter-=2;
                txv.setText(""+counter);
            }
        }
        return true;
    }
}