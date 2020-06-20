package com.example.sendapplayouttester;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import me.relex.circleindicator.CircleIndicator;
import me.relex.circleindicator.CircleIndicator3;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    int currentFragmentActive = 0;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        viewPager = findViewById(R.id.pager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), viewPager);
        viewPager.setAdapter(viewPagerAdapter);

        /*final Button buttonSwapFragment = findViewById(R.id.button_swap_fragment);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentFragmentActive = position;
                if (position==1){
                    buttonSwapFragment.setText("RECEIVE");
                    return;
                }
                buttonSwapFragment.setText("SEND");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        buttonSwapFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentFragmentActive = 1-currentFragmentActive;
                viewPager.setCurrentItem(currentFragmentActive,true);
            }
        });*/

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        CircleIndicator indicator = findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.w("activity_result", "code "+resultCode);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            viewPagerAdapter.sendFragment.onReceiveQR(result);
        } else {
            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
