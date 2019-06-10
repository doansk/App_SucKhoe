package com.example.fg;

import android.content.Context;
import android.content.Intent;
import android.icu.text.BreakIterator;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.util.List;

public class GhiChu extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ghi_chu, container, false);
        final Button nextvietghichu = view.findViewById(R.id.button2);
        nextvietghichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getActivity(), Vietghichu.class);
                startActivity(intent);
            }
        });
        return (view);
    }
}
