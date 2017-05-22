package com.redbaby.home.view;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.chanven.lib.cptr.PtrDefaultHandler;
import com.chanven.lib.cptr.PtrFrameLayout;
import com.redbaby.R;
import com.redbaby.home.presenter.PagePresenterImpl;


public class HomeFragment extends Fragment implements PageView{


    private View mView;
    private RecyclerView mRecyclerView;
    private PagePresenterImpl mPresenter;
    private TextView mTextView;
    private ParallaxPtrFrameLayout mParallaxPtrFrameLayout;
    Handler handler = new Handler();

    public static HomeFragment getFragment(String uri){
        HomeFragment pageFragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("content",uri);
        pageFragment.setArguments(bundle);

        return pageFragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_home, container, false);

        mPresenter = new PagePresenterImpl(this);

        return mView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //mRecyclerView = (RecyclerView) mView.findViewById(R.id.recyclerView_F);

        mParallaxPtrFrameLayout = (ParallaxPtrFrameLayout) mView.findViewById(R.id.home_vp_ParallaxPtrFrameLayout);
        mTextView = (TextView) mView.findViewById(R.id.textv);

        Bundle bundle = getArguments();
        String uri = bundle.getString("content");
        mPresenter.validateCredentials(uri);//将uri传递到p层
    }

    @Override
    public void setDateError() {
        Toast.makeText(getActivity(), "网络异常，请稍后重试", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void setDateSuccess(final String date) {
       /* Gson gson = new Gson();
        Bean_main bean_main = gson.fromJson(date, Bean_main.class);
        List<Bean_main.DataBean> list = bean_main.getData();*/

        mParallaxPtrFrameLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mParallaxPtrFrameLayout.refreshComplete();
                    }
                },1000);
            }
        });

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mTextView.setText(date);

            }
        });


       // mRecyclerView.setAdapter(new MyAdapter(getActivity(),list));//给RecyclerView设置适配器
    }
}
