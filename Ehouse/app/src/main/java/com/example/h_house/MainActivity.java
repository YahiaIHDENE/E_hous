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
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.h_house.notification.CHANNEL_1_ID;

public class MainActivity extends AppCompatActivity {
    private  static final int MY_PERMISSIONS_REQUEST_RECEIVE_SMS=0;
    private  static final int MY_PERMISSIONS_REQUEST_SEND_SMS=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


        Button Menu = (Button) findViewById(R.id.MENUE);
        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MenuOnClick.class));
            }
        });

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


}
