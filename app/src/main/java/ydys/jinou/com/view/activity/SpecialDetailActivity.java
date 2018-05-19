package ydys.jinou.com.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import ydys.jinou.com.R;
import ydys.jinou.com.model.bean.SpeciaDetailBean;
import ydys.jinou.com.presenter.HomePresenter;
import ydys.jinou.com.view.adapter.SpecialDetailAdapter;
import ydys.jinou.com.view.base.BaseActivity;
import ydys.jinou.com.view.base.BaseMVPActivity;
import ydys.jinou.com.view.callback.SimpleCallBack;

public class SpecialDetailActivity extends BaseMVPActivity<HomePresenter> implements SimpleCallBack<String> {

    @BindView(R.id.detail_recy_view)
    RecyclerView detailRecyView;
    private HomePresenter homePresenter;

    @Override
    protected void initView() {
        detailRecyView.setLayoutManager(new GridLayoutManager(this,3));
    }

    @Override
    protected void initDate() {
    }

    @Override
    protected boolean isHideTitle() {
        return false;

    }


    @Override
    protected HomePresenter getPresenter() {
        homePresenter = new HomePresenter();
        return homePresenter;
    }


    @Override
    protected View getMVPView() {
        return View.inflate(this,R.layout.activity_special_detail,null);
    }

    @Override
    protected void functionExtension() {
        //获取传过来的路径
        Intent intent = getIntent();
        String loadURL = intent.getStringExtra("loadURL");
        if (loadURL != null) {
            homePresenter.getData(loadURL,null);
        }

    }

    @Override
    public void succeed(String s) {
        SpeciaDetailBean speciaDetailBean = new Gson().fromJson(s, SpeciaDetailBean.class);
        List<SpeciaDetailBean.RetBean.ListBean> list = speciaDetailBean.getRet().getList();
        Log.d("SpecialDetailActivity", "获取到专题详情集合-------------"+list);
        SpecialDetailAdapter specialDetailAdapter = new SpecialDetailAdapter(this, list);
        detailRecyView.setAdapter(specialDetailAdapter);
    }

    @Override
    public void failure(String error) {
        Log.d("SpecialDetailActivity", "出现异常===================="+error);
    }
}
