package com.redbaby.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.redbaby.R;
import com.redbaby.bean.GoodsBean;

import java.util.List;

/**
 * data:2017/5/17
 * author:高亚男(Administrator)
 * function:
 */

public class ShoppingCartAdapter extends RecyclerView.Adapter <ShoppingCartAdapter.ViewHolder>{
    private Context mContext;
    //Bean类,在增加一个属性,看是否被用户选中,默认选中.
    private List<GoodsBean> mGoodsBeanList;
    //B.从购物车Fragment传来的控件对象
    private TextView mTvShopcartTotal;
    private CheckBox mCheckboxAll;

    //G.完成状态下的删除复选按钮控件对象
    private CheckBox mCbAll;


    //构造方法,初始化适配器要用到外界的一些对象     参数:上下文 数据必有 (B.)控件对象是为了商品价格计算
    public ShoppingCartAdapter(Context context, List<GoodsBean> goodsBeanList, TextView tvShopcartTotal, CheckBox checkboxAll, CheckBox cbAll) {
        mContext=context;
        mGoodsBeanList=goodsBeanList;
        mTvShopcartTotal=tvShopcartTotal;
        mCheckboxAll=checkboxAll;
        //G.把外界传过来的复选按钮控件对象赋予给本类的全局对象
        mCbAll=cbAll ;

        //B.有数据,默认显示商品价格
        showTotalPrice();
        //C.设置条目的点击事件(RecycleView没有点击事件)
        setListener();
        //D.校验是否全选
        CheckboxAll();


    }

