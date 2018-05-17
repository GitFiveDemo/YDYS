package ydys.jinou.com.model.http;


import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * author: 晨光光
 * date : 2018/5/16 22:54
 */
public interface APIService {
    @GET("{url}")
    Observable<ResponseBody> doGet(@Path(value = "url", encoded = true) String url);

    @GET("{url}")
    Observable<ResponseBody> doGet(@Path(value = "url", encoded = true) String url, @QueryMap Map<String, String> map);

    @POST("{url}")
    Observable<ResponseBody> doPost(@Path(value = "url", encoded = true) String url);

    @POST("{url}")
    Observable<ResponseBody> doPost(@Path(value = "url", encoded = true) String url, @FieldMap Map<String, String> map);
}
