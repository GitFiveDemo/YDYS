package ydys.jinou.com.view.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import ydys.jinou.com.R;
import ydys.jinou.com.model.bean.SpeciaDetailBean;
import ydys.jinou.com.model.http.ServiceUrl;
import ydys.jinou.com.presenter.HomePresenter;
import ydys.jinou.com.view.adapter.SpecialDetailAdapter;
import ydys.jinou.com.view.base.BaseMVPActivity;
import ydys.jinou.com.view.callback.SimpleCallBack;

public class SpecialDetailActivity extends BaseMVPActivity<HomePresenter> {

    private static final String TAG = "SpecialDetailActivity";
    @BindView(R.id.detail_recy_view)
    RecyclerView detailRecyView;
    private HomePresenter homePresenter;

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
        setActivityTitle("微电影");
        return View.inflate(this, R.layout.activity_special_detail, null);
    }

    @Override
    protected void functionExtension() {

        detailRecyView.setLayoutManager(new GridLayoutManager(this, 2));

        //获取传过来的路径

        Intent intent = getIntent();
        String loadURL = intent.getStringExtra("loadURL");
        try {
            loadURL = loadURL.replace(ServiceUrl.baseUrl, "");
            String[] split = loadURL.split("\\?");
            String[] paramter = split[1].split("=");
            HashMap<String, String> map = new HashMap<>();
            map.put(paramter[0], paramter[1]);
            homePresenter.getData(split[0], map);

        } catch (NullPointerException e) {
            Log.e("error", "空指针异常", e);
        }
    }

    @Override
    public void succeed(String s) {
        SpeciaDetailBean speciaDetailBean = new Gson().fromJson(s, SpeciaDetailBean.class);
        List<SpeciaDetailBean.RetBean.ListBean.ChildListBean> list = speciaDetailBean.getRet().getList().get(0).getChildList();
        Log.d("SpecialDetailActivity", "获取到专题详情集合-------------" + list);
        SpecialDetailAdapter specialDetailAdapter = new SpecialDetailAdapter(this, list);
        detailRecyView.setAdapter(specialDetailAdapter);
    }

    @Override
    public void failure(String error) {
        Log.d("SpecialDetailActivity", "出现异常====================" + error);
    }

}
