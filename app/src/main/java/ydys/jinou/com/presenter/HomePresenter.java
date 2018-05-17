package ydys.jinou.com.presenter;


import java.io.IOException;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import ydys.jinou.com.model.http.CommonModel;
import ydys.jinou.com.view.callback.SimpleCallBack;

/**
 * author: 晨光光
 * date : 2018/5/16 20:35
 */
public class HomePresenter extends BasePresenter<SimpleCallBack<String>> {


    public void getData(String url, Map<String,String>map) {

        CommonModel.getApiService().doGet(url,map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String json = responseBody.string();
                            getView().succeed(json);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().failure(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}