package com.summary.sundy.ui.activity;

import android.os.Bundle;

import com.summary.common.base.BaseActivity;
import com.summary.common.view.segmented.IOSIndicator;
import com.summary.sundy.R;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

public class Segmented2Activity extends BaseActivity {
    @BindView(R.id.indicator)
    IOSIndicator indicator;
    List<String> titles = Arrays.asList("首页", "社区", "我");
    @Override
    protected int getLayoutId() {
        return R.layout.sy_segmented_two_layout;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        indicator.setItemTitles(titles);

        //主动切换 切换监听
        indicator.setSwitchListener(new IOSIndicator.ClickListener() {
            @Override
            public void onClick(int currentIndex, boolean isRepeat) {
                if (!isRepeat) {
                    System.out.println("点击了--" + currentIndex);
                }
            }
        });
    }
}
