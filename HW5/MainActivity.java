package com.example.hw5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
                    implements View.OnClickListener,
                                AdapterView.OnItemSelectedListener,
                                TextWatcher {
    Spinner selectSports;
    double[] energyRate={3.1, 4.4, 13.2, 9.7, 5.1, 3.7};
    EditText inputWeight, inputHour;
    TextView outputRate, outputTotal, remind;
    Button calc;
    ImageButton check;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //spinner即時加監聽
        selectSports = (Spinner) findViewById(R.id.selectSports);
        selectSports.setOnItemSelectedListener(this);
        //EditText監聽
        inputWeight = (EditText) findViewById(R.id.inputWeight);
        inputWeight.addTextChangedListener(this);
        inputHour = (EditText) findViewById(R.id.inputHour);
        inputHour.addTextChangedListener(this);

        //button監聽
        calc = (Button) findViewById(R.id.calc);
        calc.setOnClickListener(this);

        check = (ImageButton) findViewById(R.id.imgbtn);
        check.setOnClickListener(this);

        outputRate = (TextView) findViewById(R.id.outputRate);
        outputTotal = (TextView) findViewById(R.id.outputTotal);

        remind = (TextView) findViewById(R.id.remind);
    }

    protected void calculate(){
        String weight = inputWeight.getText().toString();
        String hour = inputHour.getText().toString();

        if(weight.isEmpty() || weight.equals(".")){
            remind.setText("請輸入體重");
            //Toast.makeText(this, "請輸入體重及運動時間!", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(hour.isEmpty() || hour.equals(".")){
            remind.setText("請輸入運動時間");
            return;
        }
        else{
            remind.setText(" ");
        }

        int pos = selectSports.getSelectedItemPosition();
        long kcal = Math.round(energyRate[pos]*
                Double.parseDouble(weight)*Double.parseDouble(hour));
        //outputTotal.setText(String.valueOf(kcal));
        outputTotal.setText(String.format(" %d 仟卡", kcal));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        outputRate.setText(String.valueOf(energyRate[position]));
        calculate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) { }

    @Override
    public void onClick(View v) {
        calculate();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) { }

    @Override
    public void afterTextChanged(Editable s) {
        calculate();
    }
}