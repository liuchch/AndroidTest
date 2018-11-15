package com.example.liu.myapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.liu.myapplication.R;

public class RectListView extends View {


    private int mMesureWidth, mMesureHeight;
    private int mArcNum;

    private Paint mPaintRact, mPaintText;


    public RectListView(Context context) {
        this(context, null);
    }

    public RectListView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RectListView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaintRact = new Paint();
        mPaintRact.setColor(getResources().getColor(R.color.colorAccent));
        mPaintText = new Paint();
        mPaintText.setColor(getResources().getColor(R.color.colorPrimary));
        mPaintText.setTextSize(50);
        mArcNum = 5;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        mMesureWidth = MeasureSpec.getSize(widthMeasureSpec);
        mMesureHeight = MeasureSpec.getSize(heightMeasureSpec);
//        setMeasuredDimension(mMesureWidth, mMesureHeight);
    }




    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.translate(0, mMesureHeight);
        canvas.scale(1, -1);

        for (int i = 0; i<3; i++) {
            canvas.drawRect(0, mMesureHeight/2, mMesureWidth/5,  0, mPaintRact);
            canvas.translate(mMesureWidth/4, 0);
        }

        canvas.restore();
        canvas.drawText("123456789", 0, 50, mPaintText);

    }
}
