package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivityFail extends AppCompatActivity {
    private TextView TvScoreFA;

    private EditText etSmsPhoneNumber;
    private Button btnSendSms;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fail);
        TvScoreFA = (TextView) findViewById(R.id.TvScoreFA);
        double score = getIntent().getDoubleExtra("score", 0.0);
        TvScoreFA.setText("YOU FAILED WITH A SCORE EQUALS TO : " + score + " BETTER LUCK NEXT TIME");

        etSmsPhoneNumber = (EditText) findViewById(R.id.EtSmsPhoneNumber);
        btnSendSms = (Button) findViewById(R.id.BtnSendSmsFA);

        btnSendSms.setOnClickListener(v -> {
            Uri uri = Uri.parse("smsto:" + etSmsPhoneNumber.getText().toString());
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.putExtra("sms_body", String.format("Your score is %.2f", score));
            startActivity(intent);
        });
    }
}