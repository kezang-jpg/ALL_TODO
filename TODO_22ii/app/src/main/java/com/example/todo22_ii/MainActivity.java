package com.example.todo22_ii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String ACTION_CUSTOM_BROADCAST=
            BuildConfig.APPLICATION_ID+"ACTION_CUSTOM_BROADCAST";
    private CustomReceiver mReceiver;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mReceiver=new CustomReceiver();
        IntentFilter filter=new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(Intent.ACTION_POWER_CONNECTED);

        this.registerReceiver(mReceiver,filter);

        LocalBroadcastManager.getInstance(this)
                .registerReceiver(mReceiver,new IntentFilter(ACTION_CUSTOM_BROADCAST));


    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.unregisterReceiver(mReceiver);
        LocalBroadcastManager.getInstance(this)
                .registerReceiver(mReceiver,t);
    }

    public void sendCustomBroadcast(View view) {
        Intent customBroadcastIntent=new Intent(ACTION_CUSTOM_BROADCAST);
        LocalBroadcastManager.getInstance(this).sendBroadcast(customBroadcastIntent);
    }
}