package com.example.liu.myapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.liu.myapplication.webapi.WebApi;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bt_dial)
    Button btDial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void on1Clicked(View view) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.miui.powerkeeper",
                "com.miui.powerkeeper.ui.HiddenAppsContainerManagementActivity"));
        startActivity(intent);
    }

    public void on2Clicked(View view) {
        Intent intent = new Intent(this, TestSmartScollViewActivity.class);
        startActivity(intent);
    }

    public void onRequestIpClicked(View view) {
        try {
            WebApi.requestIp();
            Toast.makeText(this, "hh", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.bt_dial)
    public void onClick() {
        startActivity(new Intent(MainActivity.this, DialActivity.class));
    }
}
