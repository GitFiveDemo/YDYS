package ydys.jinou.com.view.fragment;

import ydys.jinou.com.R;
import ydys.jinou.com.presenter.HomePresenter;

import ydys.jinou.com.view.base.BaseFragment;

public class Home_JJ_Fragment extends BaseFragment<HomePresenter>{
    @Override
    protected HomePresenter getPresenter() {
        HomePresenter homePresenter = new HomePresenter();
        return homePresenter;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int setBaseView() {
        return R.layout.jianjie_tab_lyout;
    }

    @Override
    public void succeed(String s) {

    }

    @Override
    public void failure(String error) {

    }
}
