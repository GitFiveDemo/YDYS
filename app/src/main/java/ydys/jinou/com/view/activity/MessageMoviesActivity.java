package ydys.jinou.com.view.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dl7.player.media.IjkPlayerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import ydys.jinou.com.R;
import ydys.jinou.com.model.cache.CollectCacheBean;
import ydys.jinou.com.model.db.CollectCacheBeanDao;
import ydys.jinou.com.model.http.ServiceUrl;
import ydys.jinou.com.presenter.HomePresenter;
import ydys.jinou.com.util.SQLiteHelper;
import ydys.jinou.com.view.adapter.TabAdapters;
import ydys.jinou.com.view.base.BaseMVPActivity;
import ydys.jinou.com.view.callback.SimpleCallBack;
import ydys.jinou.com.view.fragment.Home_JJ_Fragment;
import ydys.jinou.com.view.fragment.Home_pls_Framgent;

public class MessageMoviesActivity extends BaseMVPActivity<HomePresenter> implements SimpleCallBack<String>{

    private static final String TAG = "Aaa";
    @BindView(R.id.back_mess)
    ImageView backMess;
    @BindView(R.id.soucang)
    ImageView soucang;
    @BindView(R.id.player_view)
    IjkPlayerView playerView;
    @BindView(R.id.tablayout)
    TabLayout tablayout;
    List<Fragment> list;
    List<String> data;
    @BindView(R.id.tuijian_viewpager)
    ViewPager viewpager;
    @BindView(R.id.name)
    TextView name;
    private HomePresenter homePresenter;


    @Override
    protected boolean isHideTitle() {
        return true;
    }

    private void initTab() {
        list = new ArrayList<>();
        data = new ArrayList<>();
        list.add(new Home_JJ_Fragment());
        list.add(new Home_pls_Framgent());
        data.add("简介");
        data.add("评论");
        TabAdapters myAdapter = new TabAdapters(getSupportFragmentManager(), list, data);
        viewpager.setAdapter(myAdapter);
        tablayout.setupWithViewPager(viewpager);
    }

    @Override
    protected HomePresenter getPresenter() {
        String id = getIntent().getStringExtra("id");
        homePresenter= new HomePresenter();
        Map<String,String> map=new HashMap<>();
        map.put("mediaId",id);
        homePresenter.getData(ServiceUrl.message_url, map);
        return homePresenter;
    }

    @Override
    protected View getMVPView() {
        return View.inflate(this, R.layout.activity_message_movie, null);
    }

    @Override
    protected void functionExtension() {
        initTab();
    }

    @OnClick({R.id.back_mess, R.id.soucang})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_mess:
                finish();
                break;
            case R.id.soucang:
                collectData();
                break;
        }
    }

    private void collectData(){
        CollectCacheBeanDao collectCacheBeanDao = SQLiteHelper.getIntance(this).getDaoSession().getCollectCacheBeanDao();
        long insert = collectCacheBeanDao.insert(getCollectEctity());
        if (insert!=-1)
            Toast.makeText(this, "insetSucceed", Toast.LENGTH_SHORT).show();
    }

    private CollectCacheBean getCollectEctity(){
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String title = intent.getStringExtra("title");
        String jianjie = intent.getStringExtra("jianjie");
        String picture = intent.getStringExtra("picture");
        String id = intent.getStringExtra("id").substring(0,6);
        long longId = Long.parseLong(id, 16);
        return new CollectCacheBean(longId,picture,url,title,jianjie);
    }

    @Override
    public void succeed(String s) {
        String url = getIntent().getStringExtra("url");
        String title = getIntent().getStringExtra("title");
        playerView.setVideoPath(url);
        name.setText(title);
    }

    @Override
    public void failure(String error) {
        Log.e("failure","error:>>"+error);
    }

}
