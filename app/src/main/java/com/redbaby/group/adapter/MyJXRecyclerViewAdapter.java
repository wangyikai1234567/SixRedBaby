package com.redbaby.group.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.redbaby.R;
import com.redbaby.group.WebViewActivity;
import com.redbaby.group.bean.JingXuanBean;
import com.zhy.magicviewpager.transformer.AlphaPageTransformer;

/**
 * date: 2017/5/21.
 * author: 王艺凯 (lenovo )
 * function:
 */

public class MyJXRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private JingXuanBean mJingXuanBean;
    private int ITEM1 = 0;
    private int ITEM2 = 1;
    private int ITEM3 = 2;
    private Context mContext;
//    private int[] imgRes = {R.mipmap.aaa, R.mipmap.ic_launcher, R.mipmap.aaa};

    public MyJXRecyclerViewAdapter(JingXuanBean jingXuanBean, Context context) {
        mJingXuanBean = jingXuanBean;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

//加载Item View的时候根据不同TYPE加载不同的布局
        if (viewType == ITEM1) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lpg_rv_vp, parent, false);

            Item1ViewHolder vh = new Item1ViewHolder(v);
            //将创建的View注册点击事件
            return vh;
        } else if (viewType == ITEM2) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lpg_rv_rv, parent, false);

            Item2ViewHolder vh = new Item2ViewHolder(v);
            //将创建的View注册点击事件

            return vh;
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lpg_rv_listview, parent, false);

            Item3ViewHolder vh = new Item3ViewHolder(v);
            //将创建的View注册点击事件

            return vh;
        }

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof Item1ViewHolder) {
            //设置Page间间距
            ((Item1ViewHolder) holder).mVp.setPageMargin(20);
            //设置缓存的页面数量
            ((Item1ViewHolder) holder).mVp.setOffscreenPageLimit(3);
            ((Item1ViewHolder) holder).mVp.setAdapter(new PagerAdapter() {
                @Override
                public Object instantiateItem(ViewGroup container, int position) {
                    ImageView view = new ImageView(mContext);

                    Glide.with(mContext).load("http:" + mJingXuanBean.getAds().get(position).getImgUrl()).into(view);
                    container.addView(view);
                    return view;
                }

                @Override
                public void destroyItem(ViewGroup container, int position, Object object) {
                    container.removeView((View) object);
                }

                @Override
                public int getCount() {
                    return mJingXuanBean.getAds().size();
                }

                @Override
                public boolean isViewFromObject(View view, Object o) {
                    return view == o;
                }
            });
            ((Item1ViewHolder) holder).mVp.setPageTransformer(true, new AlphaPageTransformer());


        } else if (holder instanceof Item2ViewHolder) {
            //设置布局管理器
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

            ((Item2ViewHolder) holder).mRecyclerViewHeng.setLayoutManager(linearLayoutManager);
            ((Item2ViewHolder) holder).mRecyclerViewHeng.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.HORIZONTAL));
            //设置适配器
            HengRecyclerViewAdapter hengRecyclerViewAdapter = new HengRecyclerViewAdapter(mJingXuanBean, mContext);
//            8*************************

            hengRecyclerViewAdapter.setOnItemClickLitsener(new HengRecyclerViewAdapter.onItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    Toast.makeText(mContext, "click", Toast.LENGTH_SHORT).show();

                    Intent intent
                            = new Intent(mContext, WebViewActivity.class);

                    intent.putExtra("img", mJingXuanBean.getEnrolls_1().getList().get(position).getImgUrl());


                    mContext.startActivity(intent);


                }

            });
//                    ************************
            ((Item2ViewHolder) holder).mRecyclerViewHeng.setAdapter(hengRecyclerViewAdapter);
        } else {
            //设置布局管理器
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            ((Item3ViewHolder) holder).mRecyclerViewListView.setLayoutManager(linearLayoutManager);

            ((Item3ViewHolder) holder).mRecyclerViewListView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
            //设置适配器
            ListRecyclerViewAdapter list = new ListRecyclerViewAdapter(mJingXuanBean, mContext);

            ((Item3ViewHolder) holder).mRecyclerViewListView.setAdapter(list);
            list.setOnItemClickLitsener(new ListRecyclerViewAdapter.onItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {

                    Intent intent
                            = new Intent(mContext, WebViewActivity.class);

                    intent.putExtra("img", mJingXuanBean.getEnrolls().getList().get(position).getImgUrl());
                    mContext.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mJingXuanBean.getEnrolls().getList().size() + 2;
    }

    //item1 的ViewHolder
    public static class Item1ViewHolder extends RecyclerView.ViewHolder {


        private final ViewPager mVp;

        public Item1ViewHolder(View itemView) {
            super(itemView);
            mVp = (ViewPager) itemView.findViewById(R.id.lpg_vp);
        }
    }

    //item2 的ViewHolder
    public static class Item2ViewHolder extends RecyclerView.ViewHolder {


        private final RecyclerView mRecyclerViewHeng;

        public Item2ViewHolder(View itemView) {
            super(itemView);
            mRecyclerViewHeng = (RecyclerView) itemView.findViewById(R.id.lpg_rv_heng);

        }
    }

    //item3 的ViewHolder
    public static class Item3ViewHolder extends RecyclerView.ViewHolder {
        private final RecyclerView mRecyclerViewListView;

        public Item3ViewHolder(View itemView) {
            super(itemView);
            mRecyclerViewListView = (RecyclerView) itemView.findViewById(R.id.lpg_rv_lv);

        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ITEM1;
        } else if (position == 1) {
            return ITEM2;
        } else {
            return ITEM3;
        }
    }
}