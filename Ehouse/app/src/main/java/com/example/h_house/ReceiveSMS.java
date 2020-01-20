package com.example.h_house;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.telephony.*;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


public class ReceiveSMS extends BroadcastReceiver {
    public static String valeurtemperature="0";
    public static int valtemp;
    private static MessageListener mListener;

    public static String getValeurtemperature() {
        return valeurtemperature;
    }

    public static void setValeurtemperature(String valeurtemperature) {
        ReceiveSMS.valeurtemperature = valeurtemperature;
    }

    @Override

    public void onReceive(Context context, Intent intent) {
        try {
            Bundle data = intent.getExtras();
            Object[] pdus = (Object[]) data.get("pdus");
            for (int i = 0; i < pdus.length; i++) {
                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdus[i]);
                mListener.messageReceived(smsMessage.getDisplayOriginatingAddress(), smsMessage.getMessageBody());
                valeurtemperature=smsMessage.getMessageBody();
                 valtemp = Integer.parseInt(valeurtemperature);

                if(valtemp>30)
                {

                   // Toast.makeText(context, "Alerte Température!!!! " +valtemp+ " °C",  Toast.LENGTH_LONG).show();


                }
            }

        }
        catch (Exception e)
        {

        }
    }

    public static void bindListener(MessageListener listener){
        mListener = listener;
    }



}


