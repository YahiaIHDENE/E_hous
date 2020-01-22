
package com.example.h_house;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Context;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.Toast;

import static com.example.h_house.notification.CHANNEL_1_ID;
import static com.example.h_house.notification.CHANNEL_2_ID;

public class temperature extends AppCompatActivity implements MessageListener {

    TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        ReceiveSMS.bindListener(this);

        Button retourMENUE = findViewById(R.id.retourMENUE);
        retourMENUE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(temperature.this, MenuOnClick.class));
            }
        });

        res = findViewById(R.id.textView3);
        Button ONtemp = findViewById(R.id.ONtemp);
        ONtemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager.getDefault().sendTextMessage("+33766189022",null,"\n{ONtemp}",null,null);
                res.setText("capteur temperature activée");
            }
        });

        Button OFFtemp = findViewById(R.id.OFFtemp);
        OFFtemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager.getDefault().sendTextMessage("+33766189022",null,"\n{OFFtemp}",null,null);
                res.setText("capteur temperature desactivée");
            }
        });



     SmsManager.getDefault().sendTextMessage("+33766189022",null,"\n{temperature}",null,null);


    }
    public void messageReceived(String num, String message) {



         //Toast.makeText(this, "New Message Received: " + message, Toast.LENGTH_SHORT).show();
            if(num.equals("+33766189022")){
                String type;
                String valeur;
                String etat;
                type = message.substring(message.indexOf("{")+1,message.indexOf("="));
                valeur= message.substring(message.indexOf("=")+1,message.indexOf("#"));
                etat =message.substring(message.indexOf("#")+1,message.indexOf("}"));
                if(type.equals("temperature")) {
                    TextView textView = (TextView) findViewById(R.id.textView);
                    textView.setText("Température : " + valeur + " °C");
                    if(etat.equals("1")) {
                        findViewById(R.id.ONtemp).setBackgroundColor(Color.GREEN);
                        findViewById(R.id.OFFtemp).setBackgroundColor(Color.WHITE);


                        if (Integer.parseInt(valeur) >= 30) {
                            NotificationManagerCompat notificationManager;

                            notificationManager = NotificationManagerCompat.from(this);

                            Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                                    .setSmallIcon(R.drawable.ic_message)
                                    .setContentTitle("Alerte Température")
                                    .setContentText("Temperature " + valeur + "°C")
                                    .setVibrate(new long[]{0, 250, 100, 250})
                                    .setSound(RingtoneManager.getActualDefaultRingtoneUri(this, R.raw.notifsound))
                                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                                    .setCategory(NotificationCompat.CATEGORY_ALARM)
                                    .build();

                            notificationManager.notify(1, notification);
                        }
                    }
                    if(etat.equals("0")) {
                        findViewById(R.id.ONtemp).setBackgroundColor(Color.WHITE);
                        findViewById(R.id.OFFtemp).setBackgroundColor(Color.RED);
                    }

                }
            }



    }
}

