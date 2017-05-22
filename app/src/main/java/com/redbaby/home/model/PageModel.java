package com.redbaby.home.model;


import com.redbaby.home.presenter.PagepresenterListener;

/**
 * 用途：
 * author：王倩凤Administrator
 * date:2017/5/17.
 */

public interface PageModel {

    /**
     * 异步post  参数为对象
     * @param url
     * @param obj
     * @param callback
     */
   // void post(String url,Object obj,Callback callback);
    /**
     * 异步post  参数为json
     * @param url
     * @param json
     * @param callback
     */
    //void post(String url, String json, Callback callback);
    /**
     * 异步post 参数为Map
     * @param url
     * @param map
     * @param callback
     */
    //void post(String url, Map<String,String> map, Callback callback);
    /**
     * 异步get
     * @param url
     * @return
     */
    //String get(String url, Callback callback);
    /**
     * 同步get
     * @param url
     * @return
     */
    void get(String url, PagepresenterListener listener);
}
