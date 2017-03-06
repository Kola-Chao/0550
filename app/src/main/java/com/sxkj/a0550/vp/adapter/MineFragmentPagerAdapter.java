package com.sxkj.a0550.vp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Introduce:
 * Author：mac
 * Date：2017/3/4
 * Time: 下午4:22
 */

public class MineFragmentPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;

    public MineFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.size();
    }
}
