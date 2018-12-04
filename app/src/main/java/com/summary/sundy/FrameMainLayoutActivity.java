package com.summary.sundy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.summary.common.base.BaseActivity;
import com.summary.common.service.FloatingService;
import com.summary.common.utils.LogUtil;
import com.summary.common.view.BottomDialog;
import com.summary.common.view.MainNavigateTabBar;
import com.summary.common.view.UIButton;
import com.summary.sundy.ui.fragment.FindFragment;
import com.summary.sundy.ui.fragment.HomeFragment;
import com.summary.sundy.ui.fragment.MomentsFragment;
import com.summary.sundy.ui.fragment.PersonFragment;
import com.summary.sundy.ui.fragment.RxFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FrameMainLayoutActivity extends BaseActivity {
    @BindView(R.id.navigateTabBar)
    MainNavigateTabBar mNavigateTabBar;

    @Override
    protected int getLayoutId() {

        return R.layout.activity_main;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        //恢复选项状态
        mNavigateTabBar.onRestoreInstanceState(savedInstanceState);
        mNavigateTabBar.addTab(HomeFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.ic_tab_bar_home, R.mipmap.ic_tab_bar_mine_selected, R.string.tab_bar_text_home));
        mNavigateTabBar.addTab(MomentsFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.ic_tab_bar_moments, R.mipmap.ic_tab_bar_moments_selected, R.string.tab_bar_text_moments));
        mNavigateTabBar.addTab(FindFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.ic_tab_bar_find, R.mipmap.ic_tab_bar_find_selected, R.string.tab_bar_text_find));
        mNavigateTabBar.addTab(RxFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.ic_tab_bar_find, R.mipmap.ic_tab_bar_find_selected, R.string.tab_bar_text_rx));
        mNavigateTabBar.addTab(PersonFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.ic_tab_bar_person, R.mipmap.ic_tab_bar_person_selected, R.string.tab_bar_text_person));
    }


    @Override
    public void initService() {
        super.initService();
        floatingService.setOnStatusBarClickListener(new FloatingService.OnStatusBarClickListener() {
            @Override
            public void onClick() {

            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //保存当前选中的选项状态
        mNavigateTabBar.onSaveInstanceState(outState);
    }

}
