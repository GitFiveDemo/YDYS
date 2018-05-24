package ydys.jinou.com.view.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import butterknife.BindView;
import ydys.jinou.com.R;
import ydys.jinou.com.model.cache.CollectCacheBean;
import ydys.jinou.com.model.db.CollectCacheBeanDao;
import ydys.jinou.com.util.SQLiteHelper;
import ydys.jinou.com.view.adapter.CollectAdapter;
import ydys.jinou.com.view.base.BaseActivity;

public class CollectActivity extends BaseActivity {

    @BindView(R.id.collect_recycler)
    RecyclerView recyclerView;
    @Override
    protected void initView() {
        setActivityTitle("我收藏");
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }

    @Override
    protected void initDate() {

    }

    @Override
    protected View getChildView() {
        return View.inflate(this, R.layout.activity_collect,null);
    }

    @Override
    protected boolean isHideTitle() {
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        CollectCacheBeanDao collectCacheBeanDao = SQLiteHelper.getIntance(this).getDaoSession().getCollectCacheBeanDao();
        List<CollectCacheBean> collectCacheBeans = collectCacheBeanDao.loadAll();
        CollectAdapter collectAdapter = new CollectAdapter(this, collectCacheBeans);
        recyclerView.setAdapter(collectAdapter);
    }
}
