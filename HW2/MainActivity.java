package com.example.hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.LinearLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView lastName, firstName, phone, outcome;
    LinearLayout background, L1, L2, L3;
    Button btn;
    int red, green, blue, Bred, Bgreen, Bblue;
    String LN, FN, PH;
    boolean Lcheck=false,Fcheck=false,Pcheck=false; //確認是否有輸入值
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lastName = (TextView) findViewById(R.id.lastName);
        firstName = (TextView) findViewById(R.id.firstName);
        phone = (TextView) findViewById(R.id.phone);
        outcome = (TextView) findViewById(R.id.outcome); //印出輸入結果
        background = (LinearLayout) findViewById(R.id.background);
        L1 = (LinearLayout) findViewById(R.id.L1);
        L2 = (LinearLayout) findViewById(R.id.L2);
        L3 = (LinearLayout) findViewById(R.id.L3);
        btn = (Button) findViewById(R.id.btn);

        Random colorX = new Random();
        red = colorX.nextInt(256);//0~255
        green = colorX.nextInt(256);
        blue = colorX.nextInt(256);

        Bred = colorX.nextInt(256);
        Bgreen = colorX.nextInt(256);
        Bblue = colorX.nextInt(256);
        background.setBackgroundColor(Color.rgb(red, green, blue)); //背景隨機顏色
        btn.setBackgroundColor(Color.rgb(Bred, Bgreen, Bblue)); //按鈕隨機顏色
    }


    public void checkColor(View v){
        LN = lastName.getText().toString();
        FN = firstName.getText().toString();
        PH = phone.getText().toString(); //取得欄位的輸入值
        outcome.setText("姓名："+ LN + FN + "\n"+ "電話："+ PH);
        //依序判斷欄位是否有輸入值
        //欄位皆有輸入值則以黑色字顯示於下方Textview，有任一欄位為空則以紅色字顯示
        //若皆有輸入值則清空原先輸入欄位，讓使用者能輸入下一數值
        if(LN!=null && LN.equals("")){ //空欄位
            outcome.setTextColor(Color.rgb(255,0,0));
            L1.setBackgroundColor(Color.rgb(255,0,0));
            Lcheck=false;
        } else if(LN!=null && !LN.equals("")){ //此欄位非空
            outcome.setTextColor(Color.rgb(0,0,0));
            L1.setBackgroundColor(Color.rgb(red, green, blue));
            Lcheck=true;
        }

        if(FN!=null && FN.equals("")){
            outcome.setTextColor(Color.rgb(255,0,0));
            L2.setBackgroundColor(Color.rgb(255,0,0));
            Fcheck=false;
        } else if(FN!=null && !FN.equals("")){
            outcome.setTextColor(Color.rgb(0,0,0));
            L2.setBackgroundColor(Color.rgb(red, green, blue));
            Fcheck=true;
        }

        if(PH!=null && PH.equals("")){
            outcome.setTextColor(Color.rgb(255,0,0));
            L3.setBackgroundColor(Color.rgb(255,0,0));
            Pcheck=false;
        } else if(PH!=null && !PH.equals("")){
            outcome.setTextColor(Color.rgb(0,0,0));
            L3.setBackgroundColor(Color.rgb(red, green, blue));
            Pcheck=true;
        }

        if(Lcheck&&Fcheck&&Pcheck){
            lastName.setText("");
            firstName.setText("");
            phone.setText("");
        }

    }
}