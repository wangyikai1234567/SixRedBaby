package com.redbaby.group.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.redbaby.R;
import com.redbaby.group.MyUrls;
import com.redbaby.group.bean.JingXuanBean;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.redbaby.R.id.mTb;

public class GroupFragment extends Fragment {

    private TabLayout mTabLayout;
    private Request mRequest;
    private OkHttpClient mOk;
    private List<JingXuanBean.CatesBean> mJingxuanList;
    private FrameLayout mFl;
    private Handler mHandler = new Handler() {
        public boolean select = false;

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                JingXuanBean jing = (JingXuanBean) msg.obj;
                mJingxuanList = jing.getCates();
                mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

                for (int i = 0; i < mJingxuanList.size(); i++) {
                    TabLayout.Tab tab = mTabLayout.newTab();                    //布局


                    View view = LayoutInflater.from(getContext()).inflate(R.layout.tab, null);
                    view.setSelected(select);
                    //id
                    mTv = (TextView) view.findViewById(R.id.tab_tv);

                    mTv.setText(mJingxuanList.get(i).getCateName());
                    ImageView imageView = (ImageView) view.findViewById(R.id.tab_iv);

                    Glide.with(getContext()).load("http:" + mJingxuanList.get(i).getCateIconUrl()).into(imageView);


//

                    tab.setCustomView(view);

                    mTv.setFocusable(true);
                    mTabLayout.addTab(tab);
                }
            }

        }
    };
    private TextView mTv;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_group_fragment, null);
        mTabLayout = (TabLayout) view.findViewById(mTb);
        mFl = (FrameLayout) view.findViewById(R.id.lpg_fl);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //添加Tablayout
        initTitle();
        // fragmment添加默认界面
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.lpg_fl, new Lpg_JxFragment(), "Lpg_JxFragment()");
        transaction.commit();
        //设置点击事件切换界面

        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            private FragmentTransaction mTransaction;

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    // fragmment添加默认界面
                    showFragment(new Lpg_JxFragment(), "Lpg_JxFragment()");
                } else if (tab.getPosition() == 2) {
                    // fragmment添加默认界面
                    showFragment(new MuYingFragment(), "MuYingFragment()");
                } else if (tab.getPosition() == 1) {
                    // fragmment添加默认界面
                    showFragment(new RiYongFragment(), "RiYongFragment()");
                } else if (tab.getPosition() == 3) {
                    // fragmment添加默认界面
                    showFragment(new ZhiNiaoKuFragment(), "ZhiNiaoKuFragment()");
                } else if (tab.getPosition() == 4) {
                    // fragmment添加默认界面
                    showFragment(new FuZhuangXiangBaoFragment(), " FuZhuangXiangBaoFragment()");
                } else if (tab.getPosition() == 5) {
                    // fragmment添加默认界面
                    showFragment(new GuoXianLianYouMiFragment(), "GuoXianLianYouMiFragment()");
                } else if (tab.getPosition() == 6) {
                    // fragmment添加默认界面
                    showFragment(new MeiZhuangFragment(), "MeiZhuangFragment())");
                } else if (tab.getPosition() == 7) {
                    // fragmment添加默认界面
                    showFragment(new GouGouMaoMiFragment(), "GouGouMaoMiFragment()");
                } else if (tab.getPosition() == 8) {
                    // fragmment添加默认界面
                    showFragment(new JiuJiuBaoYouFragment(), "JiuJiuBaoYouFragment()");
                } else if (tab.getPosition() == 9) {
                    // fragmment添加默认界面
                    showFragment(new ShuMaDianQiFragment(), "ShuMaDianQiFragment()");
                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {


            }
        });

    }

    private void initTitle() {

//        解析
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
                    String jingxuan = response.body().string();
                    response.body().close();

                    Gson gson = new Gson();
                    JingXuanBean bean = gson.fromJson(jingxuan, JingXuanBean.class);


                    Message message = new Message();
                    message.what = 0;
                    message.obj = bean;

                    mHandler.sendMessage(message);


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 使用replace切换页面
     * 显示fragment
     */
    private void showFragment(Fragment fg, String tag) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.lpg_fl, fg, tag);
        transaction.commit();
    }
}
