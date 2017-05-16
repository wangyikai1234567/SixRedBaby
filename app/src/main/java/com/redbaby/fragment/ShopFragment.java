package com.redbaby.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.redbaby.R;
import com.redbaby.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends BaseFragment {


    public ShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //加载布局,这里的mContext上下文实际是来源于BaseFragment里定义的对象
        View inflate = View.inflate(mContext, R.layout.fragment_shop, null);
        return inflater.inflate(R.layout.fragment_shop, container, false);
    }

    @Override
    public View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return null;
    }

    @Override
    public void initPopMenuData() {

    }

}
