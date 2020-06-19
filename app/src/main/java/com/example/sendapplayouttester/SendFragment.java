package com.example.sendapplayouttester;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
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

        final ImageView imageView =  view.findViewById(R.id.imageView2);
        final TextView imageViewText =  view.findViewById(R.id.imageViewText);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_data_placeholder));
                imageViewText.setVisibility(View.GONE);
                imageView.setOnClickListener(null);
            }
        });

        Button buttonQR = view.findViewById(R.id.button_send_qr);
        buttonQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View e) {

            }
        });
        return view;
    }

}
