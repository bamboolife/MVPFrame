package com.summary.sundy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.summary.common.view.UIButton;

import butterknife.ButterKnife;


public class FrameMainLayoutActivity extends AppCompatActivity {
    UIButton uiButton;

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

       // tv_one.setText("asdfasdfasdfasdfasd");
    }
}
