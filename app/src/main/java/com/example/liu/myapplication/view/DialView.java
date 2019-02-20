package com.example.liu.myapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.liu.myapplication.R;

import java.security.MessageDigest;

public class DialView extends View {


    private Paint paintCircle;
    private int mWidth;
    private int mHeight;
    private Paint paintDegree;
    private int radius;


    public DialView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeight = MeasureSpec.getSize(heightMeasureSpec);
        radius = mWidth/2-10;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawCircle(150,150,100,paint);

        canvas.saveLayerAlpha(0,0,600,600,127,Canvas.ALL_SAVE_FLAG);
        paint.setColor(Color.RED);
        canvas.drawCircle(200,200,100,paint);
        canvas.restore();
        canvas.saveLayerAlpha(0,0,600,600,127,Canvas.ALL_SAVE_FLAG);
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(50,50,100,paint);
        canvas.restore();

//        drawCircle(canvas);
//        drawDegree(canvas);
//        drawPointer(canvas);
    }

    private void drawCircle(Canvas canvas) {
        paintCircle = new Paint();
        paintCircle.setStyle(Paint.Style.STROKE);
        paintCircle.setAntiAlias(true);
        paintCircle.setStrokeWidth(5);

        canvas.drawCircle(mWidth/2, mHeight/2, radius, paintCircle);
    }

    private void drawDegree(Canvas canvas) {
        paintDegree = new Paint();
        paintDegree.setStrokeWidth(3);
        paintDegree.setColor(getResources().getColor(R.color.colorPrimaryDark));
        for (int i=0; i<12; i++) {
            if (i==0 || i==3 || i==6 || i==9) {
                paintDegree.setStrokeWidth(5);
                paintDegree.setTextSize(30);
                canvas.drawLine(mWidth/2, mHeight/2-mHeight/2, mWidth/2, mHeight/2-mWidth/2+60, paintDegree);
                String degreeText = String.valueOf(i);
                canvas.drawText(degreeText, mWidth/2-paintDegree.measureText(degreeText)/2, mHeight/2-mWidth/2+90, paintDegree);
            } else {
                paintDegree.setStrokeWidth(3);
                paintDegree.setTextSize(15);
                canvas.drawLine(mWidth/2, mHeight/2-mHeight/2, mWidth/2, mHeight/2-mWidth/2+60, paintDegree);
                String degreeText = String.valueOf(i);
                canvas.drawText(degreeText, mWidth/2-paintDegree.measureText(degreeText)/2, mHeight/2-mWidth/2+90, paintDegree);
            }
            canvas.rotate(30, mWidth/2, mHeight/2);
        }
    }

    private void drawPointer(Canvas canvas) {
        Paint paintHour = new Paint();
        paintHour.setStrokeWidth(20);
        paintHour.setColor(getResources().getColor(R.color.colorAccent));
        Paint paintMinute = new Paint();
        paintMinute.setStrokeWidth(10);
        paintMinute.setColor(getResources().getColor(R.color.colorPrimary));
        canvas.save();
        canvas.translate(mWidth/2, mHeight/2);
        canvas.drawLine(0, 0, 100, 100, paintHour);
        canvas.drawLine(0,0, 100, 200, paintMinute);
        canvas.restore();
    }


}
