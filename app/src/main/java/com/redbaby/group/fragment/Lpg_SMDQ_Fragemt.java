package com.redbaby.group.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.redbaby.R;
import com.redbaby.group.MyUrls;
import com.redbaby.group.WebViewActivity;
import com.redbaby.group.adapter.HengRecyclerViewAdapter;
import com.redbaby.group.adapter.MyMuYingAdapter;
import com.redbaby.group.bean.MuYingBean;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Lpg_SMDQ_Fragemt extends Fragment {

    private RecyclerView mRv;
    private OkHttpClient mOk;
    private Request mRequest;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                String my = (String) msg.obj;

                Gson gson = new Gson();
                mBean = gson.fromJson(my, MuYingBean.class);
                //设置适配器
                MyMuYingAdapter myMuYingAdapter = new MyMuYingAdapter(mBean, getContext());
                myMuYingAdapter.setOnItemClickLitsener(new HengRecyclerViewAdapter.onItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent
                                = new Intent(getContext(), WebViewActivity.class);

                        intent.putExtra("img", mBean.getEnrolls().getList().get(position).getImgUrl());


                        getContext().startActivity(intent);

                    }
                });
                mRv.setAdapter(myMuYingAdapter);

            }
        }
    };
    private MuYingBean mBean;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.lpg__my__fragemt, null);
        mRv = (RecyclerView) view.findViewById(R.id.lpg_my_rv);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //设置recyclerview
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRv.setLayoutManager(linearLayoutManager);
        //添加分割线
        mRv.addItemDecoration(new DividerItemDecoration(
                getContext(), DividerItemDecoration.VERTICAL));
        initData();
    }


    private void initData() {
        //创建okHttpClient对象
        mOk = new OkHttpClient();
        mRequest = new Request.Builder()
                .url(MyUrls.SHUMADIANQI)
                .build();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //response
                    Response response = mOk.newCall(mRequest).execute();
                    //获取结果
                    String my = response.body().string();
                    response.body().close();

                    Message message = new Message();
                    message.what = 0;
                    message.obj = my;

                    mHandler.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}