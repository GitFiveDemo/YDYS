package ydys.jinou.com.view.activity;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import butterknife.BindView;
import ydys.jinou.com.R;
import ydys.jinou.com.model.http.ServiceUrl;
import ydys.jinou.com.presenter.HomePresenter;
import ydys.jinou.com.view.base.BaseMVPActivity;
import ydys.jinou.com.view.callback.SimpleCallBack;

public class BoonActivity extends BaseMVPActivity<HomePresenter> implements SimpleCallBack<String> {
    @BindView(R.id.boon_recycler)
    RecyclerView boonRecycler;

    @Override
    protected HomePresenter getPresenter() {
        HomePresenter homePresenter = new HomePresenter();
        homePresenter.getData(ServiceUrl.homeUrl, null);
        return homePresenter;
    }

    @Override
    protected View getMVPView() {
        View view = View.inflate(this, R.layout.activity_boon, null);
        return view;
    }

    @Override
    protected void functionExtension() {

    }

    @Override
    public void succeed(String s) {
        Log.e("succeed", "succeed: " + s);
    }

    @Override
    public void failure(String error) {
        Log.e("succeed", "succeed: " + error);
    }

    @Override
    protected boolean isHideTitle() {
        return false;
    }
}
