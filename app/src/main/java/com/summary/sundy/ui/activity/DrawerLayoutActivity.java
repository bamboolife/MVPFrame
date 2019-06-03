package com.summary.sundy.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.summary.common.base.BaseActivity;
import com.summary.common.view.drawer.SideslipLayout;
import com.summary.common.view.drawer.SideslipViewItem;
import com.summary.sundy.R;

import butterknife.BindView;

/**
 * 侧滑集合
 */
public class DrawerLayoutActivity extends BaseActivity {
    @BindView(R.id.sideslip_layout)
    SideslipLayout mSideslipLayout;
    @Override
    protected int getLayoutId() {
        return R.layout.sy_drawer_layout_layout;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
     initDrawer();
    }

    private void initDrawer() {
        //主界面
        View homeView = LayoutInflater.from(this).inflate(R.layout.sy_guava_layout, null, false);

        mSideslipLayout.setHomeView(homeView);

        //左边的侧滑菜单
        View leftView = LayoutInflater.from(this).inflate(R.layout.left_layout, null, false);
        mSideslipLayout.setLeftViewItem(new SideslipViewItem(leftView, 0.7f));
        View rightView = LayoutInflater.from(this).inflate(R.layout.right_layout,null,false);
        mSideslipLayout.setRightViewItem(new SideslipViewItem(rightView,0.7f));
        //底部的界面
        View bottomView = LayoutInflater.from(this).inflate(R.layout.bottom_layout, null, false);
        mSideslipLayout.setTopViewItem(new SideslipViewItem(bottomView, 1f));

        mSideslipLayout.setOnSideslipListener(new SideslipLayout.OnSideslipListener() {
            @Override
            public void onShow(int gravity) {
                Log.i("log_gravity", "onShow: " + gravity);
            }

            @Override
            public void onHide(int gravity) {
                Log.i("log_gravity", "onHide: " + gravity);
            }
        });

    }
}
