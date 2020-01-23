package com.example.h_house;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Notification;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SmsManager;
import android.widget.Toast;

import static com.example.h_house.notification.CHANNEL_1_ID;

public class MainActivity extends AppCompatActivity implements MessageListener  {
    private  static final int MY_PERMISSIONS_REQUEST_RECEIVE_SMS=0;
    private  static final int MY_PERMISSIONS_REQUEST_SEND_SMS=1;
    public static String type;
    public static String valeur;
    public static String etat;
    public static String passage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ReceiveSMS.bindListener(this);
        /*
        if(passage.equals("Bienvenue"))
        {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(getApplicationContext(),MenuOnClick.class);
                    startActivity(intent);
                    finish();
                }
            };
            new Handler().postDelayed(runnable, 1000);
        }

         */


        SmsManager.getDefault().sendTextMessage("+33652227062",null,"\n{Bienvenue}",null,null);


        if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED)
        {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS))
            {

            }
            else
            {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }


        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.RECEIVE_SMS)!= PackageManager.PERMISSION_GRANTED)
        {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.RECEIVE_SMS))
            {

            }
            else
            {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECEIVE_SMS},MY_PERMISSIONS_REQUEST_RECEIVE_SMS );
            }
        }

/*
        Button Menu = (Button) findViewById(R.id.MENUE);
        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, intermid.class));

            }
        });

 */

    }

    public void onRequestPermissionsResult(int requestCode, String permission[], int[] grantResults)
    {
        switch (requestCode)
        {
            case MY_PERMISSIONS_REQUEST_RECEIVE_SMS :
            {
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(this,"Reception de message accepté!!",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(this,"les fonctionalités de l'application sont reduites!!",Toast.LENGTH_LONG).show();

                }
            }
            case  MY_PERMISSIONS_REQUEST_SEND_SMS :

            {
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(this,"envoie de message accepté!!",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(this,"les fonctionalités de l'application sont reduites!!",Toast.LENGTH_LONG).show();

                }
            }

        }
    }

    public void messageReceived(String num, String message) {


        if (num.equals("+33652227062")) {

            type = message.substring(message.indexOf("{") + 1, message.indexOf("="));
            valeur = message.substring(message.indexOf("=") + 1, message.indexOf("#"));
            etat = message.substring(message.indexOf("#") + 1, message.indexOf("}"));
           if(type.equals("Bienvenue")){
               //passage="Bienvenue";
               //startActivity(new Intent(MainActivity.this, MenuOnClick.class));
               Runnable runnable = new Runnable() {
                   @Override
                   public void run() {
                       Intent intent = new Intent(getApplicationContext(),MenuOnClick.class);
                       startActivity(intent);
                       finish();
                   }
               };
               new Handler().postDelayed(runnable, 100);

           }
            else if (type.equals("temperature")) {

                if (etat.equals("1")) {

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


            } else if (type.equals("alerte gaz")) {
                if (etat.equals("1")) {

                    NotificationManagerCompat notificationManager;

                    notificationManager = NotificationManagerCompat.from(this);

                    Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                            .setSmallIcon(R.drawable.ic_message)
                            .setContentTitle("Alerte gaz")
                            .setContentText("presence de gaz detectée")
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .setCategory(NotificationCompat.CATEGORY_ALARM)
                            .build();

                    notificationManager.notify(1, notification);


                }
            } else if (type.equals("alerte intrusion")) {
                if (etat.equals("1")) {

                    NotificationManagerCompat notificationManager;

                    notificationManager = NotificationManagerCompat.from(this);

                    Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                            .setSmallIcon(R.drawable.ic_message)
                            .setContentTitle("Alerte intrusion")
                            .setContentText("presence de mouvement detectée")
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .setCategory(NotificationCompat.CATEGORY_ALARM)
                            .build();

                    notificationManager.notify(1, notification);

                }
            }
        }
    }





}

