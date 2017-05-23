package com.redbaby.utils;

import com.google.gson.Gson;

/**
 * Created by Administrator on 2017/3/16.
 */

public class GsonUtil {

    /**
     * 将传入的json字符串按类模板解析成对象
     * @param jsondata  需要解析的json字符串
     * @param cla 类模板
     * @param <T> 泛型的默认值，可以被任意类型所代替
     * @return 解析好的对象
     */
    public static <T>T getBean(String jsondata,Class<T> cla){
        Gson gson = new Gson();
        T bean = gson.fromJson(jsondata, cla);
        return bean;
    }

    /**
     * 传入的对象按类模板解析成json字符串
     * @param bean 需要解析的对象
     * @param <T> 泛型的默认值，可以被任意类型所代替
     * @return 解析完成的json字符串
     */
    public static <T> String getJson(T bean){
        Gson gson = new Gson();
        String data = gson.toJson(bean);
        return data;
    }
}
