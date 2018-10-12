package com.example.liu.myapplication.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.liu.myapplication.R;

public class CircleProgressView extends View {


    private int mMesureHeigth;
    private int mMesureWidth;

    private float mCircleXY;
    private float mRadius;

    private Paint mCirclePaint;




    private Paint mArcPaint;
    private RectF mArcRectF;
    private float mSweepAngle;

    private Paint mTextPaint;
    private String mShowText;
    private float mShowTextSize;

    public CircleProgressView(Context context) {
        this(context, null);
    }

    public CircleProgressView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CircleProgressView);
        mSweepAngle = ta.getFloat(R.styleable.CircleProgressView_SweepAngleValue, 0);
        ta.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mMesureWidth = MeasureSpec.getSize(widthMeasureSpec);
        mMesureHeigth = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(mMesureWidth, mMesureHeigth);
        initView();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制圆
        canvas.drawCircle(mCircleXY, mCircleXY, mRadius, mCirclePaint);
        //绘制弧线
        canvas.drawArc(mArcRectF, 0, mSweepAngle, false, mArcPaint);
        //绘制文字
        canvas.drawText(mShowText, 0, mShowText.length(), mCircleXY, mCircleXY + (mShowTextSize/4), mTextPaint);
    }

    private void initView() {
        float length = 0;
        length = Math.min(mMesureHeigth, mMesureWidth);

        mCircleXY = length/2;
        mRadius = (float) (length*0.5/2);

        mCirclePaint = new Paint();
        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setColor(getResources().getColor(android.R.color.holo_blue_bright));
        mArcRectF = new RectF(
                (float) (length*0.1),
                (float) (length*0.1),
                (float) (length*0.9),
                (float) (length*0.9));


        mArcPaint = new Paint();
        mArcPaint.setAntiAlias(true);
        mArcPaint.setColor(getResources().getColor(
                android.R.color.holo_blue_bright));
        mArcPaint.setStrokeWidth((float) (length * 0.1));
        mArcPaint.setStyle(Paint.Style.STROKE);


        mShowText = setShowText();
        mShowTextSize = setShowTextSize();
        mTextPaint = new Paint();
        mTextPaint.setTextSize(mShowTextSize);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
    }

    private String setShowText() {
        this.invalidate();
        return "Android Skill";
    }

    private float setShowTextSize() {
        this.invalidate();
        return 50;
    }

    public void forceInvalidate() {
        this.invalidate();
    }

}
