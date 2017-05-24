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
import android.widget.Toast;

import com.google.gson.Gson;
import com.redbaby.R;
import com.redbaby.group.MyUrls;
import com.redbaby.group.WebViewActivity;
import com.redbaby.group.adapter.JustListAdapter;
import com.redbaby.group.bean.RiYongBean;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class JiuJiuBaoYouFragment extends Fragment {


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
                mBean = gson.fromJson(my, RiYongBean.class);
                //设置适配器
                mJust = new JustListAdapter(mBean, getContext());
                mJust.setOnItemClickLitsener(new JustListAdapter.onItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent
                                = new Intent(getContext(), WebViewActivity.class);

                        intent.putExtra("img", mBean.getEnrolls().getList().get(position).getImgUrl());
                        getContext().startActivity(intent);
                        Toast.makeText(getContext(), "click", Toast.LENGTH_SHORT).show();

                    }
                });
                mRv.setAdapter(mJust);

            }
        }
    };
    private JustListAdapter mJust;
    private RiYongBean mBean;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.riyongfragment, null);
        mRv = (RecyclerView) v.findViewById(R.id.ry_rv);
        return v;


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
                .url(MyUrls.JIUJIUBAOYOU)
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
