package com.wangqu.kuaqu.app;

import android.app.Application;

/**
 * Created by 田园犬。 on 2016/6/15.
 */
public class App extends Application {
    public static String sidKey = "Set-Cookie";
    public static App app;
    public static String username = "username";
    public static String password = "password";
    public static String iflogin = "iflogin";
    public static String clientId = "clientId";
    public static String latitude = "latitude";
    public static String longtitude = "longtitude";

    public static App getInstance() {
        return app;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}
