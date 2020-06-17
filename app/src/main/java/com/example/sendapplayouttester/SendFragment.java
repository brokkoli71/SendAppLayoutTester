package com.example.sendapplayouttester;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_send, container, false);

        ((ImageView) view.findViewById(R.id.imageView2)).setImageDrawable(getResources().getDrawable(R.drawable.ic_data_placeholder));
        return view;
    }

}
