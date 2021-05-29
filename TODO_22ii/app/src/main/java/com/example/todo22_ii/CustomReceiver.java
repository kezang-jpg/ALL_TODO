package com.example.todo22_ii;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {
    private static final String ACTION_CUSTOM_BROADCAST= BuildConfig.APPLICATION_ID+"ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction=intent.getAction();
        // TODO: This method is called when the BroadcastReceiver is receiving
        if (intentAction!=null){
            String toastMessage="";
            switch (intentAction){
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage="Power connected";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage="power of disconnected";
                    break;
                case  ACTION_CUSTOM_BROADCAST:
                    toastMessage="custom broadcast received";
                    break;
            }
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();

        }

        // an Intent broadcast.

    }
}