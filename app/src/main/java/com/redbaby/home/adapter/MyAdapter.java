package com.redbaby.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.redbaby.R;
import com.redbaby.home.bean.Bean_main;

import java.util.List;


/**
 * 用途：
 * author：王倩凤Administrator
 * date:2017/5/17.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    public static final int ITEM0 = 0;
    public static final int ITEM1 = 1;
    public static final int ITEM2 = 2;
    public static final int ITEM3 = 3;
    public static final int ITEM4 = 4;
    private final Context context;
    private final List<Bean_main.DataBean> list;

    public MyAdapter(Context context, List<Bean_main.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==0){
            View view = LayoutInflater.from(context).inflate(R.layout.home_item, parent, false);
            MyHolder holder = new MyHolder(view);
            return holder;
        }else if (viewType==1){
            View view = LayoutInflater.from(context).inflate(R.layout.home_item2, parent, false);
            MyHolder2 holder = new MyHolder2(view);
            return holder;
        }else if (viewType==2){
            View view = LayoutInflater.from(context).inflate(R.layout.home_item3, parent, false);
            MyHolder3 holder = new MyHolder3(view);
            return holder;
        }else if (viewType==3){
            View view = LayoutInflater.from(context).inflate(R.layout.home_item4, parent, false);
            MyHolder4 holder = new MyHolder4(view);
            return holder;
        }else {
            View view = LayoutInflater.from(context).inflate(R.layout.home_item5, parent, false);
            MyHolder5 holder = new MyHolder5(view);
            return holder;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        holder.itemView.getTag(position);
        if (holder instanceof MyHolder){
            MyHolder holders = (MyHolder) holder;
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        int count = position%5;
        if (count==0){
            return ITEM0;
        }
        if (count==1){
            return ITEM1;
        }
        if (count == 2){
            return ITEM2;
        }
        if (count == 3){
            return ITEM3;
        }
        if (count == 4){
            return ITEM4;
        }
        return super.getItemViewType(position);
    }

    class MyHolder extends RecyclerView.ViewHolder{
        private View itemView;
        private final ImageView mImageView;
        private final ImageView mDay_iv_main;
        private final TextView mDay_tv_main;
        private final ImageView mLingquan_iv_main;
        private final TextView mLingquan_tv_main;
        private final ImageView mJinkou_iv_main;
        private final TextView mJinkou_tv_main;
        private final ImageView mMianfei_iv_main;
        private final TextView mMianfei_tv_main;
        private final ImageView mYunma_iv_main;
        private final TextView mYunma_tv_main;

        public MyHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            mImageView = (ImageView) itemView.findViewById(R.id.imageView);
            mDay_iv_main = (ImageView)itemView.findViewById(R.id.day_iv_main);
            mDay_tv_main = (TextView)itemView.findViewById(R.id.day_tv_main);
            mLingquan_iv_main = (ImageView)itemView.findViewById(R.id.lingquan_iv_main);
            mLingquan_tv_main = (TextView)itemView.findViewById(R.id.lingquan_tv_main);
            mJinkou_iv_main = (ImageView)itemView.findViewById(R.id.jinkou_iv_main);
            mJinkou_tv_main = (TextView)itemView.findViewById(R.id.jinkou_tv_main);
            mMianfei_iv_main = (ImageView)itemView.findViewById(R.id.mianfei_iv_main);
            mMianfei_tv_main = (TextView)itemView.findViewById(R.id.mianfei_tv_main);
            mYunma_iv_main = (ImageView)itemView.findViewById(R.id.yunma_iv_main);
            mYunma_tv_main = (TextView)itemView.findViewById(R.id.yunma_tv_main);
        }
    }

    class MyHolder2 extends RecyclerView.ViewHolder{
        private View itemView;

        public MyHolder2(View itemView) {
            super(itemView);
        }
    }
    class MyHolder3 extends RecyclerView.ViewHolder{
        private View itemView;

        public MyHolder3(View itemView) {
            super(itemView);
        }
    }
    class MyHolder4 extends RecyclerView.ViewHolder {
        private View itemView;

        public MyHolder4(View itemView) {
            super(itemView);
        }
    }
    class MyHolder5 extends RecyclerView.ViewHolder {
        private View itemView;

        public MyHolder5(View itemView) {
            super(itemView);
        }
    }
}
