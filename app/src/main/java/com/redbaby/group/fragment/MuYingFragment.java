package com.redbaby.group.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.redbaby.R;
import com.redbaby.group.MyUrls;
import com.redbaby.group.bean.MuYingBean;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
public class MuYingFragment extends Fragment {

    private LinearLayout mLl;
    private FrameLayout mFl;
    private OkHttpClient mOk;
    private Request mRequest;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);


            if (msg.what == 0) {
                String my = (String) msg.obj;

                Gson gson = new Gson();
                MuYingBean bean = gson.fromJson(my, MuYingBean.class);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                for (int i = 0; i < bean.getCategories().size(); i++) {
                    TextView textView = new TextView(getContext());
                    layoutParams.setMargins(0, 5, 10, 5);
                    textView.setTextSize(12);
                    textView.setCompoundDrawablePadding(5);
                    textView.setText(bean.getCategories().get(i).getName());
                    textView.setLayoutParams(layoutParams);
                    mLl.addView(textView, layoutParams);
                }
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_mu_ying_fragment, null);
        mLl = (LinearLayout) view.findViewById(R.id.my_ll);
        mFl = (FrameLayout) view.findViewById(R.id.my_fl);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();

//        t添加默认界面
        // fragmment添加默认界面
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.my_fl, new Lpg_My_Fragemt(), "Lpg_My_Fragemt()");
        transaction.commit();
    }


    private void initData() {
        //创建okHttpClient对象
        mOk = new OkHttpClient();
        mRequest = new Request.Builder()
                .url(MyUrls.MUYING)
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