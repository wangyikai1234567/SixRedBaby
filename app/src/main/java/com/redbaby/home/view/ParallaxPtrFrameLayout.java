
package com.redbaby.home.view;

import android.content.Context;
import android.util.AttributeSet;

import com.chanven.lib.cptr.PtrFrameLayout;
import com.chanven.lib.cptr.PtrUIHandler;


/**
 * Created by liugang on 2017/05/19.
 */
public class ParallaxPtrFrameLayout extends PtrFrameLayout {

    private ParallaxHeader mParallaxHeader;

    public ParallaxPtrFrameLayout(Context context) {
        super(context);
        initViews();
    }

    public ParallaxPtrFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public ParallaxPtrFrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initViews();
    }

    private void initViews() {
        mParallaxHeader = new ParallaxHeader(getContext());
        setHeaderView(mParallaxHeader);
        addPtrUIHandler((PtrUIHandler) mParallaxHeader);
    }

    public ParallaxHeader getHeader() {
        return mParallaxHeader;
    }
}
