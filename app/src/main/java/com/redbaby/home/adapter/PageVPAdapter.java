package com.redbaby.home.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.redbaby.home.view.HomeFragment;

import java.util.List;

/**
 * 用途：
 * author：王倩凤Administrator
 * date:2017/5/21.
 */

public class PageVPAdapter extends FragmentPagerAdapter {
    private final List<String> title;
    private final List<String> uri;

    public PageVPAdapter(FragmentManager fm, List<String> title, List<String> uri) {
        super(fm);
        this.title = title;
        this.uri = uri;
    }

    @Override
    public Fragment getItem(int position) {
        HomeFragment pageFragment = HomeFragment.getFragment(uri.get(position));
        return pageFragment;
    }

    @Override
    public int getCount() {
        return title.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
