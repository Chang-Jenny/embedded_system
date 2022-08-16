package com.example.hw4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements RadioGroup.OnCheckedChangeListener,
                    CompoundButton.OnCheckedChangeListener {

    RadioGroup backgroundColor;
    RadioButton s1,s2,s3,s4,s5,s6,s7,s8;
    TextView txvColor,remind,txvOrder,display;
    View background;
    Button check;
    CheckBox c1,c2,c3,c4,c5,c6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //RadioButton設監聽
        backgroundColor = (RadioGroup) findViewById(R.id.backgroundColor);
        backgroundColor.setOnCheckedChangeListener(this);
        //背景顏色
        background = (View) findViewById(R.id.background);
        //選項文字顏色
        s1 = (RadioButton)findViewById(R.id.red); s2 = (RadioButton)findViewById(R.id.yellow);
        s3 = (RadioButton)findViewById(R.id.green); s4 = (RadioButton)findViewById(R.id.blue);
        s5 = (RadioButton)findViewById(R.id.purple); s6 = (RadioButton)findViewById(R.id.white);
        s7 = (RadioButton)findViewById(R.id.gray); s8 = (RadioButton)findViewById(R.id.black);


        //改背景顏色一起改字的顏色
        txvColor = (TextView) findViewById(R.id.txvColor);
        remind = (TextView) findViewById(R.id.remind);
        txvOrder = (TextView) findViewById(R.id.txvOrder);

        //點餐
        check = (Button) findViewById(R.id.btncheck);
        display = (TextView) findViewById(R.id.display);
        int[] chkid = {R.id.order1, R.id.order2, R.id.order3,
                            R.id.order4, R.id.order5,R.id.order6};
        for(int id: chkid){
            CheckBox checkid = (CheckBox) findViewById(id);
            checkid.setOnCheckedChangeListener(this);
        }
        c1 = (CheckBox)findViewById(R.id.order1); c2 = (CheckBox)findViewById(R.id.order2);
        c3 = (CheckBox)findViewById(R.id.order3); c4 = (CheckBox)findViewById(R.id.order4);
        c5 = (CheckBox)findViewById(R.id.order5); c6 = (CheckBox)findViewById(R.id.order6);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        chooseBGColor();
    }

    private void chooseBGColor() {
        switch(backgroundColor.getCheckedRadioButtonId()){
            case R.id.red:
                background.setBackgroundColor(Color.parseColor("#FF2D2D"));
                changeToWhite();
                break;
            case R.id.yellow:
                background.setBackgroundColor(Color.parseColor("#FFEB3B"));
                changeToBlack();
                break;
            case R.id.green:
                background.setBackgroundColor(Color.parseColor("#8BC34A"));
                changeToWhite();
                break;
            case R.id.blue:
                background.setBackgroundColor(Color.parseColor("#03A9F4"));
                changeToBlack();
                break;
            case R.id.purple:
                background.setBackgroundColor(Color.parseColor("#9C27B0"));
                changeToWhite();
                break;
            case R.id.white:
                background.setBackgroundColor(Color.WHITE);
                changeToBlack();
                break;
            case R.id.gray:
                background.setBackgroundColor(Color.parseColor("#BDB8B0"));
                changeToWhite();
                break;
            case R.id.black:
                background.setBackgroundColor(Color.parseColor("#000000"));
                changeToWhite();
                break;

        }
    }
    protected void changeToWhite(){
        txvColor.setTextColor(Color.WHITE);
        remind.setTextColor(Color.WHITE);
        txvOrder.setTextColor(Color.WHITE);
        display.setTextColor(Color.WHITE);
        s1.setTextColor(Color.WHITE); s2.setTextColor(Color.WHITE);
        s3.setTextColor(Color.WHITE); s4.setTextColor(Color.WHITE);
        s5.setTextColor(Color.WHITE); s6.setTextColor(Color.WHITE);
        s7.setTextColor(Color.WHITE); s8.setTextColor(Color.WHITE);
        c1.setTextColor(Color.WHITE); c2.setTextColor(Color.WHITE);
        c3.setTextColor(Color.WHITE); c4.setTextColor(Color.WHITE);
        c5.setTextColor(Color.WHITE); c6.setTextColor(Color.WHITE);

    }
    protected void changeToBlack(){
        txvColor.setTextColor(Color.BLACK);
        remind.setTextColor(Color.BLACK);
        txvOrder.setTextColor(Color.BLACK);
        display.setTextColor(Color.BLACK);
        s1.setTextColor(Color.BLACK); s2.setTextColor(Color.BLACK);
        s3.setTextColor(Color.BLACK); s4.setTextColor(Color.BLACK);
        s5.setTextColor(Color.BLACK); s6.setTextColor(Color.BLACK);
        s7.setTextColor(Color.BLACK); s8.setTextColor(Color.BLACK);
        c1.setTextColor(Color.BLACK); c2.setTextColor(Color.BLACK);
        c3.setTextColor(Color.BLACK); c4.setTextColor(Color.BLACK);
        c5.setTextColor(Color.BLACK); c6.setTextColor(Color.BLACK);
    }
    ArrayList<CompoundButton> choose = new ArrayList<>();//存放選取的餐點
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked)
            choose.add(buttonView);
        else
            choose.remove(buttonView);
    }

    public void takeOrder(View v){
        String message = "";
        for(CompoundButton order:choose)
            message+="\n"+order.getText();

        if(choose.size()==3)
            message="您的餐點為："+message+"\n"+"總共50元";
        if(choose.size()==4)
            message="您的餐點為："+message+"\n"+"總共60元";
        if(choose.size()<3)
            message = "最少要選三樣菜!";
        if(choose.size()>4)
            message = "最多只能選四樣菜!";



        display.setText(message);
    }
}