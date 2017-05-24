package com.redbaby.group.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.redbaby.R;
import com.redbaby.group.bean.RiYongBean;


/**
 * date: 2017/5/23.
 * author: 王艺凯 (lenovo )
 * function:
 */

public class JustListAdapter extends RecyclerView.Adapter<JustListAdapter.ViewHolder> {

    private RiYongBean mRiYongBean;
    private Context mContext;

    public JustListAdapter(RiYongBean riYongBean, Context context) {
        mRiYongBean = riYongBean;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_nei, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        Glide.with(mContext).load("http:" + mRiYongBean.getEnrolls().getList().get(position).getImgUrl())
                .into(holder.imageView);

        String x = mRiYongBean.getEnrolls().getList().get(position).getItemName();
        if (x.length() >= 23) {
            holder.mTitle.setText(x.substring(0, 23) + "...");

        } else {
            holder.mTitle.setText(x);

        }


        holder.mJieshao.setText(mRiYongBean.getEnrolls().getList().get(position).getItemDesc());
        holder.mPrice.setText(mRiYongBean.getEnrolls().getList().get(position).getPrice() + "");


        if (mOnItemClickListener != null) {


            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, pos);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mRiYongBean.getEnrolls().getList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTitle;
        private final TextView mJieshao;
        private final TextView mPrice;
        private final ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.lv_iv);
            mTitle = (TextView) itemView.findViewById(R.id.lv_title);
            mJieshao = (TextView) itemView.findViewById(R.id.lv_jieshao);
            mPrice = (TextView) itemView.findViewById(R.id.lv_xianprice);
        }
    }

    //接口回调
    onItemClickListener mOnItemClickListener;

    public interface onItemClickListener {
        void onItemClick(View view, int position);
    }


    public void setOnItemClickLitsener(onItemClickListener mOnItemClickLitsener) {
        mOnItemClickListener = mOnItemClickLitsener;
    }
}
