package ydys.jinou.com.view.fragment;


import android.util.Log;
import android.view.View;

import java.util.HashMap;

import butterknife.OnClick;
import ydys.jinou.com.R;
import ydys.jinou.com.model.http.ServiceUrl;
import ydys.jinou.com.presenter.HomePresenter;
import ydys.jinou.com.view.base.BaseFragment;


/**
 * author: 晨光光
 * date : 2018/5/16 20:34
 */
public class SpecialFragment extends BaseFragment<HomePresenter> {

    private String TAG = "HomeFragment";
    private HomePresenter homePresenter;

    @Override
    protected HomePresenter getPresenter() {
        homePresenter = new HomePresenter();
        return homePresenter;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int setBaseView() {
        return R.layout.home_fragment_layout;
    }

    @Override
    public void succeed(String s) {
        Log.e(TAG, "succeed: "+s );
    }

    @Override
    public void failure(String error) {
        Log.e(TAG, "error: "+error);
    }

    @OnClick({R.id.click_but})
    public void click(View view){
        switch (view.getId()){
            case R.id.click_but:
                HashMap<String, String> map = new HashMap<>();
                map.put("page","1");
                homePresenter.getData(ServiceUrl.homeUrl,map);
                break;
        }
    }
}
