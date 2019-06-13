package com.example.fg;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;

import java.security.Provider;
import java.util.List;
import java.util.Map;

public class Music extends Service {
    MediaPlayer mediaPlayer;
    int id;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer = MediaPlayer.create(this,R.raw.baothuc);
        mediaPlayer.start();
        Log.e("Music","Xin Chao");
        String Khoa = intent.getExtras().getString("extra");
        Log.e("Vao key", Khoa);

        if (Khoa.equals("on")){
            id = 1;
        }else  if (Khoa.equals("off")){
            id = 0;
        }
        if (id==1){
            mediaPlayer = MediaPlayer.create(this,R.raw.baothuc);
            mediaPlayer.start();
            id=0;
        }else if (id==0){
            mediaPlayer.stop();
            mediaPlayer.reset();
        }

        return START_NOT_STICKY;
    }
}
