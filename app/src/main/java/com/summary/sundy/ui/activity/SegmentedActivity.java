package com.summary.sundy.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.summary.common.base.BaseActivity;
import com.summary.common.view.segmented.UISegmentView;
import com.summary.sundy.R;
import com.summary.sundy.adapter.ViewPagerAdapter;
import com.summary.sundy.ui.fragment.FindFragment;
import com.summary.sundy.ui.fragment.PersonFragment;
import com.summary.sundy.ui.fragment.RxFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class SegmentedActivity extends BaseActivity {
    @BindView(R.id.bar)
    UISegmentView mUISegmentView;
    @BindView(R.id.viewpager)
    ViewPager mViewPager;
    private List<Fragment> fragments;
    ViewPagerAdapter mAdapter;
    private String[] titles2 = new String[]{"标题一", "标题二","标题三"};
    @Override
    protected int getLayoutId() {
        return R.layout.sy_segmented_layout;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        fragments=new ArrayList<>();
        fragments.add(new FindFragment());
        fragments.add(new RxFragment());
        fragments.add(new PersonFragment());
        mAdapter=new ViewPagerAdapter(getSupportFragmentManager(),fragments);
        mViewPager.setAdapter(mAdapter);
        mUISegmentView.setViewPager(this, titles2, mViewPager, R.drawable.drawable_left, R.drawable.drawable_mid, R.drawable.drawable_right, R.color.color_ffffff, R.color.color_282d31, 16, 0, 1f, true);
    }
}
