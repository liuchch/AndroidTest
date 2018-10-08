package com.example.liu.myapplication.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.liu.myapplication.R;

public class TopBar extends RelativeLayout {


    private Button mLeftButton, mRightButton;
    private TextView mTitleView;

    private LayoutParams mLeftParams, mTitleParams, mRightParams;

    private int mLeftTextColor;
    private Drawable mLeftBackground;
    private String mLeftText;

    private int mRightTextColor;
    private Drawable mRightBackground;
    private String mRightText;

    private float mTitleTextSize;
    private int mTitleTextColor;
    private String mTitle;



    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);


        setBackgroundColor(0xFFF59563);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        mLeftTextColor = ta.getColor(R.styleable.TopBar_leftTextColor, 0);
        mLeftBackground = ta.getDrawable(R.styleable.TopBar_leftBackground);
        mLeftText = ta.getString(R.styleable.TopBar_leftText);

        mRightText = ta.getString(R.styleable.TopBar_rightText);
        mRightTextColor = ta.getColor(R.styleable.TopBar_rightTextColor, 0);
        mRightBackground = ta.getDrawable(R.styleable.TopBar_rightBackground);

        mTitle = ta.getString(R.styleable.TopBar_title);
        mTitleTextSize = ta.getDimension(R.styleable.TopBar_titleTextSize, 10);
        mTitleTextColor = ta.getColor(R.styleable.TopBar_titleTextColor, 0);
        ta.recycle();

        mLeftButton = new Button(context);
        mRightButton = new Button(context);
        mTitleView = new TextView(context);

        mLeftButton.setText(mLeftText);
        mLeftButton.setTextColor(mLeftTextColor);
        mLeftButton.setBackground(mLeftBackground);

        mRightButton.setText(mRightText);
        mRightButton.setTextColor(mRightTextColor);
        mRightButton.setBackground(mRightBackground);

        mTitleView.setText(mTitle);
        mTitleView.setTextColor(mTitleTextColor);
        mTitleView.setTextSize(mTitleTextSize);
        mTitleView.setGravity(Gravity.CENTER);

        mLeftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        addView(mLeftButton, mLeftParams);

        mRightParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        addView(mRightButton, mRightParams);

        mTitleParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mTitleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(mTitleView, mTitleParams);


    }




}
