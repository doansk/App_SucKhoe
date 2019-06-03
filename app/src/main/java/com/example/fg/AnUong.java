package com.example.fg;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class AnUong extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable  ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_anuong, container, false);

        ImageView tcan = (ImageView) view.findViewById(R.id.imgtangcan);
        ImageView bntthuong = (ImageView) view.findViewById(R.id.imgbinhthuong);
        ImageView bntgiamcan = (ImageView) view.findViewById(R.id.imggiamcan);
        tcan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bnttangcan(v);
            }
        });
        bntthuong.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bntbinhthuong(v);
            }
        });
        bntgiamcan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bntgiamcan(v);
            }
        });
        return (view);
    }
    public void bnttangcan(View view){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.Nen, new TangCan());
        transaction.addToBackStack(null);
        transaction.commit();
    }
        public void bntbinhthuong(View view){
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.Nen, new BinhThuong());
            transaction.addToBackStack(null);
            transaction.commit();
        }
    public void bntgiamcan(View view){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.Nen, new GiamCan());
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
