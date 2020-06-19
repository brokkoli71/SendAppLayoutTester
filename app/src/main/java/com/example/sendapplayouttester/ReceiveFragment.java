package com.example.sendapplayouttester;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.qrcode.QRCodeWriter;

public class ReceiveFragment extends Fragment {
    ViewPager viewPager;

    public ReceiveFragment(ViewPager viewPager) {
        this.viewPager = viewPager;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_receive, container, false);

        final ImageView arrow1 =  view.findViewById(R.id.arrow1);
        ImageView imageView =  view.findViewById(R.id.imageView);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_data_placeholder));


        final ArrowIndicatorAnimator arrowIndicatorAnimator = new ArrowIndicatorAnimator(arrow1) {
            @Override
            void onClickArrow() {
                viewPager.setCurrentItem(1,true);
            }
        };

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (positionOffset > 0.5){
                    arrowIndicatorAnimator.cancel();
                    arrow1.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        return view;
    }

}
