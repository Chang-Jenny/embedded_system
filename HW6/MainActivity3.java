package com.example.hw6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    Button btnPage3;
    TextView showPage3;
    String path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main3);
        btnPage3 = (Button)findViewById(R.id.btnPage3);
        showPage3 = (TextView)findViewById(R.id.showPage3);

        Intent it = getIntent();
        String p=it.getStringExtra("路徑");
        p += "\u279E"+"3";
        showPage3.setText(p);
        path=p;
    }
    public void goToAct1(View v){
        Intent it3 = new Intent(this, MainActivity.class);
        it3.putExtra("路徑",path);
        startActivityForResult(it3,3);
    }
    public void back(View v){
        Intent it3 = new Intent();
        path+="\u279E"+"2";
        it3.putExtra("路徑",path);
        setResult(RESULT_OK,it3);
        finish();
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent it) {
        super.onActivityResult(requestCode, resultCode, it);
        if(resultCode==RESULT_OK){
            path=it.getStringExtra("路徑");
            showPage3.setText(path);
        }
    }
}