package com.paulniu.mykeyboarddemo.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Coder: niupuyue
 * Date: 2019/5/20
 * Time: 10:53
 * Desc:
 * Version:
 */
public class SmilyViewPagerAdapter extends PagerAdapter {

    private List<Fragment> fragments;
    private FragmentManager fragmentManager;

    public SmilyViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        this.fragments = fragments;
        this.fragmentManager = fm;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(fragments.get(position).getView());
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = fragments.get(position);
        if (!fragment.isAdded()) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.add(fragment, fragment.getClass().getSimpleName());
            ft.commit();
            //提交事务
            fragmentManager.executePendingTransactions();
        }
        if (fragment.getView().getParent() == null) {
            container.addView(fragment.getView());
        }
        return fragment.getView();
    }
}
