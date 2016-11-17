package com.wangqu.kuaqu.service;

import com.wangqu.kuaqu.response.AllWorldBean;
import com.wangqu.kuaqu.response.Loginbean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 田园犬。 on 2016/6/14.
 */
public interface MyService {
    @FormUrlEncoded
    @POST("app.php?r=index/index")
    Call<AllWorldBean> allWorld(@Field("lat") String lat, @Field("lon") String lon);
    @FormUrlEncoded
    @POST("sjapp.php?r=login/index")
    Call<Loginbean> Login(@Field("username") String username, @Field("password") String password, @Field("device") String device);


}
