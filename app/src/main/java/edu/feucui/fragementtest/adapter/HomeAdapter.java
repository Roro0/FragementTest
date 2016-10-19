package edu.feucui.fragementtest.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 *
 * Created by Administrator on 2016/9/28.
 */
public class HomeAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> mListData;
    public HomeAdapter(FragmentManager fm,ArrayList<Fragment> mListData) {
        super(fm);
        this.mListData=mListData;
    }

    @Override
    public Fragment getItem(int position) {
        return mListData.get(position);
    }

    @Override
    public int getCount() {
        return mListData==null?0:mListData.size();
    }

}
