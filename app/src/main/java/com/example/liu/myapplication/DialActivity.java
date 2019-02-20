package com.example.liu.myapplication;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class DialActivity extends AppCompatActivity {

    ImageView ivLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial);

        ((Animatable)((ImageView)findViewById(R.id.image)).getDrawable()).start();

        ivLine = (ImageView) findViewById(R.id.iv_line);
        ivLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateLine();
            }
        });
    }

    private void animateLine() {
        Drawable drawable = ivLine.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }

    }


}
