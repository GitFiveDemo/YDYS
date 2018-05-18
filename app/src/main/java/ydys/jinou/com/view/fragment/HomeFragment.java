package ydys.jinou.com.view.fragment;


import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.OnClick;
import ydys.jinou.com.R;
import ydys.jinou.com.model.bean.HomeBean;
import ydys.jinou.com.model.http.ServiceUrl;
import ydys.jinou.com.presenter.HomePresenter;
import ydys.jinou.com.view.activity.SerchMovieActivity;
import ydys.jinou.com.view.adapter.HomeAdapter;
import ydys.jinou.com.view.base.BaseFragment;
import ydys.jinou.com.view.custom.GlideImageLoader;

/**
 * author: 晨光光
 * date : 2018/5/16 20:34
 */
public class HomeFragment extends BaseFragment<HomePresenter> {

    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.serch_movie)
    EditText serchMovie;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.duanzi_smart)
    SmartRefreshLayout duanziSmart;
    private String TAG = "HomeFragment";
    private HomePresenter homePresenter;
    private HomeAdapter homeAdapter;
    private ProgressDialog progressDialog;

    @Override
    protected HomePresenter getPresenter() {
        homePresenter = new HomePresenter();
        return homePresenter;
    }

    @Override
    protected void initData() {
        //注册
        EventBus.getDefault().register(this);

        inbanner();
        //禁用滑动事件
        recyclerview.setNestedScrollingEnabled(false);
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));

        initRefresh();

        //显示加载框
        showProgressDialog("提示", "正在加载......");
        Map<String, String> map = new HashMap<>();
        homePresenter.getData(ServiceUrl.homeUrl, map);
    }

    //判断加载是否完成
    public void showProgressDialog(String title, String message) {
        if (progressDialog == null) {

            progressDialog = ProgressDialog.show(getActivity(), title,
                    message, true, false);
            
        } else if (progressDialog.isShowing()) {
            progressDialog.setTitle(title);
            progressDialog.setMessage(message);

        }
        progressDialog.setCancelable(true);
        progressDialog.show();
    }

    public void hideProgressDialog() {

        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            //    progressDialog.hide();
        }

    }

    private void initRefresh() {
        duanziSmart.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        duanziSmart.finishRefresh();
                    }
                }, 2000);

            }
        });
    }


    @Override
    protected int setBaseView() {
        return R.layout.home_fragment_layout;
    }

    @Override
    public void succeed(String s) {
        List<String> imageUrls = new ArrayList<>();
        HomeBean homeBean = new Gson().fromJson(s, HomeBean.class);
        Log.e(TAG, "succeed: " + s);
        List<HomeBean.RetBean.ListBean.ChildListBean> list = homeBean.getRet().getList().get(0).getChildList();

        Log.e(TAG, "succeed: " + list);
        homeAdapter = new HomeAdapter(getActivity(), list);

        recyclerview.setAdapter(homeAdapter);


        //获取图片
        for (int i = 0; i < list.size(); i++) {
            imageUrls.add(list.get(i).getPic());
        }

        banner.setImages(imageUrls);
        banner.start();
        hideProgressDialog();
    }

    private void inbanner() {

        //设置banner样式...CIRCLE_INDICATOR_TITLE包含标题
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(2000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);

    }

    @Override
    public void failure(String error) {
        Log.e(TAG, "error: " + error);
    }

    @OnClick({R.id.serch_movie})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.serch_movie:
                Intent intent = new Intent(getActivity(), SerchMovieActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, priority = 1000)
    public void onToastEvent(Integer msg) {//参数就是订阅的事件(其实就是传递数据的类)
        if (msg == -1){
            banner.start();
        }else{
            banner.stopAutoPlay();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
