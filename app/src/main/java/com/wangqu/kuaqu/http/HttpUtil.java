package com.wangqu.kuaqu.http;

import com.wangqu.kuaqu.app.App;
import com.wangqu.kuaqu.service.MyService;
import com.wangqu.kuaqu.util.SharedPreferencesUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 田园犬。 on 2016/6/14.
 */
public class HttpUtil {
    static OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            String sid = SharedPreferencesUtil.getString(App.getInstance(), App.sidKey);
            if (sid!=null&&!"".equals(sid)) {
                request = request.newBuilder().header("Cookie","PHPSESSID=" +sid).build();

            }
            Response response = chain.proceed(request);
            return response;
        }
    }).build();

    private static final Retrofit retrofit = new Retrofit.Builder().client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//新的配置
            .baseUrl("http://m.kuaqu.hk/")
            .build();


    public static final MyService getService = retrofit.create(MyService.class);

}
