package com.wangqu.kuaqu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.wangqu.kuaqu.R;
import com.wangqu.kuaqu.activity.BaseActivity;
import com.wangqu.kuaqu.activity.MainActivity;
import com.wangqu.kuaqu.adapter.AllWorldAdapter;
import com.wangqu.kuaqu.app.App;
import com.wangqu.kuaqu.http.HttpUtil;
import com.wangqu.kuaqu.response.AllWorldBean;
import com.wangqu.kuaqu.util.SharedPreferencesUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/11/4.
 */
public class Fragment_all_world extends BaseFragment {
    private View view;
    private SwipeRefreshLayout swipe;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private AllWorldAdapter adapter;
    private HorizontalScrollView horizontalScrollView;
    private AllWorldBean allWorldBean;
    private LinearLayout.LayoutParams params;
    private LinearLayout linearLayout;

    //    private LocationClient locationClient = null;
//    private BDLocationListener myListener = new MyLocationListener();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_all_world, container, false);
        }
        initview();
        initData();
        return view;

    }

    private void initData() {
        HttpUtil.getService.allWorld("", "").enqueue(new Callback<AllWorldBean>() {
            @Override
            public void onResponse(Call<AllWorldBean> call, Response<AllWorldBean> response) {
                System.out.println(response.body() + "");
                if ("1".equals(response.body().getResult())) {
                    adapter.setAllWorldBean(response.body());
                    adapter.notifyDataSetChanged();
                    System.out.println(response.body().getFlash().get(0).getImg());
                    for (int i = 0; i < response.body().getCate().size(); i++) {
                        TextView text = new TextView(getContext());
                        text.setText(response.body().getCate().get(i).getName());
                        text.setTextSize(15);
                        text.setPadding(36, 0, 0, 0);
                        text.setTextColor(getContext().getResources().getColor(R.color.word));
                        text.setGravity(Gravity.CENTER);
//                        final int positon = i;
//                        text.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                Intent intent = new Intent(allWorldBean, ClassicalActivity.class);
//                                Bundle bundle = new Bundle();
//                                bundle.putSerializable("shopBean", shopBeen);
//                                intent.putExtras(bundle);
//                                intent.putExtra("position", positon);
//                                intent.putExtra("title", "商品分类");
//                                context.startActivity(intent);
//                            }
//                        });
                        params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                        linearLayout.addView(text, params);
                    }

                } else {

                }

            }

            @Override
            public void onFailure(Call<AllWorldBean> call, Throwable t) {

            }

        });
    }


    private void initview() {
        swipe = (SwipeRefreshLayout) view.findViewById(R.id.all_world_swipe);
        recyclerView = (RecyclerView) view.findViewById(R.id.all_world_recycler);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new AllWorldAdapter(getActivity());

        linearLayout= (LinearLayout) view.findViewById(R.id.all_world_linear);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
//        locationClient = new LocationClient(getActivity().getApplicationContext());
//        locationClient.registerLocationListener(myListener);
//        initLocation();
//        locationClient.start();
    }
//    private void initLocation() {
//        LocationClientOption option = new LocationClientOption();
//        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy
//        );//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
//        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
//        int span = 1000;
//        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
//        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
//        option.setOpenGps(true);//可选，默认false,设置是否使用gps
//        option.setLocationNotify(true);//可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果
//        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
//        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
//        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
//        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
//        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤GPS仿真结果，默认需要
//        locationClient.setLocOption(option);
//    }
//    public class MyLocationListener implements BDLocationListener {
//
//        @Override
//        public void onReceiveLocation(BDLocation bdLocation) {
//            locationClient.stop();
//            SharedPreferencesUtil.put(App.getInstance(), App.latitude, bdLocation.getLatitude() + "");
//            SharedPreferencesUtil.put(App.getInstance(), App.longtitude, bdLocation.getLongitude() + "");
//
//
//        }
//    }
}
