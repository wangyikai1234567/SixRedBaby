package com.redbaby.home.model;


import com.redbaby.home.presenter.PagepresenterListener;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * 用途：
 * author：王倩凤Administrator
 * date:2017/5/17.
 */

public class PageModelImpl implements PageModel{

    private static OkHttpClient mClient;
    private String mString;
    //设置标题头格式
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static OkHttpClient getOkHttpClient(){
        if(mClient==null) {
            // 可以通过实现 Logger 接口更改日志保存位置
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            mClient = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build();
        }
        return mClient;
    }


    @Override
    public void get(String url, final PagepresenterListener listener) {
        Request request =new Request.Builder()
                .url(url)
                .build();
        getOkHttpClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                listener.onRequesteError();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mString = response.body().string();

                listener.onRequestSuccess(mString);//调用p层的方法，将请求到的数据返回给p层
            }
        });
    }
}
