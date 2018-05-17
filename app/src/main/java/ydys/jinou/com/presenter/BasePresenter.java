package ydys.jinou.com.presenter;


import ydys.jinou.com.view.callback.SimpleCallBack;

/**
 * author: 晨光光
 * date : 2018/5/16 20:02
 */
public abstract class BasePresenter<T extends SimpleCallBack > {
    private T t;

    public void attachView(T t) {
        this.t = t;
    }


    public void detachView(){
       t = null;
    }

    public T getView() {
        return t;
    }

    public void setHttpUtl(String url){

    }
}
