package com.redbaby.home.presenter;

/**
 * 用途：
 * author：王倩凤Administrator
 * date:2017/5/17.
 */

public interface PagepresenterListener {
    //用于得到model层处理后返回的结果
    void onRequesteError();
    void onRequestSuccess(String date);
}
