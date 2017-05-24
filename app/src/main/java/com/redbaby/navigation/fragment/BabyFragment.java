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
import com.redbaby.R;
import com.redbaby.base.BaseFragment;


public class BabyFragment extends BaseFragment implements View.OnClickListener {

    private ImageView boy_animator, girl_animator;
    private ImageView boy_checked, girl_checked;
    private RotateAnimation boy_rotate, girl_rotate;
    private int tag = 0;

    @Override
    public View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return View.inflate(getActivity(),R.layout.babyinfo_fragment_baby,null);
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

        getActivity().findViewById(R.id.iv_frag_baby_boy).setOnClickListener(this);
        getActivity().findViewById(R.id.iv_frag_baby_girl).setOnClickListener(this);
        getActivity().findViewById(R.id.btn_frag_baby_affirm).setOnClickListener(this);

        boy_animator = (ImageView) getActivity().findViewById(R.id.iv_frag_baby_boy_animator);
        boy_checked = (ImageView) getActivity().findViewById(R.id.iv_frag_baby_boy_check);

        girl_animator = (ImageView) getActivity().findViewById(R.id.iv_frag_baby_girl_animator);
        girl_checked = (ImageView) getActivity().findViewById(R.id.iv_frag_baby_girl_check);

        //初始化 动画
        initAnimator();
    }


    private void initAnimator() {
        //动画
        boy_rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        boy_rotate.setDuration(4000);
        boy_rotate.setRepeatCount(-1);

        girl_rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        girl_rotate.setDuration(4000);
        girl_rotate.setRepeatCount(-1);
    }

    /**
     * boy 男孩动画
     */
    private void addBoyAnimator() {

        //清除动画
        girl_animator.clearAnimation();

        //开始旋转动画
        boy_animator.startAnimation(boy_rotate);
    }

    private void addGirlAnimator() {

        //清除动画
        boy_animator.clearAnimation();

        //开始旋转动画
        girl_animator.startAnimation(girl_rotate);
    }


    public void addAinimation(ImageView imageView) {
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(4000);
        rotateAnimation.setRepeatCount(-1);
        imageView.startAnimation(rotateAnimation);
    }


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

        //弊屏多次触控
        if (v.getId() != tag) {

            switch (v.getId()) {
                case R.id.iv_frag_baby_boy:
                    tag = R.id.iv_frag_baby_boy;
                    //显示 男孩
                    boy_animator.setVisibility(View.VISIBLE);
                    boy_checked.setVisibility(View.VISIBLE);
                    //隐藏 女孩
                    girl_animator.setVisibility(View.INVISIBLE);
                    girl_checked.setVisibility(View.INVISIBLE);

                    addBoyAnimator();
//                addAinimation(boy_animator);
                    break;
                case R.id.iv_frag_baby_girl:
                    tag = R.id.iv_frag_baby_girl;
                    //显示 女孩
                    girl_animator.setVisibility(View.VISIBLE);
                    girl_checked.setVisibility(View.VISIBLE);
                    //隐藏 男孩
                    boy_animator.setVisibility(View.INVISIBLE);
                    boy_checked.setVisibility(View.INVISIBLE);

//                addAinimation(girl_animator);
                    addGirlAnimator();
                    break;
                case R.id.btn_frag_baby_affirm:
                    tag = R.id.btn_frag_baby_affirm;
                    //跳转到主页面
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
//                    getActivity().finish();
                    break;
            }

        }
    }

}
