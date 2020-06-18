package com.example.sendapplayouttester;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class SendFragment extends Fragment {

    ViewPager viewPager;

    public SendFragment(ViewPager viewPager) {
        this.viewPager = viewPager;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_send, container, false);

        ImageView imageView = ((ImageView) view.findViewById(R.id.imageView2));
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_data_placeholder));
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w("hk","kl");
            }
        });
        return view;
    }

}
