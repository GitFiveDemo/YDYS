package ydys.jinou.com.view.activity;


import android.view.View;

import ydys.jinou.com.R;
import ydys.jinou.com.view.base.BaseActivity;

public class SettingActivity extends BaseActivity {


    @Override
    protected void initView() {
        setActivityTitle("设置");
    }

    @Override
    protected void initDate() {

    }

    @Override
    protected View getChildView() {
        View view = View.inflate(this, R.layout.activity_setting,null);
        return view;
    }

    @Override
    protected boolean isHideTitle() {
        return false;
    }
}
