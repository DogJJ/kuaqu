package com.wangqu.kuaqu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wangqu.kuaqu.R;

/**
 * Created by Administrator on 2016/11/4.
 */
public class Fragment_shop extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            return inflater.inflate(R.layout.fragment_shop, container, false);
        }
        return view;
    }
}
