package com.example.hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mytxv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mytxv = (TextView) findViewById(R.id.txv);
    }
    public void input_0(View v) { mytxv.setText("0"); }
    public void input_1(View v){
        mytxv.setText("1");
    }
    public void input_2(View v) { mytxv.setText("2"); }
    public void input_3(View v) { mytxv.setText("3"); }
    public void input_4(View v) { mytxv.setText("4"); }
    public void input_5(View v) { mytxv.setText("5"); }
    public void input_6(View v) { mytxv.setText("6"); }
    public void input_7(View v) { mytxv.setText("7"); }
    public void input_8(View v) { mytxv.setText("8"); }
    public void input_9(View v) { mytxv.setText("9"); }
    public void input_10(View v) { mytxv.setText(""); }
    public void input_11(View v) { mytxv.setText("CHANG,CHEN-CHEN"); }

}