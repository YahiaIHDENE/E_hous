package com.example.h_house;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FumeeOnClick extends AppCompatActivity {

    TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fumee_on_click);


        Button retourMENUE = findViewById(R.id.retourMENUE);
            retourMENUE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FumeeOnClick.this, MenuOnClick.class));
            }
        });

        res = findViewById(R.id.textView3);
        Button ONfumee = findViewById(R.id.ONfumee);
            ONfumee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager.getDefault().sendTextMessage("+33766189022",null,"\n{ONfumee}",null,null);
                res.setText("capteur allumé");
            }
        });

        Button OFFfumee = findViewById(R.id.OFFfumee);
            OFFfumee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager.getDefault().sendTextMessage("+33766189022",null,"\n{OFFfumee}",null,null);
                res.setText("capteur eteint");
            }
        });

    }
}