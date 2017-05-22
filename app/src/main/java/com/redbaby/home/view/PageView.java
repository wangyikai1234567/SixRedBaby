package com.redbaby.home.view;

/**
 * 用途：
 * author：王倩凤Administrator
 * date:2017/5/17.
 */

public interface PageView {
    void setDateError();//数据请求失败
    void setDateSuccess(String date);//数据请求成功
}