    //C.条目被点击后,实现的逻辑
    private void setListener() {
        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //根据位置找到对应的Bean对象
                GoodsBean goodsBean = mGoodsBeanList.get(position);
                //设置取反状态
                goodsBean.setSelected(!goodsBean.isSelected());
                //更新完数据刷新数据
                notifyItemChanged(position);
                //D.校验是否全选
                CheckboxAll();
                //重新计算商品总价格
                showTotalPrice();
            }
        });

        //E.设置全选的CheckBox复选按钮点击事件,点击他时,可以对所用item进行选中和非选中的操作
        mCheckboxAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //得到复选按钮当前状态
                boolean checked = mCheckboxAll.isChecked();
                //F.根据状态,做对所有item设置全选或非全选
                checkAll_none(checked);
                //计算商品总价格并进行显示
                showTotalPrice();
            }
        });

        //G.在完成状态下,设置全选的CheckBox复选按钮点击事件,点击他时,可以对所用item进行选中和非选中的操作
        mCbAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //得到复选按钮当前状态
                boolean checked = mCbAll.isChecked();
                //F.根据状态,做对所有item设置全选或非全选
                checkAll_none(checked);
            }
        });
    }

    /**
     * F.购物车的Item进行全选或非全选设置
     * @param checked
     */
    public void checkAll_none(boolean checked) {
        //对数据容器进行对象及内容的非空判断.
        if(mGoodsBeanList !=null && mGoodsBeanList.size()>0){
            //使用for循环,对容器里的每一条item设置全中或非全选
            for(int x=0; x<mGoodsBeanList.size() ; x++){
                GoodsBean goodsBean = mGoodsBeanList.get(x);
                goodsBean.setSelected(checked);
                //对哪个Item数据进行更新,就刷新RecycleView的哪个item
                notifyItemChanged(x);
            }
        }
    }

    //D.检验item是否全部全中.对全选的复选按钮进行对应的状态设置.
    public void CheckboxAll() {
        //对数据容器进行对象及内容的非空判断.
        if(mGoodsBeanList !=null && mGoodsBeanList.size()>0){
            //记录选中的item有几条
            int number = 0;
            //使用for循环,对容器里的每一条数据状态进行判断,只要有一条没有被全中,就非全选
            for(int x=0; x<mGoodsBeanList.size() ; x++){
                GoodsBean goodsBean = mGoodsBeanList.get(x);
                //选中做的逻辑操作
                if (goodsBean.isSelected()){
                    number++;
                }//没有选中做的逻辑操作,把复选按钮设置为没有选中
                else{
                    mCheckboxAll.setChecked(false);
                    //G.给完成状态下的复选按钮设置非全选
                    mCbAll.setChecked(false);
                }
            }
            //判断选中的item和容器里的数据条数是否一致,一致则把复选按钮设置为选中.
            if(number == mGoodsBeanList.size()){
                mCheckboxAll.setChecked(true);
                //G.给完成状态下的复选按钮设置全选
                mCbAll.setChecked(true);
            }
        }else {
            mCheckboxAll.setChecked(false);
            //G.给完成状态下的复选按钮设置非全选
            mCbAll.setChecked(false);
        }
    }

    //B.显示商品总价格,在此方法里也执行计算商品价格的任务
    public void showTotalPrice() {
        mTvShopcartTotal.setText("合计 : " + getTotalPrice());
    }

    //B.计算商品的价格.
    public double getTotalPrice() {
        //默认价格为0.0元
        double totalPrice = 0.0;
        //更加集合的多少,从中取出对应商品的价格进行计算(对集合大小对象进行非空判断)
        if(mGoodsBeanList !=null && mGoodsBeanList.size()>0){
            for(int x=0; x<mGoodsBeanList.size() ; x++){
                //遍历集合,拿出每一个有价格的数据容器对象
                GoodsBean goodsBean = mGoodsBeanList.get(x);
                //对数据容器对象进行判断,是否被选中计算价格,选中在对价格进行相加
                if(goodsBean.isSelected()){
                    //拿到容器里的 商品数量 及 价格数据
                    int number = goodsBean.getNumber();
                    String cover_price = goodsBean.getCover_price();
                    //把数据转换为double类型
                    Double DNumber = Double.valueOf(number);
                    Double DPrice = Double.valueOf(cover_price);
                    //计算价格:商品数量 * 商品价格
                    double sum=DNumber*DPrice;
                    //这一类商品价格总和+其他数据种类商品的价格
                    totalPrice=totalPrice+sum;
                    //if语句里的一长串代码一段搞定
//                    totalPrice=totalPrice+Double.valueOf(goodsBean.getNumber())*Double.valueOf(goodsBean.getCover_price());
                }
            }
        }
        return totalPrice;
    }

    //创建返回ViewHolder,创建出一个item的布局界面及控件初始化
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //用View得到一个XML布局对象,参数上下文,XML布局,null
        View inflate = View.inflate(mContext, R.layout.item_shop_cart, null);
        return new ViewHolder(inflate);
    }

    //参数 1.holder对象,可以直接使用其控件对象,设置数据 2.当前用户选中条目位置,根据位置,获取item布局加载要呈现的数据
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //更加位置得到对应的Bean对象
        final GoodsBean goodsBean = mGoodsBeanList.get(position);
        //设置数据,是否被选中,更加网址加载图片
        holder.cb_gov.setChecked(goodsBean.isSelected());
        Glide.with(mContext)
                .load(Constants.BASE_URL_IMAGE+goodsBean.getFigure())
                .into(holder.iv_gov);
        holder.tv_desc_gov.setText(goodsBean.getName());
        holder.tv_price_gov.setText("$"+goodsBean.getCover_price());
        //往加减自定义控件里设置商品数量的数据
        holder.addsubview.setValue(goodsBean.getNumber());

        //B.当用户点击自定义控件增加减少按钮时,商品价格总和发送变化,设置商品数量变化的监听
        holder.addsubview.setOnNumberChangerListener(new AddSubView.OnNumberChangerListener() {
            @Override
            public void OnNumberChanger(int value) {
                //1.当前列表更新(内存中更新)
                goodsBean.setNumber(value);
                //2.本地缓存更新(sp更新)
                CartStorage.getInstance().updateData(goodsBean);
                //3.更新完数据刷新数据
                notifyItemChanged(position);
                //4.重新计算商品总价格
                showTotalPrice();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mGoodsBeanList.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder{
        private CheckBox cb_gov;
        private ImageView iv_gov;
        private TextView tv_desc_gov;
        private TextView tv_price_gov;
        private AddSubView addsubview;

        public ViewHolder(View itemView) {
            super(itemView);
            cb_gov= (CheckBox) itemView.findViewById(R.id.cb_gov);
            iv_gov= (ImageView) itemView.findViewById(R.id.iv_gov);
            tv_desc_gov = (TextView) itemView.findViewById(R.id.tv_desc_gov);
            tv_price_gov = (TextView) itemView.findViewById(R.id.tv_price_gov);
            addsubview = (AddSubView) itemView.findViewById(R.id.addsubview);

            //C.设置Item的点击事件.获取该Item位置position方法getLayoutPosition()
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if ( mOnItemClickListener !=null ){
                        mOnItemClickListener.onItemClick(getLayoutPosition());
                    }
                }
            });
        }
    }

    /**
     * C.点击item的监听者,定义接口
     */
    public interface OnItemClickListener{
        /**
         * 当点击某条时被回调
         * @param position
         */
        public void onItemClick(int position);
    }

    /**
     * 设置Item的监听
     */
    private OnItemClickListener mOnItemClickListener;
    private void setOnItemClickListener(OnItemClickListener onItemClickListener){
        mOnItemClickListener=onItemClickListener;
    }

    //H.删除item数据
    public void deletData() {
        //对数据容器大小,对象非空判断
        if(mGoodsBeanList != null && mGoodsBeanList.size()>0){
            for(int x=0; x<mGoodsBeanList.size(); x++){
                //对mGoodsBeanList进行遍历
                GoodsBean goodsBean = mGoodsBeanList.get(x);
                //对选的item,进行删除
                if(goodsBean.isSelected()){
                    //把数据从内存中移除
                    mGoodsBeanList.remove(goodsBean);
                    //把数据从本地缓存中移除
                    CartStorage.getInstance().deleteData(goodsBean);
                    //数据减少了,所以方法要改变为移除,而不是刷新item的样式
                    notifyItemRemoved(x);
                    //注意:没移除一条,容器数据就减少了,所以这里x要--
                    x--;
                }
            }
        }
    }
}
