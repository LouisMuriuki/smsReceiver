package com.example.test1;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

public class SmsReceiver extends BroadcastReceiver {
    private static final String TAG = SmsReceiver.class.getSimpleName();
    public static final String pdu_type = "pdus";

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onReceive(Context context, Intent intent) {
        // Get the SMS message.
        Bundle bundle = intent.getExtras();
        SmsMessage[] msgs =null;
        String msg="";
        String strMessage = "";
        String from="";
        if(bundle != null){
if(bundle!=null){

       // String format = bundle.getString("format");
        // Retrieve the SMS message received.
        Object[] pdus = (Object[]) bundle.get(pdu_type);
     //   Toast.makeText(context, "Heeey", Toast.LENGTH_LONG).show();
        if (pdus != null) {
            // Check the Android version.

            // Fill the msgs array.
            msgs = new SmsMessage[pdus.length];
            for (int i = 0; i < msgs.length; i++) {
                // Check Android version and use appropriate createFromPdu.

                // If Android version M or newer:
                msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);

                // Build the message to show.
                strMessage += "SMS from " + msgs[i].getOriginatingAddress();
                from = msgs[i].getOriginatingAddress();
                strMessage += " :" + msgs[i].getMessageBody() + "\n";
                msg = msgs[i].getMessageBody();
                strMessage += "";
            }

            // Log and display the SMS message.
            Log.d(TAG, "onReceive: " + strMessage);
            Toast.makeText(context, strMessage, Toast.LENGTH_LONG).show();
//            Intent intent2= new Intent(context.getApplicationContext(), MainActivity.class);
//            intent2.putExtra("msgContent", msg);
//            intent2.putExtra("sender", from);
//            intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("msgContent", "Fucking bastard");
            intent.putExtra("sender", "work mqaaaan");
            intent.setClass(context, MainActivity.class);
            Toast.makeText(context, "heeeeyyy", Toast.LENGTH_LONG).show();
            context.startActivity(intent);

//            context.startActivity(intent2);
        } else{
    Toast.makeText(context, "Empty receiver" ,Toast.LENGTH_LONG).show();}
        }
        }

    }
}
//    public static final String SMS_BUNDLE = "pdus";
//    @RequiresApi(api = Build.VERSION_CODES.M)
//    @Override
//    public void onReceive(Context context, Intent intent) {
//        Bundle intentExtras = intent.getExtras();
//        if (intentExtras != null) {
//            Object[] sms = (Object[]) intentExtras.get(SMS_BUNDLE);
//            StringBuilder smsMessageStr = new StringBuilder();
//            for (Object sm : sms) {
//                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) sm);
//
//                String smsBody = smsMessage.getMessageBody();
//                String address = smsMessage.getOriginatingAddress();
//
//                smsMessageStr.append("SMS From: ").append(address).append("\n");
//                smsMessageStr.append(smsBody).append("\n");
//            }
//            Toast.makeText(context, smsMessageStr.toString(), Toast.LENGTH_SHORT).show();
//
//            //this will update the UI with message

//        }
//    }