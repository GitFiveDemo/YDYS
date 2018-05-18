package ydys.jinou.com.view.base;

import android.view.View;

import ydys.jinou.com.presenter.BasePresenter;
import ydys.jinou.com.view.callback.SimpleCallBack;

/**
 * author: 晨光光
 * date : 2018/5/18 10:51
 */
public abstract class BaseMVPActivity<T extends BasePresenter> extends BaseActivity implements SimpleCallBack<String> {

    private T presenter;

    @Override
    protected void initView() {
        presenter = getPresenter();

        if (presenter == null)
            throw new NullPointerException("网络请求,需要传入Presenter");

        // 关联接口回调
        presenter.attachView(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 解除关联
        if (presenter != null)
            presenter.detachView();
    }

    @Override
    protected void initDate() {
        functionExtension();
    }

    @Override
    protected View getChildView() {
        return getMVPView();
    }

    /**
     * @return presenter
     */
    protected abstract T getPresenter();

    /**
     * @return layout view
     */
    protected abstract View getMVPView();

    /**
     * 功能扩展
     */
    protected abstract void functionExtension();
}
