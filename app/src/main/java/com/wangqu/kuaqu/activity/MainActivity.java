package com.wangqu.kuaqu.activity;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.wangqu.kuaqu.R;
import com.wangqu.kuaqu.app.App;
import com.wangqu.kuaqu.fragment.Fragment_all_world;
import com.wangqu.kuaqu.http.HttpUtil;
import com.wangqu.kuaqu.response.AllWorldBean;
import com.wangqu.kuaqu.util.SharedPreferencesUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private Fragment[] fragments;
    private TextView allWorld, kind, shop, cart, mine;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Drawable one, two, three, four, five, six, seven, eight, nine, ten;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }



    private void initView() {
        one = getResources().getDrawable(R.mipmap.all_world);
        two = getResources().getDrawable(R.mipmap.all_world_selete);
        three = getResources().getDrawable(R.mipmap.kind);
        four = getResources().getDrawable(R.mipmap.kind_selete);
        five = getResources().getDrawable(R.mipmap.shop);
        six = getResources().getDrawable(R.mipmap.shop_selete);
        seven = getResources().getDrawable(R.mipmap.cart);
        eight = getResources().getDrawable(R.mipmap.cart_selete);
        nine = getResources().getDrawable(R.mipmap.mine);
        ten = getResources().getDrawable(R.mipmap.mine_selete);
        one.setBounds(0, 0, one.getMinimumWidth(), one.getMinimumHeight());
        two.setBounds(0, 0, two.getMinimumWidth(), two.getMinimumHeight());
        three.setBounds(0, 0, three.getMinimumWidth(), three.getMinimumHeight());
        four.setBounds(0, 0, four.getMinimumWidth(), four.getMinimumHeight());
        five.setBounds(0, 0, five.getMinimumWidth(), five.getMinimumHeight());
        six.setBounds(0, 0, six.getMinimumWidth(), six.getMinimumHeight());
        seven.setBounds(0, 0, seven.getMinimumWidth(), seven.getMinimumHeight());
        eight.setBounds(0, 0, eight.getMinimumWidth(), eight.getMinimumHeight());
        nine.setBounds(0, 0, nine.getMinimumWidth(), nine.getMinimumHeight());
        ten.setBounds(0, 0, ten.getMinimumWidth(), ten.getMinimumHeight());
        allWorld = (TextView) findViewById(R.id.main_all_world);
        kind = (TextView) findViewById(R.id.main_kind);
        shop = (TextView) findViewById(R.id.main_shop);
        cart = (TextView) findViewById(R.id.main_cart);
        mine = (TextView) findViewById(R.id.main_mine);
        allWorld.setOnClickListener(this);
        kind.setOnClickListener(this);
        shop.setOnClickListener(this);
        cart.setOnClickListener(this);
        mine.setOnClickListener(this);
        fragments = new Fragment[5];
        fragmentManager = getSupportFragmentManager();
        fragments[0] = fragmentManager.findFragmentById(R.id.fragment_all_world);
        fragments[1] = fragmentManager.findFragmentById(R.id.fragment_kind);
        fragments[2] = fragmentManager.findFragmentById(R.id.fragment_shop);
        fragments[3] = fragmentManager.findFragmentById(R.id.fragment_cart);
        fragments[4] = fragmentManager.findFragmentById(R.id.fragment_mine);
        fragmentTransaction = fragmentManager.beginTransaction().hide(fragments[0]).hide(fragments[1]).hide(fragments[2]).hide(fragments[3]).hide(fragments[4]);
        allWorld.performClick();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_all_world:
                resetbottom();
                allWorld.setCompoundDrawables(null, two, null, null);
                allWorld.setTextColor(getResources().getColor(R.color.word));
                fragmentTransaction.show(fragments[0]).commit();
                break;
            case R.id.main_kind:
                resetbottom();
                kind.setCompoundDrawables(null, four, null, null);
                kind.setTextColor(getResources().getColor(R.color.word));
                fragmentTransaction.show(fragments[1]).commit();
                break;
            case R.id.main_shop:
                resetbottom();
                shop.setCompoundDrawables(null, six, null, null);
                shop.setTextColor(getResources().getColor(R.color.word));
                fragmentTransaction.show(fragments[2]).commit();
                break;
            case R.id.main_cart:
                resetbottom();
                cart.setCompoundDrawables(null, eight, null, null);
                cart.setTextColor(getResources().getColor(R.color.word));
                fragmentTransaction.show(fragments[3]).commit();
                break;
            case R.id.main_mine:
                resetbottom();
                mine.setCompoundDrawables(null, ten, null, null);
                mine.setTextColor(getResources().getColor(R.color.word));
                fragmentTransaction.show(fragments[4]).commit();
                break;
        }
    }

    private void resetbottom() {
        fragmentTransaction = fragmentManager.beginTransaction().hide(fragments[0]).hide(fragments[1]).hide(fragments[2]).hide(fragments[3]).hide(fragments[4]);
        allWorld.setCompoundDrawables(null, one, null, null);
        kind.setCompoundDrawables(null, three, null, null);
        shop.setCompoundDrawables(null, five, null, null);
        cart.setCompoundDrawables(null, seven, null, null);
        mine.setCompoundDrawables(null, nine, null, null);
        allWorld.setTextColor(getResources().getColor(R.color.hint));
        kind.setTextColor(getResources().getColor(R.color.hint));
        shop.setTextColor(getResources().getColor(R.color.hint));
        cart.setTextColor(getResources().getColor(R.color.hint));
        mine.setTextColor(getResources().getColor(R.color.hint));

    }



}
