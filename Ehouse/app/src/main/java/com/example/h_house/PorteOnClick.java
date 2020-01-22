package com.example.h_house;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PorteOnClick extends AppCompatActivity {

    TextView res1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SmsManager.getDefault().sendTextMessage("+33766189022",null,"\n{garage}",null,null);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_porte_on_click);

        Button retourMENUE = findViewById(R.id.retourMENUE);
        retourMENUE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PorteOnClick.this, MenuOnClick.class));
            }
        });

        res1 = findViewById(R.id.textView3);
        Button ouvrir = findViewById(R.id.ouvrir);
        ouvrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager.getDefault().sendTextMessage("+33766189022",null,"\n{garage-ouvrir}",null,null);
                res1.setText("Porte garage ouverte");
            }
        });

        Button fermer = findViewById(R.id.fermer);
        fermer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager.getDefault().sendTextMessage("+33766189022",null,"\n{garage-fermer}",null,null);
                res1.setText("Porte garage fermer");
            }
        });


    }
}

