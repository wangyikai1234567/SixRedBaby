
package com.redbaby.home.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.chanven.lib.cptr.PtrFrameLayout;
import com.chanven.lib.cptr.PtrUIHandler;
import com.chanven.lib.cptr.indicator.PtrIndicator;
import com.redbaby.R;
import com.redbaby.home.utils.DisplayUtils;


/**
 * Created by liugang on 2017/05/19.
 */
public class ParallaxHeader extends FrameLayout implements PtrUIHandler {


    private int limitX;
    private ImageView iv_mama_and_baby;
    private ImageView iv_mama;
    private ImageView iv_baby;
    private ProgressBar custom_progressba;
    private AnimationDrawable iv_mama_and_babyBackground;

    private void initialize() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.custom_head_layout, this);

        iv_mama_and_baby = (ImageView) view.findViewById(R.id.iv_mama_and_baby);
        iv_mama = (ImageView) view.findViewById(R.id.iv_mama);
        iv_baby = (ImageView) view.findViewById(R.id.iv_baby);
        custom_progressba = (ProgressBar) view.findViewById(R.id.custom_progressbar);
        //将xml作为背景设置给ImageView
        iv_mama_and_baby.setBackgroundResource(R.drawable.frame_anim_mama_and_baby);
        iv_mama_and_babyBackground = (AnimationDrawable) iv_mama_and_baby.getBackground();
        //开始播放

    }

    public ParallaxHeader(Context context) {
        this(context, null, 0);
    }

    public ParallaxHeader(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ParallaxHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }


    @Override//在UI重置
    public void onUIReset(PtrFrameLayout frame) {
        Log.i("=======>", "==1==");
    }

    @Override//在UI刷新准备
    public void onUIRefreshPrepare(PtrFrameLayout frame) {

        iv_mama.setVisibility(View.VISIBLE);
        iv_baby.setVisibility(View.VISIBLE);

        custom_progressba.setVisibility(View.INVISIBLE);
    }

    @Override//在UI刷新开始
    public void onUIRefreshBegin(PtrFrameLayout frame) {
        iv_mama_and_baby.setVisibility(View.VISIBLE);
        iv_mama_and_babyBackground.start();
        iv_mama.setVisibility(View.INVISIBLE);
        iv_baby.setVisibility(View.INVISIBLE);
        custom_progressba.setVisibility(View.VISIBLE);

    }

    @Override//在UI刷新完成
    public void onUIRefreshComplete(PtrFrameLayout frame) {

        iv_mama_and_babyBackground.stop();

    }

    @Override//用户界面位置变化
    public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {
        final int offsetToRefresh = frame.getOffsetToRefresh();
        final int currentPos = ptrIndicator.getCurrentPosY();


        if (limitX == 0) calcLimitX();

        double percent = (double) currentPos / offsetToRefresh;
        int targetX = (int) (limitX * percent);
        iv_mama.setTranslationX(-(targetX * 4));
        iv_baby.setTranslationX((targetX * 4));

        //Log.i("=======>", offsetToRefresh + "====" + currentPos);
        int mIconIvWidth = iv_mama.getMeasuredWidth();
        if (currentPos >= offsetToRefresh * 2+mIconIvWidth) {
            iv_mama.setVisibility(View.INVISIBLE);
            iv_baby.setVisibility(View.INVISIBLE);
            iv_mama_and_baby.setVisibility(View.VISIBLE);


        } else if (currentPos == 0) {
            iv_mama.setVisibility(View.VISIBLE);
            iv_baby.setVisibility(View.VISIBLE);

            iv_mama_and_baby.setVisibility(View.INVISIBLE);

        }
    }

    private void calcLimitX() {
        limitX = DisplayUtils.screenWidth / 2;
        int mIconIvWidth = iv_mama.getMeasuredWidth();
        limitX -= (mIconIvWidth / 2);
    }
}
