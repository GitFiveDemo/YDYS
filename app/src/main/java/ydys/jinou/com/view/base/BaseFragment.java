package ydys.jinou.com.view.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import ydys.jinou.com.presenter.BasePresenter;
import ydys.jinou.com.view.callback.SimpleCallBack;

/**
 * author: 晨光光
 * date : 2018/5/16 19:56
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements SimpleCallBack<String> {

    private P presenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setBaseView(),container,false);
        P p = getPresenter();

        if (p == null)
            throw new NullPointerException("presenter is null");

        presenter = p;
        p.attachView(this);

        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract P getPresenter();

    protected abstract void initData();

    protected abstract int setBaseView();

    @Override
    public void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }
}
