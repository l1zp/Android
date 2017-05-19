package com.example.lizp.networktest;

/**
 * Created by Lizp on 2017/5/19.
 */

public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
