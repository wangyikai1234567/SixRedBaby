package com.redbaby.navigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.redbaby.R;
import com.redbaby.base.BaseActivity;

public class BabyInfoActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_info);
    }

    @Override
    protected void initViews() {
         Toolbar toolbar = (Toolbar) findViewById(R.id.activity_babyinfo_toolbar);

        /**
         * 添加默认Fragment
         */
        addDefaultFragment();
    }

    private void addDefaultFragment() {
        super.addFragment(R.id.activity_babyinfo_context,new BabyInfoFragment());
    }

}
