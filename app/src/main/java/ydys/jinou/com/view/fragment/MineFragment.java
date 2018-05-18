package ydys.jinou.com.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import ydys.jinou.com.R;
import ydys.jinou.com.presenter.HomePresenter;
import ydys.jinou.com.view.activity.SerchMovieActivity;
import ydys.jinou.com.view.activity.SettingActivity;
import ydys.jinou.com.view.base.BaseFragment;


/**
 * author: 晨光光
 * date : 2018/5/16 20:34
 */
public class MineFragment extends BaseFragment<HomePresenter> {

    @BindView(R.id.setting)
    ImageView setting;
    Unbinder unbinder;
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
        return R.layout.mine_fragment_layout;
    }

    @Override
    public void succeed(String s) {
        Log.e(TAG, "succeed: " + s);
    }

    @Override
    public void failure(String error) {
        Log.e(TAG, "error: " + error);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.setting:
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);
                break;
        }
    }
}
