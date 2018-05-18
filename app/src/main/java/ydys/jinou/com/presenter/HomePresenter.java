package ydys.jinou.com.presenter;


import android.util.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import ydys.jinou.com.model.http.CommonModel;
import ydys.jinou.com.model.http.ServiceUrl;
import ydys.jinou.com.util.CommonUtil;
import ydys.jinou.com.view.callback.SimpleCallBack;

/**
 * author: 晨光光
 * date : 2018/5/16 20:35
 */
public class HomePresenter extends BasePresenter<SimpleCallBack<String>> {


    public void getData(String url, Map<String, String> map) {

        CommonModel.getApiService(ServiceUrl.baseUrl).doGet(url, map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            getView().succeed(string);
                        } catch (IOException e) {
                            getView().failure(e.toString());
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

    public void getGKData(String url) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                CommonUtil.runUiThread(new Runnable() {
                    @Override
                    public void run() {
                        getView().failure(e.toString());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
               final String string = response.body().string();
                CommonUtil.runUiThread(new Runnable() {
                    @Override
                    public void run() {
                        getView().succeed(string);
                    }
                });
            }
        });

    }

}
