package com.example.hw6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    Button btnPage2;
    TextView showPage2;
    String path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        btnPage2 = (Button)findViewById(R.id.btnPage2);
        showPage2 = (TextView)findViewById(R.id.showPage2);

        Intent it = getIntent();
        String p=it.getStringExtra("路徑");
        p += "\u279E"+"2";
        showPage2.setText(p);
        path=p;
    }
    public void goToAct3(View v){
        Intent it2 = new Intent(this, MainActivity3.class);
        it2.putExtra("路徑",path);
        startActivityForResult(it2,2);
    }
    public void back(View v){
        Intent it2 = new Intent();
        path+="\u279E"+"1";
        it2.putExtra("路徑",path);
        setResult(RESULT_OK,it2);
        finish();
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent it) {
        super.onActivityResult(requestCode, resultCode, it);
        if(resultCode==RESULT_OK){
            path=it.getStringExtra("路徑");
            showPage2.setText(path);
        }
    }
}