package com.example.fg;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.time.Instant;
import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;

public class BaoThuc extends Fragment {
    Calendar calendar;
   AlarmManager alarmManager;
    PendingIntent pendingIntent;
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_baothuc, container, false);

        final Button hengio = view.findViewById(R.id.bnthengio);
        final  Button dunglai = view.findViewById(R.id.bntdunglai);
        final TextView htgio = view.findViewById(R.id.hienthigio);
        final TimePicker dongho = view.findViewById(R.id.timePicker);
        calendar = Calendar.getInstance();
        alarmManager = (AlarmManager) getActivity().getSystemService(ALARM_SERVICE);
        hengio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar.set(Calendar.HOUR_OF_DAY,dongho.getHour());
                calendar.set(Calendar.MINUTE,dongho.getMinute());
                int gio = dongho.getHour();
                int phut =dongho.getMinute();
//                String string_gio = String.valueOf(gio);
//                String string_phut = String.valueOf(phut);
//                if (gio > 12){
//                    string_gio = String.valueOf(gio = 12);
//                }
//                if(phut < 10){
//                    string_phut = "0" + String.valueOf(phut);
//                }
                htgio.setText("Giờ bạn đặt là:" +gio+ ":" +phut+"");

            }
        });
        dunglai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                htgio.setText("Dừng lại:");
            }
        });

        return view;
    }
}
