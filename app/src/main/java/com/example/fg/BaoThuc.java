package com.example.fg;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class BaoThuc extends AppCompatActivity {
    Calendar calendar;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bao_thuc);
        final Button hengio = findViewById(R.id.bnthengio);
        final  Button dunglai = findViewById(R.id.bntdunglai);
        final TextView htgio = findViewById(R.id.hienthigio);
        final TimePicker dongho = findViewById(R.id.timePicker);
        calendar = Calendar.getInstance();
        alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        final Intent intent = new Intent(BaoThuc.this,AlramReceiver.class);
        hengio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                calendar.set(Calendar.HOUR_OF_DAY,dongho.getHour());
                calendar.set(Calendar.MINUTE,dongho.getMinute());

                int gio = dongho.getHour();
                int phut = dongho.getMinute();

                String string_gio = String.valueOf(gio);
                String string_phut = String.valueOf(phut);

                if (gio > 12 ){
                    string_gio = String.valueOf(gio - 12);
                }
                if (phut < 10 ){
                    string_phut = "0" + String.valueOf(phut);
                }
                intent.putExtra("extra","on");

                pendingIntent = PendingIntent.getBroadcast(
                        BaoThuc.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT
                );
                alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);

                htgio.setText("Giờ bạn đặt là:" + string_gio + ":" + string_phut);
            }
        });
        dunglai.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                htgio.setText("Ngưng Báo Thức");
                alarmManager.cancel(pendingIntent);
                intent.putExtra("extra","off");
                sendBroadcast(intent);

            }
        });
    }
}