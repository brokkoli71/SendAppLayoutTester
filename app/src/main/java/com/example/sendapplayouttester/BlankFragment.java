package com.example.sendapplayouttester;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    ViewPager viewPager;

    public BlankFragment(ViewPager viewPager) {
        this.viewPager = viewPager;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        final ImageView arrow1 =  view.findViewById(R.id.arrow1);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.w("position", position+","+positionOffset+","+positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                //Toast.makeText(BlankFragment.super.getContext(), ""+position, Toast.LENGTH_LONG).show();
                if (position == 0){
                    arrow1.setImageAlpha(0);
                    Animation fadeIn = new AlphaAnimation(1, 0);
                    fadeIn.setInterpolator(new DecelerateInterpolator());
                    fadeIn.setDuration(1000);
                    arrow1.setAnimation(fadeIn);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        return view;
    }

}
