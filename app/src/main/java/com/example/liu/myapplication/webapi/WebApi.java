package com.example.liu.myapplication.webapi;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class WebApi {

    private static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    private static  OkHttpClient client = new OkHttpClient();


    public static void requestIp() throws IOException {
        RequestBody requestBody = RequestBody.create(JSON, "");
        Request request = new Request.Builder()
                .url("http://myip.ipip.net")
//                .post(requestBody)
                .build();
        final Call call = client.newCall(request);
        new Thread(new Runnable() {
            @Override
            public void run() {

                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String s = response.body().string();

                        Log.d("webapi", s);
                    }
                });

            }
        }).start();


    }




}
