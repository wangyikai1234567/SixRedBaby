package com.redbaby;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.RadioGroup;
import com.redbaby.base.BaseActivity;
import com.redbaby.group.GroupFragment;
import com.redbaby.home.view.UserFragment;
import com.redbaby.my.MyFragment;
import com.redbaby.shoppingcar.ShopFragment;
import com.redbaby.sort.SortFragment;

public class MainActivity extends BaseActivity {

    private RadioGroup mRg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setRgChecked();
    }

    @Override
    protected void initViews() {
        mRg = (RadioGroup) findViewById(R.id.rg_main);

        replaceFragment(R.id.fLayout, new UserFragment());
    }

    private void setRgChecked() {
        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:
                        replaceFragment(R.id.fLayout, new UserFragment());
                        break;
                    case R.id.rb_sort:
                        replaceFragment(R.id.fLayout, new SortFragment());
                        break;
                    case R.id.rb_group:
                        replaceFragment(R.id.fLayout, new GroupFragment());
                        break;
                    case R.id.rb_shop:
                        replaceFragment(R.id.fLayout, new ShopFragment());
                        break;
                    case R.id.rb_my:
                        replaceFragment(R.id.fLayout, new MyFragment());
                        break;
                }
            }
        });
    }

    @Override
    protected void replaceFragment(int containerViewId, Fragment fragment) {
        super.replaceFragment(containerViewId, fragment);
    }
}
