package ydys.jinou.com.view.callback;

/**
 * author: 晨光光
 * date : 2018/5/16 19:57
 */
public interface SimpleCallBack<V> {
    void succeed(V v);
    void failure(String error);
}
