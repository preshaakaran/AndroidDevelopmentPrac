package com.example.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();
        Object[] smsObj = (Object[]) bundle.get("pdus");
        for(Object obj : smsObj){
            SmsMessage message = SmsMessage.createFromPdu((byte[]) obj);

            String mobNo = message.getDisplayOriginatingAddress();
            String msg = message.getDisplayMessageBody();
            Log.d("SMS Details", "MobNo:" +mobNo + ",Msg: " + msg);


            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage("+919876543210", null, "Hello from Android", null, null);

        }

    }
}
