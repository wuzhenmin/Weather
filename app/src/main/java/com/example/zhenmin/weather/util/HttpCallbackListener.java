package com.example.zhenmin.weather.util;

/**
 * Created by zhenmin on 2015/10/28.
 */
public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
