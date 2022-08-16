package com.example.hw6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnPage1;
    TextView showPage1;
    String path="path："+"\n"+"1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        btnPage1 = (Button)findViewById(R.id.btnPage1);
        showPage1 = (TextView)findViewById(R.id.showPage1);

        Intent it = getIntent();
        String p=it.getStringExtra("路徑");
        if(p!=null){
            p += "\u279E"+"1";
            showPage1.setText(p);
            path=p;
        }
        else{
            showPage1.setText(path);
        }
    }
    public void goToAct2(View v){
        Intent it = new Intent(this,MainActivity2.class);
        it.putExtra("路徑",path);
        startActivityForResult(it,1);
    }
    public void back(View v){
        Intent it1 = new Intent();
        path+="\u279E"+"3";
        it1.putExtra("路徑",path);
        setResult(RESULT_OK,it1);
        finish();
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent it) {
        super.onActivityResult(requestCode, resultCode, it);
        if(resultCode==RESULT_OK){
            path=it.getStringExtra("路徑");
            showPage1.setText(path);
        }
    }
}