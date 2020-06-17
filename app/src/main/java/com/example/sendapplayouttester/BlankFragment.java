package com.example.sendapplayouttester;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
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

        ((ImageView) view.findViewById(R.id.imageView)).setImageDrawable(getResources().getDrawable(R.drawable.ic_data_placeholder));

        final ImageView arrow1 =  view.findViewById(R.id.arrow1);
        final ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(
                arrow1,
                PropertyValuesHolder.ofFloat("translationX", 5),
                PropertyValuesHolder.ofFloat("alpha", 0.4f));
                //PropertyValuesHolder.ofFloat("scaleX", 1.2f),
                //PropertyValuesHolder.ofFloat("scaleY", 1.2f));
        scaleDown.setDuration(700);

        scaleDown.setRepeatCount(ObjectAnimator.INFINITE);
        scaleDown.setRepeatMode(ObjectAnimator.REVERSE);
        scaleDown.setInterpolator(new AccelerateDecelerateInterpolator());

        scaleDown.start();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (positionOffset > 0.5){
                    arrow1.setImageAlpha(0);
                    scaleDown.cancel();
                    viewPager.removeOnPageChangeListener(this);
                }
            }

            @Override
            public void onPageSelected(int position) {
                //Toast.makeText(BlankFragment.super.getContext(), ""+position, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        return view;
    }

}
