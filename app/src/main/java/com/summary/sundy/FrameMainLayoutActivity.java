package com.summary.sundy;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.summary.common.view.EasySplashScreen;
import com.summary.common.view.UIButton;
import com.summary.sundy.databinding.FrameMainLayoutBinding;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FrameMainLayoutActivity extends AppCompatActivity {
    UIButton uiButton;
    @BindView(R.id.tv_one)
    TextView tv_one;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    // FrameMainLayoutBinding mBinding= DataBindingUtil.setContentView(this,R.layout.frame_main_layout);
//        EasySplashScreen config=new EasySplashScreen(this)
//                .withFullScreen()
//                .withFooterText("我是尾部")
//                .withHeaderText("我是头部");
//        setContentView(config.create());
        setContentView(R.layout.frame_main_layout);
        ButterKnife.bind(this);

        tv_one.setText("asdfasdfasdfasdfasd");
    }
}
