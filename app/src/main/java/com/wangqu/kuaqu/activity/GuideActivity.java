package com.wangqu.kuaqu.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.WindowManager;

import com.igexin.sdk.PushManager;
import com.wangqu.kuaqu.R;
import com.wangqu.kuaqu.app.App;
import com.wangqu.kuaqu.http.HttpUtil;
import com.wangqu.kuaqu.response.Loginbean;
import com.wangqu.kuaqu.util.SharedPreferencesUtil;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/9/23.
 */
public class GuideActivity extends BaseActivity {
    private final int GO_LOGIN = 1;
    private final int GO_HOME = 2;
    private String username, password, ifLogin;
    private final int SPLASH_DELAY_MILLIS = 2000;
    private PushManager pushManager;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Intent intent = new Intent();
            switch (msg.what) {
                case GO_LOGIN:
                    goLogin();
                    break;
                case GO_HOME:
                    goHome();
                    break;


            }


            super.handleMessage(msg);
        }


    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        }

        pushManager = PushManager.getInstance();
        pushManager.initialize(this.getApplicationContext());
//        PushManager.getInstance().initialize(this.getApplicationContext());
        String clientId = SharedPreferencesUtil.getString(App.getInstance(), App.clientId);
//        String id = pushManager.getClientid(this);
//
//        if (isEmpty(clientId)) {
//            SharedPreferencesUtil.put(App.getInstance(), App.clientId, id);
//        }
//        while (isEmpty(id)) {
//            id = pushManager.getClientid(this);
//            System.out.println("id-->" );
//
//        }
        init();

    }

    private void init() {
        ifLogin = SharedPreferencesUtil.getString(App.getInstance(), App.iflogin);
        username = SharedPreferencesUtil.getString(App.getInstance(), App.username);
        password = SharedPreferencesUtil.getString(App.getInstance(), App.password);
        if ("1".equals(ifLogin) && !isEmpty(username) && !isEmpty(password)) {
            handler.sendEmptyMessageDelayed(GO_HOME, SPLASH_DELAY_MILLIS);

        } else {
            handler.sendEmptyMessageDelayed(GO_LOGIN, SPLASH_DELAY_MILLIS);
        }

    }

    private void goLogin() {
        Intent intent = new Intent();
        intent.setClass(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void goHome() {
        HttpUtil.getService.Login(username, password, SharedPreferencesUtil.getString(App.getInstance(), App.clientId)).enqueue(new Callback<Loginbean>() {
            @Override
            public void onResponse(Call<Loginbean> call, Response<Loginbean> response) {
                if (isEmpty(SharedPreferencesUtil.getString(App.getInstance(), App.sidKey))) {
                    String sid = getSessionCookie(response.headers().get(App.sidKey));
                    SharedPreferencesUtil.put(App.getInstance(), App.sidKey, sid);
                }
                if (response.body().getResult().equals("1")) {
                    SharedPreferencesUtil.put(App.getInstance(), App.iflogin, "1");
                    Intent intent = new Intent(GuideActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    SharedPreferencesUtil.put(App.getInstance(), App.iflogin, "2");
                    showToastMessage(response.body().getMsg());
                    goLogin();
                }
            }

            @Override
            public void onFailure(Call<Loginbean> call, Throwable t) {

            }
        });

    }

    public static String getSessionCookie(String cookieString) {
        if (!TextUtils.isEmpty(cookieString)) {
            String[] splitCookie = cookieString.split(";");
            String[] splitSessionId = splitCookie[0].split("=");
            cookieString = splitSessionId[1];
            return cookieString;
        }
        return "";
    }


}
