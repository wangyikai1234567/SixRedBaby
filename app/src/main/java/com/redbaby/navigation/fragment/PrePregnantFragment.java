package com.redbaby.navigation.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.redbaby.MainActivity;
import com.redbaby.R;
import com.redbaby.base.BaseFragment;

/**
 * Effect :
 * <p>
 * Created by Administrator
 * Time by 2017/5/19 0019
 */

public class PrePregnantFragment extends BaseFragment {


    @Override
    public View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return View.inflate(getActivity(),R.layout.babyinfo_fragment_prepregnant,null);
    }

    @Override
    public void initPopMenuData() {

        //获取 toolbar
        final Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.activity_babyinfo_toolbar);
        final ImageView back = (ImageView) toolbar.findViewById(R.id.activity_babyinfo_back);
        back.setVisibility(View.VISIBLE);
        back.findViewById(R.id.activity_babyinfo_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //回退
                getActivity().getSupportFragmentManager().popBackStack();
                //隐藏 回退
                back.setVisibility(View.INVISIBLE);
            }
        });

        getActivity().findViewById(R.id.btn_frag_prepre_affirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到主页面
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
//                getActivity().finish();
            }
        });
    }
}
