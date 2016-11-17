package com.wangqu.kuaqu.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.wangqu.kuaqu.util.ActivityManager;

/**
 * Created by 田园犬。 on 2016/9/13.
 */
public class BaseActivity extends AppCompatActivity {
    private Toast toast;
    private ImageLoader imageLoader;
    private DisplayImageOptions options;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().pushOneActivity(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (null != this.getCurrentFocus()) {
            InputMethodManager manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            return manager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);

        }

        return super.onTouchEvent(event);
    }

    public boolean isEmpty(String string) {
        if (string == "" || string == null) {
            return true;
        } else {
            return false;
        }
    }

    public void showToastMessage(String msg) {
        if (msg == null) {
            return;
        }
        if (toast == null) {
//            toast=new Toast(this);
            toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        } else {

            toast.setText(msg);
            toast.setDuration(Toast.LENGTH_SHORT);
//            toast.cancel();
        }
        toast.show();
//        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void displayImage(String url, ImageView imageView) {
        if (imageLoader == null) {
            imageLoader = ImageLoader.getInstance();
            imageLoader.init(ImageLoaderConfiguration.createDefault(this));
        }
        if (options == null) {
            options = new DisplayImageOptions.Builder()//option的设置
                    .cacheOnDisk(true)
                    .cacheInMemory(true)
                    .build();
        }
        imageLoader.displayImage(url, imageView, options);
    }


}
