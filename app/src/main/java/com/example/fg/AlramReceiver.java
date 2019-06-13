package com.example.fg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlramReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("AlramReceiver","Xin Chao");
        String music = intent.getExtras().getString("extra");
        Log.e("Go Music", music);

        Intent myIntent = new Intent(context,Music.class);
        myIntent.putExtra("extra",music);
        context.startService(myIntent);
    }
}
