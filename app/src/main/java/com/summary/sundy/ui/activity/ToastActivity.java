package com.summary.sundy.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.summary.common.base.BaseActivity;
import com.summary.common.utils.toast.ToastUtils;
import com.summary.common.utils.toast.style.ToastBlackStyle;
import com.summary.common.utils.toast.style.ToastQQStyle;
import com.summary.common.utils.toast.style.ToastWhiteStyle;
import com.summary.sundy.R;

public class ToastActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.sy_toast_layout;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }

    public void show1(final View v) {
        ToastUtils.show("我是吐司");
    }

    public void show2(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ToastUtils.show("我是子线程中弹出的吐司");
            }
        }).start();
    }

    public void show3(View v) {
        ToastUtils.initStyle(new ToastWhiteStyle());
        ToastUtils.show("动态切换吐司样式成功");
    }

    public void show4(View v) {
        ToastUtils.initStyle(new ToastBlackStyle());
        ToastUtils.show("动态切换吐司样式成功");
    }

    public void show5(View v) {
        ToastUtils.initStyle(new ToastQQStyle());
        ToastUtils.show("QQ样式那种还不简单，分分钟的事");
    }

    public void show6(View v) {
        ToastUtils.setView(this, R.layout.toast_custom_view);
        ToastUtils.show("我是自定义Toast");
    }
}
