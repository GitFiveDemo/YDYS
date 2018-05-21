package ydys.jinou.com.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import ydys.jinou.com.R;
import ydys.jinou.com.model.bean.HomeBean;
import ydys.jinou.com.model.http.ServiceUrl;
import ydys.jinou.com.presenter.HomePresenter;
import ydys.jinou.com.view.adapter.HomeAdapter;
import ydys.jinou.com.view.adapter.HomesAdapter;
import ydys.jinou.com.view.adapter.HomessAdapter;
import ydys.jinou.com.view.base.BaseFragment;

public class Home_JJ_Fragment extends BaseFragment<HomePresenter> {
    private static final String TAG = "ssssssssss";
    @BindView(R.id.daoyan)
    TextView daoyan;
    @BindView(R.id.zhuyan)
    TextView zhuyan;
    @BindView(R.id.zhankai)
    TextView zhankai;
    @BindView(R.id.jianjie)
    TextView jianjie;
    @BindView(R.id.three)
    LinearLayout three;
    @BindView(R.id.messagemovies)
    RecyclerView messagemovies;
    Unbinder unbinder;

    private HomesAdapter homeAdapter;
    private HomePresenter homePresenter;

    @Override
    protected HomePresenter getPresenter() {
        homePresenter = new HomePresenter();
        homePresenter.getData(ServiceUrl.homeUrl,null);
        return homePresenter;
    }

    @Override
    protected void initData() {
        String jian= getActivity().getIntent().getStringExtra("jianjie");
        jianjie.setText(jian);

    }

    @Override
    protected int setBaseView() {
        return R.layout.jianjie_tab_lyout;
    }

    @Override
    public void succeed(String s) {
        HomeBean homeBean = new Gson().fromJson(s, HomeBean.class);
        List<HomeBean.RetBean.ListBean.ChildListBean> childList = homeBean.getRet().getList().get(0).getChildList();
        Log.e(TAG, "succeedssssssssssssssss: "+childList );
        homeAdapter = new HomesAdapter(getActivity(), childList);
        messagemovies.setAdapter(homeAdapter);
        messagemovies.setLayoutManager(new GridLayoutManager(getActivity(),3));
        messagemovies.setNestedScrollingEnabled(false);

    }

    @Override
    public void failure(String error) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.zhankai)
    public void onViewClicked() {
        if (three.getVisibility()== View.VISIBLE){
            three.setVisibility(View.GONE);
        }else{
            three.setVisibility(View.VISIBLE);
        }
    }
}
