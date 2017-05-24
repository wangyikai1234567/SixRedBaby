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
import com.redbaby.group.bean.JingXuanBean;

/**
 * date: 2017/5/22.
 * author: 王艺凯 (lenovo )
 * function:
 */

public class HengRecyclerViewAdapter extends RecyclerView.Adapter<HengRecyclerViewAdapter.ViewHolder> {
    private JingXuanBean mJingXuanBean;
    private Context mContext;


    public HengRecyclerViewAdapter(JingXuanBean jingXuanBean, Context context) {
        mJingXuanBean = jingXuanBean;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.heng_nei, null);

        ViewHolder vh = new ViewHolder(v);


        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        String x = mJingXuanBean.getEnrolls_1().getList().get(position).getItemName();
        if (x.length() >= 9) {
            holder.mTitle.setText(x.substring(0, 9) + "...");
        } else {
            holder.mTitle.setText(x);

        }
        String y = mJingXuanBean.getEnrolls_1().getList().get(position).getItemDesc();
        if (y.length() >= 11) {
            holder.mJieshao.setText(y.substring(0, 11) + "...");

        } else {
            holder.mJieshao.setText(y);

        }


        holder.mXianPrice.setText(mJingXuanBean.getEnrolls_1().getList().get(position).getPrice() + "");

        Glide.with(mContext).load("http:" + mJingXuanBean.getEnrolls_1().getList().get(position).getImgUrl()).into(holder.mIv);
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
        return mJingXuanBean.getEnrolls_1().getList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private final TextView mTitle;
        private final TextView mJieshao;
        private final TextView mXianPrice;
        private final ImageView mIv;

//        private final WebView mWv;

        public ViewHolder(View itemView) {
            super(itemView);
            mIv = (ImageView) itemView.findViewById(R.id.heng_nei_iv);
            mTitle = (TextView) itemView.findViewById(R.id.heng_nei_title);
            mJieshao = (TextView) itemView.findViewById(R.id.heng_nei_jieshao);
            mXianPrice = (TextView) itemView.findViewById(R.id.heng_nei_xianprice);


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
