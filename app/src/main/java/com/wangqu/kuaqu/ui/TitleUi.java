package com.wangqu.kuaqu.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wangqu.kuaqu.R;


/**
 * Created by 田园犬。 on 2016/9/13.
 */
public class TitleUi extends RelativeLayout implements View.OnClickListener {
    private TextView mTextView;
    private ImageView mImageView;
    private boolean isVisiable;
    private String titleText;

    public TitleUi(Context context) {
        this(context, null);
    }

    public TitleUi(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleUi(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleUi, defStyleAttr, 0);
        titleText = typedArray.getString(R.styleable.TitleUi_titleText);
        mTextView.setText(titleText);
        isVisiable = typedArray.getBoolean(R.styleable.TitleUi_backVisiable, true);
        if (isVisiable) {
            mImageView.setVisibility(VISIBLE);
        } else {
            mImageView.setVisibility(GONE);
        }
        typedArray.recycle();

    }

    private void init(Context context) {
        View.inflate(context, R.layout.title_bar, this);
        mTextView = (TextView) findViewById(R.id.title_text);
        mImageView = (ImageView) findViewById(R.id.title_back);
        mImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mImageView) {
            ((AppCompatActivity) getContext()).finish();
        }
    }

}
