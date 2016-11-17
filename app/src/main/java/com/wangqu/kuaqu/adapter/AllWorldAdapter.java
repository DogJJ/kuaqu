package com.wangqu.kuaqu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.flexbox.FlexboxLayout;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.stx.xhb.xbanner.XBanner;
import com.wangqu.kuaqu.R;
import com.wangqu.kuaqu.response.AllWorldBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/7.
 */
public class AllWorldAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private AllWorldBean allWorldBean;
    private LayoutInflater layoutInflater;
    //    ImageLoader imageLoader;
    private ImageLoader imageLoader;
    DisplayImageOptions options;
    private View itemGoods = null;
    private View itemGroup = null;
    public static int ONE = 1;
    public static int TWO = 2;

    public void setAllWorldBean(AllWorldBean allWorldBean) {
        if (allWorldBean != null) {
            this.allWorldBean = allWorldBean;

        }
    }

    public AllWorldAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(context));
        options = new DisplayImageOptions.Builder()//option的设置
                .showImageOnLoading(R.mipmap.loading)
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .build();
        itemGoods = layoutInflater.inflate(R.layout.item_goods, null);
        itemGroup = layoutInflater.inflate(R.layout.item_all_world_two, null);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ONE) {
            return new ViewHolderOne(layoutInflater.inflate(R.layout.item_all_world_one, parent, false));
        } else {
            return new ViewHolderTwo(layoutInflater.inflate(R.layout.item_all_world_two, parent, false));
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolderOne) {
            final List<String> imagelist = new ArrayList<>();
            for (int i = 0, b = allWorldBean.getFlash().size(); i < b; i++) {
                imagelist.add(allWorldBean.getFlash().get(i).getImg());
            }
            ((ViewHolderOne) holder).xBanner.setData(imagelist, null);
            ((ViewHolderOne) holder).xBanner.setmAdapter(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, View view, int position) {
                    imageLoader.displayImage(imagelist.get(position), (ImageView) view, options);
                }
            });
            ((ViewHolderOne) holder).xBanner.setOnItemClickListener(new XBanner.OnItemClickListener() {
                @Override
                public void onItemClick(XBanner banner, int position) {

                }
            });
            for (int i = 0; i < allWorldBean.getHd().size(); i++) {
                ((ViewHolderOne) holder).huodong.addView(itemGroup, null);

            }
        }
    }

    @Override
    public int getItemCount() {
        if (allWorldBean != null) {
            return allWorldBean.getGoods().size() + 1;
        } else return 0;

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ONE;
        } else return TWO;
    }

    class ViewHolderOne extends RecyclerView.ViewHolder {
        HorizontalScrollView horizontalScrollView;
        XBanner xBanner;
        LinearLayout huodong;
        HorizontalScrollView huodonglist;
        FlexboxLayout special;
        ImageView brand;
        HorizontalScrollView brandlist;


        public ViewHolderOne(View itemView) {
            super(itemView);
            xBanner = (XBanner) itemView.findViewById(R.id.all_one_banner);
            huodong = (LinearLayout) itemView.findViewById(R.id.all_one_huodonglinear);
        }
    }

    class ViewHolderTwo extends RecyclerView.ViewHolder {
        ImageView goods;
        HorizontalScrollView goodsList;

        public ViewHolderTwo(View itemView) {
            super(itemView);
        }
    }
}
