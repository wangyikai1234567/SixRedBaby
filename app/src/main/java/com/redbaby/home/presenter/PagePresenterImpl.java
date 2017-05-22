package com.redbaby.home.presenter;


import com.redbaby.home.model.PageModelImpl;
import com.redbaby.home.view.PageView;

/**
 * 用途：
 * author：王倩凤Administrator
 * date:2017/5/17.
 */

public class PagePresenterImpl implements PagePresenter,PagepresenterListener{
        private final PageView pageView;
    private final PageModelImpl pageModelImpl;
    private String mString;

    public PagePresenterImpl(PageView pageView) {
        this.pageView = pageView;
        this.pageModelImpl = new PageModelImpl();
    }


    @Override
    public void validateCredentials(String uri) {
        pageModelImpl.get(uri,this);//将数据传到m层
    }



    @Override
    public void onRequesteError() {
        pageView.setDateError();
    }

    @Override
    public void onRequestSuccess(String date) {

        pageView.setDateSuccess(date);
    }
}
