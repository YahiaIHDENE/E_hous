package com.example.h_house;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.h_house.notification.CHANNEL_2_ID;

public class BruitOnClick extends AppCompatActivity {


    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SmsManager.getDefault().sendTextMessage("+33766189022",null,"\n{bruit}",null,null);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bruit_on_click);

        Button retourMENUE = findViewById(R.id.retourMENUE);
        retourMENUE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BruitOnClick.this, MenuOnClick.class));
            }
        });

        res = findViewById(R.id.textView3);
        Button ONbruit = findViewById(R.id.ONbruit);
        ONbruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.ONbruit).setBackgroundColor(Color.BLUE);
                SmsManager.getDefault().sendTextMessage("+33766189022",null,"\n{ONbruit}",null,null);
                res.setText("capteur allumé");
            }
        });

        Button OFFbruit = findViewById(R.id.OFFbruit);
        OFFbruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager.getDefault().sendTextMessage("+33766189022",null,"\n{OFFbruit}",null,null);
                res.setText("capteur éteint");
            }
        });


    }
/*
    public void messageReceived(String num, String message) {

            if(message.equals("etatbruitON"))
            {
                Toast.makeText(this,"color green ON",Toast.LENGTH_LONG).show();

                findViewById(R.id.ONbruit).setBackgroundColor(Color.GREEN);
                findViewById(R.id.OFFbruit).setBackgroundColor(Color.WHITE);

            }
            if(message.equals("etatbruitOFF"))
            {
                Toast.makeText(this,"color green OFF",Toast.LENGTH_LONG).show();

                findViewById(R.id.OFFbruit).setBackgroundColor(Color.GREEN);
                findViewById(R.id.ONbruit).setBackgroundColor(Color.WHITE);

            }

            if(num.equals("bruitON")){

                NotificationManagerCompat notificationManager;

                notificationManager = NotificationManagerCompat.from(this);

                Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                        .setSmallIcon(R.drawable.ic_message)
                        .setContentTitle("Alerte Presence")
                        .setContentText("Présence detctée dans la maison")
                        .setVibrate(new long[]{0, 250, 100, 250})
                        .setSound(RingtoneManager.getActualDefaultRingtoneUri(this, R.raw.notifsound))
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setCategory(NotificationCompat.CATEGORY_ALARM)
                        .build();

                notificationManager.notify(1, notification);

            }


    }

 */



}