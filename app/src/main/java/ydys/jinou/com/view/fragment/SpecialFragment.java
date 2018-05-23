package ydys.jinou.com.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ydys.jinou.com.R;
import ydys.jinou.com.model.bean.SpeciaBean;
import ydys.jinou.com.model.http.ServiceUrl;
import ydys.jinou.com.presenter.HomePresenter;
import ydys.jinou.com.view.adapter.SpecialAdapter;
import ydys.jinou.com.view.base.BaseFragment;


/**
 * author: 晨光光
 * date : 2018/5/16 20:34
 */
public class SpecialFragment extends BaseFragment<HomePresenter> {

    @BindView(R.id.recyle_view)
    RecyclerView recyleView;
    Unbinder unbinder;
    private String TAG = "HomeFragment";
    private HomePresenter homePresenter;

    @Override
    protected HomePresenter getPresenter() {
        homePresenter = new HomePresenter();
        return homePresenter;
    }

    @Override
    protected void initData() {
        recyleView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        Map<String, String> map = new HashMap<>();
        map.put("catalogId", "402834815584e463015584e539330016");
        map.put("pnum", "7");
        homePresenter.getData(ServiceUrl.specialUrl, map);
    }

    @Override
    protected int setBaseView() {
        return R.layout.special_fragment_layout;
    }

    @Override
    public void succeed(String s) {
        Log.e(TAG, "succeed: " + s);
        SpeciaBean speciaBean = new Gson().fromJson(s, SpeciaBean.class);
        List<SpeciaBean.RetBean.ListBean> list = speciaBean.getRet().getList();

        Log.d("SpecialFragment", "获取到专题集合-------" + list);

        SpecialAdapter specialAdapter = new SpecialAdapter(getActivity(), list);
        recyleView.setAdapter(specialAdapter);
    }

    @Override
    public void failure(String error) {
        Log.e(TAG, "error: " + error);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
