package com.example.fg;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;

public class DongHo extends Fragment {
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_dongho, container, false);
        final Button nextbaothuc = view.findViewById(R.id.button);
        nextbaothuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getActivity(), BaoThuc.class);
                startActivity(intent);
            }
    });
        return view;
    }
}