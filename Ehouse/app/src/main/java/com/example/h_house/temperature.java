
package com.example.h_house;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.TextView;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.telephony.SmsManager;
import android.widget.Button;

public class temperature extends AppCompatActivity implements MessageListener {
    public static final String CHANNEL_1_ID = "channel1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        ReceiveSMS.bindListener(this);


        SmsManager.getDefault().sendTextMessage("+33766189022",null,"\n{temperature}",null,null);

    }
    public void messageReceived(String num, String message) {
        //  Toast.makeText(this, "New Message Received: " + message, Toast.LENGTH_SHORT).show();

            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText("Température : " + message+" °C");

        NotificationManagerCompat notificationManager;

        notificationManager = NotificationManagerCompat.from(this);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_message)
                .setContentTitle("Alerte Température 2")
                .setContentText("Temperature "+message+"°C")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManager.notify(1, notification);



    }
}

