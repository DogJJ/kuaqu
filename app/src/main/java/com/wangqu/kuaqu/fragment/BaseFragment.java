package com.wangqu.kuaqu.fragment;

import android.support.v4.app.Fragment;
import android.widget.ImageView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Administrator on 2016/9/23.
 */
public class BaseFragment extends Fragment {
    private Toast toast;
    private ImageLoader imageLoader;
    private DisplayImageOptions options;
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
            toast = Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT);
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
            imageLoader.init(ImageLoaderConfiguration.createDefault(getActivity()));
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
