package com.summary.sundy.ui.activity;

import android.os.Bundle;

import com.summary.common.base.BaseActivity;
import com.summary.common.view.navigate.style2.BottomBar;
import com.summary.sundy.R;
import com.summary.sundy.ui.fragment.FindFragment;
import com.summary.sundy.ui.fragment.PersonFragment;
import com.summary.sundy.ui.fragment.RxFragment;

import butterknife.BindView;

public class NavigationStyle2Activity extends BaseActivity {
    @BindView(R.id.bottom_bar)
    BottomBar mBottomBar;
    @Override
    protected int getLayoutId() {
        return R.layout.sy_navigation_style_two_layout;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        mBottomBar.setContainer(R.id.fl_container)
                .setTitleBeforeAndAfterColor("#999999", "#ff5d5e")
                .addItem(FindFragment.class,
                        "首页",
                        R.mipmap.ic_tab_bar_home,
                        R.mipmap.ic_tab_bar_mine_selected)
                .addItem(RxFragment.class,
                        "订单",
                        R.mipmap.ic_tab_bar_moments,
                        R.mipmap.ic_tab_bar_moments_selected)
                .addItem(PersonFragment.class,
                        "我的",
                        R.mipmap.ic_tab_bar_find,
                        R.mipmap.ic_tab_bar_find_selected)
                .build();
    }
}
