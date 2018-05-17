package ydys.jinou.com.view.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import ydys.jinou.com.R;
import ydys.jinou.com.view.base.BaseActivity;

public class BoonActivity extends BaseActivity {
    @BindView(R.id.boon_recycler)
    RecyclerView boonRecycler;

    @Override
    protected void initView() {
        setActivityTitle("福利");
    }

    @Override
    protected void initDate() {

    }

    @Override
    protected View getChildView() {
        View view = View.inflate(this, R.layout.activity_boon, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
