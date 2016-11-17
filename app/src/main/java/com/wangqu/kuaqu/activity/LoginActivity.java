package com.wangqu.kuaqu.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.roger.catloadinglibrary.CatLoadingView;
import com.wangqu.kuaqu.R;
import com.wangqu.kuaqu.app.App;
import com.wangqu.kuaqu.http.HttpUtil;
import com.wangqu.kuaqu.response.Loginbean;
import com.wangqu.kuaqu.util.SharedPreferencesUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/11/2.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private EditText username;
    private EditText password;
    private TextView login;
    private CatLoadingView loadingView;
    private String name;
    private String code;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        }
        initView();
    }

    private void initView() {
        loadingView = new CatLoadingView();
        username = (EditText) findViewById(R.id.login_username);
        password = (EditText) findViewById(R.id.login_password);
        login = (TextView) findViewById(R.id.login_login);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_login:
                name = username.getText().toString();
                code = password.getText().toString();
                if (isEmpty(name) || isEmpty(code)) {
                    showToastMessage("请输入正确的用户名密码");
                    return;
                }
                loadingView.show(getSupportFragmentManager(), "");
                HttpUtil.getService.Login(name, code, SharedPreferencesUtil.getString(App.getInstance(), App.clientId)).enqueue(new Callback<Loginbean>() {
                    @Override
                    public void onResponse(Call<Loginbean> call, Response<Loginbean> response) {
                        loadingView.dismiss();
                        if (isEmpty(SharedPreferencesUtil.getString(App.getInstance(), App.sidKey))) {
                            String sid = getSessionCookie(response.headers().get(App.sidKey));
                            SharedPreferencesUtil.put(App.getInstance(), App.sidKey, sid);
                        }
                        if (response.body().getResult().equals("1")) {
                            SharedPreferencesUtil.put(App.getInstance(), App.username, name);
                            SharedPreferencesUtil.put(App.getInstance(), App.password, code);
                            SharedPreferencesUtil.put(App.getInstance(), App.iflogin, "1");
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            SharedPreferencesUtil.put(App.getInstance(), App.iflogin, "2");
                            showToastMessage(response.body().getMsg());
                        }
                    }

                    @Override
                    public void onFailure(Call<Loginbean> call, Throwable t) {

                    }
                });

                break;

        }
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
