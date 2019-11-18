package com.example.android.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.calculator.R;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText first_input;
    EditText second_input;

    Button button1;
    Button button2;
    Button button3;
    Button button4;

    TextView result;

    String oper ="";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first_input = (EditText) findViewById(R.id.first_input);
        second_input = (EditText) findViewById(R.id.second_input);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);

        result = (TextView) findViewById(R.id.result);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        float num1 = 0;
        float num2 = 0;
        float result1 = 0;

        if (TextUtils.isEmpty(first_input.getText().toString())
                || TextUtils.isEmpty(second_input.getText().toString())) {
            return;
        }

        num1 = Float.parseFloat(first_input.getText().toString());
        num2 = Float.parseFloat(second_input.getText().toString());

        switch (v.getId()) {
            case R.id.button1:
                oper = "+";
                result1 = num1 + num2;
                break;
            case R.id.button2:
                oper = "-";
                result1 = num1 - num2;
                break;
            case R.id.button3:
                oper = "*";
                result1 = num1 * num2;
                break;
            case R.id.button4:
                oper = "/";
                result1 = num1 / num2;
                break;
            default:
                break;
        }
        result.setText(num1 + " " + oper + " " + num2 + " = " + result1);
    }
}