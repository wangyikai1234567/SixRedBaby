package com.redbaby.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.redbaby.R;
import com.redbaby.adapter.ShoppingCartAdapter;
import com.redbaby.base.BaseFragment;
import com.redbaby.bean.GoodsBean;
import com.redbaby.utils.CartStorage;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends BaseFragment implements View.OnClickListener {
    private TextView tvShopcartEdit;
    private RecyclerView recyclerview;
    private LinearLayout llCheckAll;
    private CheckBox checkboxAll;
    private TextView tvShopcartTotal;
    private Button btnCheckOut;
    private LinearLayout llDelete;
    private CheckBox cbAll;
    private Button btnDelete;
    private Button btnCollection;
    private ImageView ivEmpty;
    private TextView tvEmptyCartTobuy;
    private LinearLayout ll_empty_shopcart;
    private ShoppingCartAdapter mShoppingCartAdapter;

    //C.编辑状态
    private static final int ACTION_EDIT=1;
    //C.完成状态
    private static final int ACTION_COMPLETE=2;

    public ShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //加载布局,这里的mContext上下文实际是来源于BaseFragment里定义的对象
        View inflate = View.inflate(mContext, R.layout.fragment_shop, null);
        //实例化控件
        tvShopcartEdit = (TextView) inflate.findViewById(R.id.tv_shopcart_edit);
        recyclerview = (RecyclerView) inflate.findViewById(R.id.recyclerview);
        llCheckAll = (LinearLayout) inflate.findViewById(R.id.ll_check_all);
        checkboxAll = (CheckBox) inflate.findViewById(R.id.checkbox_all);
        tvShopcartTotal = (TextView) inflate.findViewById(R.id.tv_shopcart_total);
        btnCheckOut = (Button) inflate.findViewById(R.id.btn_check_out);
        llDelete = (LinearLayout) inflate.findViewById(R.id.ll_delete);
        cbAll = (CheckBox) inflate.findViewById(R.id.cb_all);
        btnDelete = (Button) inflate.findViewById(R.id.btn_delete);
        btnCollection = (Button) inflate.findViewById(R.id.btn_collection);
        ivEmpty = (ImageView) inflate.findViewById(R.id.iv_empty);
        tvEmptyCartTobuy = (TextView) inflate.findViewById(R.id.tv_empty_cart_tobuy);
        ll_empty_shopcart = (LinearLayout) inflate.findViewById(R.id.ll_empty_shopcart);
        //设置点击事件
        btnCheckOut.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnCollection.setOnClickListener(this);

        //C.
        initListener();

        //返回布局对象

        return inflate;
    }

    @Override
    public View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return null;
    }

    private void initListener() {
//给编辑按钮设置状态标识,方便后面根据取出编辑按钮的标识做对应的逻辑操作
        tvShopcartEdit.setTag(ACTION_EDIT);
        //设置右上角编辑按钮的点击事件
        tvShopcartEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //取出在编辑按钮设置的状态标识
                int action = (int) view.getTag();
                //如果状态是完成状态,那么切换完成状态的布局
                if(action == ACTION_EDIT){
                    showDelete();
                }
                //如果状态是编辑状态,那么切换编辑状态的布局
                else{
                    hideDelete();
                }
            }
        });

    }
    //C.切换完成状态的布局
    private void showDelete() {
        //设置对应的文本和状态
        tvShopcartEdit.setTag(ACTION_COMPLETE);
        tvShopcartEdit.setText("完成");
        //变成非勾选
        if(mShoppingCartAdapter != null){
            //调用ShoppingCartAdapter里设置全选或非全选的方法,传个false,该方法要是public,放可调用
            mShoppingCartAdapter.checkAll_none(false);
            //C2.对全选复选按钮状态进行检查,设置对应的状态
            mShoppingCartAdapter.CheckboxAll();
        }
        //删除视图显示,结算视图隐藏
        llDelete.setVisibility(View.VISIBLE);
        llCheckAll.setVisibility(View.GONE);
    }

    //C.切换编辑状态的布局
    private void hideDelete() {
        //设置对应的文本和状态
        tvShopcartEdit.setTag(ACTION_EDIT);
        tvShopcartEdit.setText("编辑");
        //变成非勾选
        if(mShoppingCartAdapter != null){
            //调用ShoppingCartAdapter里设置全选或非全选的方法,传个false,该方法要是public,放可调用
            mShoppingCartAdapter.checkAll_none(true);
            //C2.对全选复选按钮状态进行检查,设置对应的状态
            mShoppingCartAdapter.CheckboxAll();
            //C3.对价格进行重新计算
            mShoppingCartAdapter.showTotalPrice();
        }
        //删除视图显示,结算视图隐藏
        llDelete.setVisibility(View.GONE);
        llCheckAll.setVisibility(View.VISIBLE);
    }


    @Override
    public void initPopMenuData() {
//        //A.打印出购物车模块的数据
//        List<GoodsBean> goodsBeanList = CartStorage.getInstance().getAllData();
///*        for (int x = 0; x < goodsBeanList.size(); x++) {
//            GoodsBean goodsBean = goodsBeanList.get(x);
//            String s = goodsBean.toString();
//            Log.e("SYDS", s);
//        }*/
//        //B.对数据进行非空判断,有对象,且内容大于0
//        if(goodsBeanList != null && goodsBeanList.size() >0){
//            //有数据,把在没有数据显示的布局--隐藏
//            ll_empty_shopcart.setVisibility(View.GONE);
//            //B.创建recyclerview适配器(这里写在一个新类里) 参数:上下文 要加载的Bean数据
////            mShoppingCartAdapter = new ShoppingCartAdapter(mContext,goodsBeanList);
//            //C.创建recyclerview适配器,因为商品加减价格计算用到的数据在适配器里,而控件对象在Fragment里,所以把框架对象传到适配器里完成
//            mShoppingCartAdapter = new ShoppingCartAdapter(mContext,goodsBeanList,tvShopcartTotal,checkboxAll,cbAll);
//
//
//            //设置recyclerview适配器
//            recyclerview.setAdapter(mShoppingCartAdapter);
//            //设置RecyclerView的布局管理器(否则RecycleView无法显示) 参数:上下文  定义其呈现方向
//            recyclerview.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
//            //E.在有数据的情况完成状态下显示上方的布局
//            tvShopcartEdit.setVisibility(View.VISIBLE);
//        }else{
//            //E.没有数据,购物车所执行的逻辑
//            emptShoppingCart();
//        }
//
//    }
//
//    private void emptShoppingCart() {
//        //没有数据,在没有数据显示的布局--显示
//        ll_empty_shopcart.setVisibility(View.VISIBLE);
//        //E.隐藏完成状态下显示上方的布局(这里隐藏了,就要在有数据的情况下去显示)
//        tvShopcartEdit.setVisibility(View.GONE);
//        //E.隐藏编译状态下下方删除的按钮
//        llDelete.setVisibility(View.GONE);
//    }
//    //E为使代码严谨,当Fragment获取焦点时,重新加载购物车布局的数据
//    @Override
//    public void onResume() {
//        super.onResume();
//        initPopMenuData();;
//    }
//    @Override
//    public void onClick(View view) {
//        if (view == btnCheckOut) {
//
//        }//D.点击完成状态下的删除按钮,删除选中的item
//        else if (view == btnDelete) {
//            //删除选中的item
//            mShoppingCartAdapter.deletData();
//            //检查全选的状态,进行状态设置
//            mShoppingCartAdapter.CheckboxAll();
//            //E.数据大小为0(判断适配器的Item是否为0条)时,显示空的布局资源,隐藏编译状态下下方删除的按钮
//            if(mShoppingCartAdapter.getItemCount()==0){
//                //E.没有数据,购物车所执行的逻辑
//                emptShoppingCart();
//            }
//        }
//        else if (view == btnCollection) {
//        }

    }

    @Override
    public void onClick(View view) {

    }
}
