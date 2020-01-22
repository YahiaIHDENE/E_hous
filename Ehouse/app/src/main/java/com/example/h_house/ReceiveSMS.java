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


public class ReceiveSMS extends BroadcastReceiver {
    private static MessageListener mListener;

      @Override

    public void onReceive(Context context, Intent intent) {
        try {
            Bundle data = intent.getExtras();
            Object[] pdus = (Object[]) data.get("pdus");
            for (int i = 0; i < pdus.length; i++) {
                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdus[i]);
                mListener.messageReceived(smsMessage.getDisplayOriginatingAddress(), smsMessage.getMessageBody());

            }
        }
        catch (Exception e) { }
    }

    public static void bindListener(MessageListener listener){
        mListener = listener;
    }



}


