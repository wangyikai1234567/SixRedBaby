package com.redbaby.home.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.redbaby.R;
import com.redbaby.home.adapter.PageVPAdapter;
import com.redbaby.home.utils.Util;

import java.util.ArrayList;
import java.util.List;

public class UserFragment extends Fragment {

    private ImageView sm_img_f;
    private TextView secarch_f;
    private ImageView mes_img;
    private TabLayout tablayout_F;
    private ViewPager viewPager_F;
    private View mView;
    private List<String> title = new ArrayList<>();
    private List<String> uri = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_user, container, false);

        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initView() {
        sm_img_f = (ImageView) mView.findViewById(R.id.sm_img_f);
        secarch_f = (TextView) mView.findViewById(R.id.secarch_f);
        mes_img = (ImageView) mView.findViewById(R.id.mes_img);
        tablayout_F = (TabLayout) mView.findViewById(R.id.tablayout_F);
        viewPager_F = (ViewPager) mView.findViewById(R.id.viewPager_F);
    }

    private void initData() {
        title.add("上新");
        title.add("纸尿裤");
        title.add("奶粉");
        title.add("洗护喂养");
        title.add("玩具");
        title.add("服饰");
        title.add("图书");
        title.add("车床座椅");

        uri.add(Util.urisx);
        uri.add(Util.uriznk);
        uri.add(Util.urinf);
        uri.add(Util.urixwyh);
        uri.add(Util.uriwj);
        uri.add(Util.urifs);
        uri.add(Util.urits);
        uri.add(Util.uricczy);

        tablayout_F.setTabMode(TabLayout.MODE_SCROLLABLE);
        tablayout_F.setTabTextColors(Color.BLACK,Color.RED);
        tablayout_F.setupWithViewPager(viewPager_F);//tab关联viewPager
        viewPager_F.setAdapter(new PageVPAdapter(getFragmentManager(),title,uri));//给viewPager设置适配器
    }
}
