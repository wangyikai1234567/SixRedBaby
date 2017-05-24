package com.redbaby.group.fragment;

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
import com.redbaby.group.adapter.MyJXRecyclerViewAdapter;
import com.redbaby.group.bean.JingXuanBean;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/**
 * date: 2017/5/21.
 * author: 王艺凯 (lenovo )
 * function:
 */

public class Lpg_JxFragment extends Fragment {

    private RecyclerView mRv1;
    private LinearLayoutManager mLinearLayoutManager;
    private OkHttpClient mOk;
    private Request mRequest;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                String jx = (String) msg.obj;

                Gson gson = new Gson();
                JingXuanBean bean = gson.fromJson(jx, JingXuanBean.class);

                mRv1.setAdapter(new MyJXRecyclerViewAdapter(bean, getContext()));


            }


        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lpg_fragment1, null);
        mRv1 = (RecyclerView) view.findViewById(R.id.lpg_rv1);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mRv1.setLayoutManager(mLinearLayoutManager);
//添加分割线
        mRv1.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        initData();

    }

    private void initData() {
        //创建okHttpClient对象
        mOk = new OkHttpClient();
        mRequest = new Request.Builder()
                .url(MyUrls.JINGXUAN)
                .build();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //response
                    Response response = mOk.newCall(mRequest).execute();
                    //获取结果
                    String jx = response.body().string();
                    response.body().close();

                    Message message = new Message();
                    message.what = 0;
                    message.obj = jx;

                    mHandler.sendMessage(message);


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
