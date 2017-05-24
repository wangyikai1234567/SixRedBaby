package com.redbaby.navigation.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.redbaby.MainActivity;
import com.redbaby.base.BaseFragment;
import com.redbaby.R;

public class PregnantFragment extends BaseFragment {


    @Override
    public View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return View.inflate(getActivity(), R.layout.babyinfo_fragment_pregnant,null);
    }

    @Override
    public void initPopMenuData() {
        ImageView iv_animator= (ImageView) getActivity().findViewById(R.id.iv_frag_pregnant_animator);

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


        /**
         * 旋转动画
         */
        RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotate.setDuration(4000);
        rotate.setRepeatCount(-1);
        iv_animator.startAnimation(rotate);

        getActivity().findViewById(R.id.btn_frag_pregnant_affirm).setOnClickListener(new View.OnClickListener() {
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
