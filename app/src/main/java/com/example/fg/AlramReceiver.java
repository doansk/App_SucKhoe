package com.example.fg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlramReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("Tôi trong Receiver","Xin Chào");
        Intent myIntent = new Intent(context,Music.class);
        context.startService(myIntent);
    }
}
