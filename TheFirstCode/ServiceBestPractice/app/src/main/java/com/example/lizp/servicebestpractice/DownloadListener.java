package com.example.lizp.servicebestpractice;

/**
 * Created by Lizp on 2017/5/22.
 */

public interface DownloadListener {
    void onProgress(int progress);
    void onSuccess();
    void onFailed();
    void onPaused();
    void onCancled();
}
