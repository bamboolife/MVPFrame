package com.summary.common.view;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.summary.common.R;
import com.summary.common.databinding.CommonSplashLayoutBinding;
import com.summary.common.model.SplashModel;

/**
 * 引导页
 */
public class EasySplashScreen {
    Activity mActivity;
    private int SPLASH_TIME_OUT = 2000;
    private Class<?> TargetActivity = null;
    Bundle bundle = null;
    SplashModel viewModel;
    CommonSplashLayoutBinding mBinding;

    public EasySplashScreen(Activity activity) {
        this.mActivity = activity;
        mBinding = DataBindingUtil.setContentView(activity, R.layout.common_splash_layout);
        viewModel = new SplashModel();
        mBinding.setViewModel(viewModel);
    }

    /**
     * 设置全屏
     *
     * @return
     */
    public EasySplashScreen withFullScreen() {
        mActivity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return this;
    }

    /**
     * 目标跳转activity
     *
     * @param tAct
     * @return
     */
    public EasySplashScreen withTargetActivity(Class<?> tAct) {
        this.TargetActivity = tAct;
        return this;
    }

    /**
     * @param bundle
     * @return
     */
    public EasySplashScreen withBundleExtras(Bundle bundle) {
        this.bundle = bundle;
        return this;
    }

    /**
     * 背景资源
     *
     * @param color
     * @return
     */
    public EasySplashScreen withBackgroundColor(int color) {

        return this;
    }

    public EasySplashScreen withBackgroundResource(int resource) {

        return this;
    }

    /**
     * 设置activity跳转时间
     *
     * @param timeOut
     * @return
     */
    public EasySplashScreen withSplashTimeOut(int timeOut) {
        this.SPLASH_TIME_OUT = timeOut;
        return this;
    }

    /**
     * 修改引导页面的logo
     *
     * @param logo
     * @return
     */
    public EasySplashScreen withLogo(int logo) {

        return this;
    }

    /**
     * 设置头部的文字
     *
     * @param text
     * @return
     */
    public EasySplashScreen withHeaderText(String text) {
        viewModel.setHeaderText(text);
        return this;
    }

    /**
     * 设置底部文字
     *
     * @param text
     * @return
     */
    public EasySplashScreen withFooterText(String text) {
        viewModel.setFooterText(text);
        return this;
    }

    public EasySplashScreen withBeforeLogoText(String text) {

        return this;
    }

    public EasySplashScreen withAfterLogoText(String text) {

        return this;
    }

    public TextView getHeaderTextView() {
        return mBinding.textView;
    }

    public View create() {
        setUpHandler();
        return mBinding.getRoot();
    }

    private void setUpHandler() {
        if (TargetActivity != null) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(mActivity, TargetActivity);
                    if (bundle != null) {
                        i.putExtras(bundle);
                    }
                    mActivity.startActivity(i);
                    // close splash
                    mActivity.finish();
                }
            }, SPLASH_TIME_OUT);
        }
    }
}
