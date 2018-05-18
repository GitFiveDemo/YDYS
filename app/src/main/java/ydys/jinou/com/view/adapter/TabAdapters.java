package ydys.jinou.com.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 王有道 on 2018/4/9.
 */

public class TabAdapters extends FragmentPagerAdapter {

    List<Fragment> list;
    List<String> data ;
    public TabAdapters(FragmentManager fm, List<Fragment> list, List<String> data) {
        super(fm);
        this.data=data;
        this.list=list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    public List<Fragment> getList() {
        return list;
    }

    public void setList(List<Fragment> list) {
        this.list = list;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return  data.get(position);
    }
}
