package ydys.jinou.com.view.activity;

import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import ydys.jinou.com.R;
import ydys.jinou.com.model.bean.BoonBean;
import ydys.jinou.com.model.http.ServiceUrl;
import ydys.jinou.com.presenter.HomePresenter;
import ydys.jinou.com.view.adapter.BoonAdapter;
import ydys.jinou.com.view.base.BaseMVPActivity;
import ydys.jinou.com.view.callback.SimpleCallBack;

public class BoonActivity extends BaseMVPActivity<HomePresenter> implements SimpleCallBack<String> {
    @BindView(R.id.boon_recycler)
    RecyclerView boonRecycler;
    @BindView(R.id.boon_smartRefresh)
    SmartRefreshLayout refreshLayout;
    private List<BoonBean.ResultsBean> maxList;
    private boolean isRefresh = true;
    private HomePresenter homePresenter;
    private int page = 1;
    private int lastOffset;
    private int lastPosition;
    @Override
    protected HomePresenter getPresenter() {
        homePresenter = new HomePresenter();
        homePresenter.getGKData(ServiceUrl.gkBoonUrl + page);
        return homePresenter;
    }

    @Override
    protected View getMVPView() {
        return View.inflate(this, R.layout.activity_boon, null);
    }

    @Override
    protected void functionExtension() {
        setActivityTitle("福利");
        if (maxList == null)
            maxList = new ArrayList<>();
        initEvent();

        //监听RecyclerView滚动状态
        boonRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(recyclerView.getLayoutManager() != null) {
                    getPositionAndOffset();
                }
            }
        });
    }

    private void initEvent() {
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                isRefresh = true;
                page = 1;
                homePresenter.getGKData(ServiceUrl.gkBoonUrl + page);
            }
        });

        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                isRefresh = false;
                page++;
                homePresenter.getGKData(ServiceUrl.gkBoonUrl + page);
            }
        });
    }

    @Override
    public void succeed(String s) {
      //  Log.e("BoonActivity", s);

        BoonBean boonBean = new Gson().fromJson(s, BoonBean.class);
        List<BoonBean.ResultsBean> results = boonBean.getResults();

        if (isRefresh) {
            refreshLayout.finishRefresh();
            maxList.clear();
        }else
            refreshLayout.finishLoadmore();

        maxList.addAll(results);

        Log.e("maxList",maxList.size()+"");
        boonRecycler.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));
        BoonAdapter boonAdapter = new BoonAdapter(this, maxList);
        boonRecycler.setAdapter(boonAdapter);
        scrollToPosition();
    }

    @Override
    public void failure(String error) {
        Log.e("failure", "failure: " + error);
    }

    /**
     * 记录RecyclerView当前位置
     */
    private void getPositionAndOffset() {
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) boonRecycler.getLayoutManager();
        //获取可视的第一个view
        View topView = staggeredGridLayoutManager.getChildAt(0);
        if(topView != null) {
            //获取与该view的顶部的偏移量
            lastOffset = topView.getTop();
            //得到该View的数组位置
            lastPosition = staggeredGridLayoutManager.getPosition(topView);
        }
    }

    /**
     * 让RecyclerView滚动到指定位置
     */
    private void scrollToPosition() {
        if(boonRecycler.getLayoutManager() != null && lastPosition >= 0) {
            ((StaggeredGridLayoutManager) boonRecycler.getLayoutManager()).scrollToPositionWithOffset(lastPosition, lastOffset);
        }
    }

    @Override
    protected boolean isHideTitle() {
        return false;
    }
}
