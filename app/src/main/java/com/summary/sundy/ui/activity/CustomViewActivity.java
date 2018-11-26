package com.summary.sundy.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.summary.common.base.BaseActivity;
import com.summary.common.view.AuditProgressView;
import com.summary.common.view.MultiCircleDrawable;
import com.summary.common.view.UISwitchButton;
import com.summary.sundy.R;

import butterknife.BindView;

/**
 * 自定义View
 */
public class CustomViewActivity extends BaseActivity {
    @BindView(R.id.switch_button)
    UISwitchButton switchButton;
    @BindView(R.id.iv_anim_v)
    ImageView imgView;
    @BindView(R.id.flt)
    FrameLayout frameLayout;
    @BindView(R.id.ll_audit_content)
    LinearLayout content;
    @Override
    protected int getLayoutId() {
        return R.layout.gy_custom_view_layout;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        switchButton.setChecked(true);
        switchButton.isChecked();
        switchButton.toggle();     //switch state
        switchButton.toggle(false);//switch without animation
        switchButton.setShadowEffect(true);//disable shadow effect
        switchButton.setEnabled(false);//disable button
        switchButton.setEnableEffect(false);//disable the switch animation
        switchButton.setOnCheckedChangeListener(new UISwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(UISwitchButton view, boolean isChecked) {
                //TODO do your job
            }
        });
        imgView.setImageDrawable(new MultiCircleDrawable());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        MultiCircleDrawable drawable = (MultiCircleDrawable) imgView.getDrawable();
                        drawable.start();
                    }
                });

            }
        },3000);
        content.addView(createView(5, true, true, true, false, "提交申请"));
        content.addView(createView(5, true, true, false, false, "审查"));
        content.addView(createView(5, true, true, false, false, "审核"));
        content.addView(createView(5, true, false, false, false, "退款"));
        content.addView(createView(5, false, false, false, false, "完成"));
        content.addView(createView(5, false, false, false, true, "关闭"));
    }

    public AuditProgressView createView(int stepCount, boolean isCurrentComplete, boolean isNextComplete, boolean isFirstStep, boolean isLastStep, String text) {
        AuditProgressView view = new AuditProgressView(this);
        view.setStepCount(stepCount);
        view.setIsCurrentComplete(isCurrentComplete);
        view.setIsNextComplete(isNextComplete);
        view.setIsFirstStep(isFirstStep);
        view.setIsLastStep(isLastStep);
        view.setText(text);
        return view;
    }
}
