package com.redbaby.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * data:2017/5/16
 * author:高亚男(Administrator)
 * function:基类fragment,主界面跳转的fragment都要继承该类:首页：HomeFragment,分类：TypeFragment,
 * 发现：CommunityFragment,购物车：ShoppingCartFragment, 用户中心：UserFragment
 */

public abstract class BaseFragment extends Fragment {
    //得到上下文
    public Context mContext;
    //Fragment对象一创建就获取上下文;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    //因为每个子Fragment显示的界面都不同,所以返回一个抽象方法,让子fragment加载自己的XML布局资源
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView(inflater,container,savedInstanceState);
    }
    /**
     * 加载fragment的布局资源,子类必须要覆写的抽象方法,
     */
    public abstract View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    //Fragment与Activity被创建时回调的方法.进行数据的初始化
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initPopMenuData();
    }
    /**
     *联网获取数据,子类必须要覆写的抽象方法
     */
    public abstract void initPopMenuData();


}
