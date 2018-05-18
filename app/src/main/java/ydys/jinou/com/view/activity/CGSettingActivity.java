package ydys.jinou.com.view.activity;


import android.view.View;

import ydys.jinou.com.R;
import ydys.jinou.com.view.base.BaseActivity;

public class CGSettingActivity extends BaseActivity {


    @Override
    protected void initView() {
        setActivityTitle("设置");
    }

    @Override
    protected void initDate() {

    }

    @Override
    protected View getChildView() {
        View view = View.inflate(this, R.layout.activity_gc_setting,null);
        return view;
    }
}
