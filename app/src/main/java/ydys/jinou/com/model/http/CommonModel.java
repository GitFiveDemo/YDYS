package ydys.jinou.com.model.http;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author: 晨光光
 * date : 2018/5/16 22:53
 */
public class CommonModel {

    private static APIService apiService;

    public static APIService getApiService() {
        if (apiService == null) {
            synchronized (CommonModel.class) {
              //  HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(new LoggerInterceptor());
              //  logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

                if (apiService == null) {
                    OkHttpClient client = new OkHttpClient.Builder()
                          //  .addInterceptor(new MyInterceptor())
                           // .addNetworkInterceptor(logInterceptor)
                            .build();

                    apiService = new Retrofit.Builder()
                            .baseUrl(ServiceUrl.baseUrl)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .client(client)
                            .build().create(APIService.class);
                }
            }
        }
        return apiService;
    }

    static class MyInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {

            Request request = chain.request();
            /*String method = request.method();

            // 获取公共参数
            SharedUtil sharedUtil = SharedUtil.getInstance();
            String token = sharedUtil.obtainString("token");

            // 判断请求类型
            if ("POST".equals(method)) {
                // 判断body类型
                RequestBody requestBody = request.body();
                if (requestBody instanceof FormBody) {
                    FormBody formBody = (FormBody) requestBody;
                    FormBody.Builder builder = new FormBody.Builder();
                    for (int i = 0; i < formBody.size(); i++) {
                        builder.add(formBody.name(i), formBody.value(i));
                    }
                    // 添加公共参数
                    builder.add("appVersion", "101");
                    builder.add("source", "android");
                    builder.add("token", token);
                    request = request.newBuilder().post(builder.build()).build();
                } else if (requestBody instanceof MultipartBody) {
                    MultipartBody multipartBody = (MultipartBody) requestBody;
                    // 获取到parts
                    List<MultipartBody.Part> parts = multipartBody.parts();

                    MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
                    // 添加公共参数
                    builder.addFormDataPart("appVersion", "101");
                    builder.addFormDataPart("source", "android");
                    builder.addFormDataPart("token", token);

                    for (int i = 0; i < parts.size(); i++) {
                        builder.addPart(parts.get(i));
                    }

                    request = request.newBuilder().post(builder.build()).build();

                } else {
                    // nothing
                }

            } else if ("GET".equals(method)) {
                HttpUrl.Builder builder = request.url().newBuilder();
                // 添加公共参数
                builder.addQueryParameter("appVersion", "101");
                builder.addQueryParameter("source", "android");
                builder.addQueryParameter("token", token);
                request = request.newBuilder().url(builder.build()).build();
            } else {
                // nothing
            }*/



            return chain.proceed(request);
        }
    }
}
