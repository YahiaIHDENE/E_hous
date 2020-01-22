package com.example.h_house;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.h_house.notification.CHANNEL_1_ID;

public class LedOnClick extends AppCompatActivity {

    TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SmsManager.getDefault().sendTextMessage("+33766189022",null,"\n{led}",null,null);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_led_on_click);

        Button retourMENUE = findViewById(R.id.retourMENUE);
        retourMENUE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LedOnClick.this, MenuOnClick.class));
            }
        });


        res = findViewById(R.id.textView3);
        Button ONcuisine = findViewById(R.id.ONcuisine);
        ONcuisine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager.getDefault().sendTextMessage("+33766189022",null,"\n{led-on-cuisine}",null,null);
                res.setText("led-on-cuisine");
            }
        });

        Button OFFcuisine = findViewById(R.id.OFFcuisine);
        OFFcuisine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager.getDefault().sendTextMessage("+33766189022",null,"\n{led-off-cuisine}",null,null);
                res.setText("led-off-cuisine");
            }
        });

        Button ONsallon = findViewById(R.id.ONsallon);
        ONsallon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager.getDefault().sendTextMessage("+33766189022",null,"\n{led-on-salon}",null,null);
                res.setText("led-on-salon");
            }
        });

        Button OFFsallon = findViewById(R.id.OFFsallon);
        OFFsallon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager.getDefault().sendTextMessage("+33766189022",null,"\n{led-off-salon}",null,null);
                res.setText("led-off-salon");
            }
        });

        Button ONgarage = findViewById(R.id.ONgarage);
        ONgarage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager.getDefault().sendTextMessage("+33766189022",null,"\n{led-on-garage}",null,null);
                res.setText("led-on-garage");
            }
        });

        Button OFFgarage = findViewById(R.id.OFFgarage);
        OFFgarage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager.getDefault().sendTextMessage("+33766189022",null,"\n{led-off-garage}",null,null);
                res.setText("led-off-garage");
            }
        });



    }


}
