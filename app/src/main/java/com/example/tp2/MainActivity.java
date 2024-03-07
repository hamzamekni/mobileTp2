package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etWeb;
    private EditText etMobile;
    private EditText etDotNet;
    private Button btnCalcMoy;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWeb = (EditText) findViewById(R.id.note1);
        etMobile = (EditText) findViewById(R.id.note2);
        etDotNet = (EditText) findViewById(R.id.note3);
        btnCalcMoy = (Button) findViewById(R.id.button);

        btnCalcMoy.setOnClickListener(v -> {
            if (etWeb.getText().toString().isEmpty() || etMobile.getText().toString().isEmpty() || etDotNet.getText().toString().isEmpty()) {
                Toast.makeText(getBaseContext(),"field is empty", Toast.LENGTH_SHORT).show();
                return;
            }
            double webParsed = Double.parseDouble(etWeb.getText().toString());
            double mobileParsed = Double.parseDouble(etMobile.getText().toString());
            double dotNetParsed = Double.parseDouble(etDotNet.getText().toString());

            double score = calcul(webParsed, mobileParsed, dotNetParsed);

            if (score >= 10) {
                Intent intent = new Intent(this, MainActivitySuccess.class);
                intent.putExtra("score", score);
                startActivity(intent);
            } else {
                Intent intent = new Intent(MainActivity.this, MainActivityFail.class);
                intent.putExtra("score", score);
                startActivity(intent);
            }

        });
    }
    public double calcul(double web, double mobile, double dotNet){
        return (((web *3) + (mobile*3) + (dotNet*2)) / 8);
    }
}