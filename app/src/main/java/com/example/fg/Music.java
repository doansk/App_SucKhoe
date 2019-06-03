package com.example.fg;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.MediaStore;
import android.util.Log;

import java.security.Provider;
import java.util.List;
import java.util.Map;

public class Music extends Service {
    MediaPlayer mediaPlayer;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer = MediaPlayer.create(this,R.raw.baothuc);
        mediaPlayer.start();
        Log.e("Tôi trong music","xin chào");
        return START_STICKY;
    }
}
