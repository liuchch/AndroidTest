package com.example.liu.myapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;


public class NewTextView extends AppCompatTextView {


    Paint mPaint1, mPaint2;

    private int mViewWidth = 0;
    private int mTranslate = 0;
    private Paint mPaint;
    private LinearGradient mLinearGradient;
    private Matrix mGradientMatrix;

    public NewTextView(Context context) {
        this(context, null);
    }

    public NewTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint1);
//        canvas.drawRect(10, 10, getMeasuredWidth()-10, getMeasuredHeight()-10, mPaint2);
//        canvas.save();
//        canvas.translate(10, 0);

        super.onDraw(canvas);

        if (mGradientMatrix != null) {
            mTranslate += mViewWidth/5;
            if (mTranslate > mViewWidth*2) {
                mTranslate = -mViewWidth;
            }
            mGradientMatrix.setTranslate(mTranslate, 0);
            mLinearGradient.setLocalMatrix(mGradientMatrix);
            postInvalidateDelayed(100);
        }

//        canvas.restore();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mViewWidth == 0) {
            mViewWidth = getMeasuredWidth();
            if (mViewWidth > 0) {
                mPaint = getPaint();
                mLinearGradient = new LinearGradient(0 , 0, mViewWidth, 0,
                        new int[] {Color.BLUE, 0xffffffff, Color.BLUE}, null, Shader.TileMode.CLAMP);
                mPaint.setShader(mLinearGradient);
                mGradientMatrix = new Matrix();
            }
        }
    }



    void initPaint() {
        mPaint1 = new Paint();
        mPaint2 = new Paint();
        mPaint1.setColor(getResources().getColor(android.R.color.holo_blue_light));
        mPaint1.setStyle(Paint.Style.FILL);
        mPaint2.setColor(Color.YELLOW);
        mPaint2.setStyle(Paint.Style.FILL);


    }

}
