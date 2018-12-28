package com.summary.sundy;

import com.summary.common.base.BaseApplication;
import com.summary.common.utils.toast.ToastUtils;
import com.summary.sundy.mvp.component.DaggerAppComponent;

import okhttp3.internal.http.HttpHeaders;

public class SundyApplication extends BaseApplication {


    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.create().inject(this);
        ToastUtils.init(this);
        initWebView();


    }

    /**
     * 初始化webview
     */
    private void initWebView() {
        /**
         * 说明， WebView 初处初始化耗时 250ms 左右。
         * 提前初始化WebView ，好处可以提升页面初始化速度，减少白屏时间，
         * 坏处，拖慢了App 冷启动速度，如果 WebView 配合 VasSonic 使用，
         * 建议不要在此处提前初始化 WebView 。
         */
//        WebView mWebView=new WebView(new MutableContextWrapper(this));
    }


}

