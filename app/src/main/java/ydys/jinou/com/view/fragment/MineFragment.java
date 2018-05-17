package ydys.jinou.com.view.fragment;


import android.util.Log;

import ydys.jinou.com.R;
import ydys.jinou.com.presenter.HomePresenter;
import ydys.jinou.com.view.base.BaseFragment;


/**
 * author: 晨光光
 * date : 2018/5/16 20:34
 */
public class MineFragment extends BaseFragment<HomePresenter> {

    private String TAG = "HomeFragment";
    private HomePresenter homePresenter;

    @Override
    protected HomePresenter getPresenter() {
        homePresenter = new HomePresenter();
        return homePresenter;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int setBaseView() {
        return R.layout.main_fragment_layout;
    }

    @Override
    public void succeed(String s) {
        Log.e(TAG, "succeed: "+s );
    }

    @Override
    public void failure(String error) {
        Log.e(TAG, "error: "+error);
    }


}
