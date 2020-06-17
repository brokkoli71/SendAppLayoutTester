package com.example.sendapplayouttester;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    ViewPager viewPager;

    public ViewPagerAdapter(@NonNull FragmentManager fm, ViewPager viewPager) {
        super(fm);
        this.viewPager = viewPager;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position==0)
            return new BlankFragment(viewPager);
        return new SecondFragment(viewPager);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position==0)
            return "receive";
        return "send";
    }
}
