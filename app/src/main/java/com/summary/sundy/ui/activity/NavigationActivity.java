package com.summary.sundy.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.summary.common.base.BaseActivity;
import com.summary.common.view.itemdecoration.DividerItemDecoration;
import com.summary.sundy.R;
import com.summary.sundy.adapter.NavigationAdapter;
import com.summary.sundy.model.WidgetModel;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 底部导航控制器集合
 */
public class NavigationActivity extends BaseActivity {
    @BindView(R.id.rv_content)
    RecyclerView mRecyclerView;
    NavigationAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.sy_navigation_layout;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        initRecycleView();
    }

    public void initRecycleView() {
        mAdapter = new NavigationAdapter(getData());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext));
        mRecyclerView.setAdapter(mAdapter);
    }

    private List<WidgetModel> getData() {
        List<WidgetModel> items = new ArrayList<>();
        items.add(new WidgetModel("TabBar style1", "底部控制器实现方式1", NavigationStyleActivity.class));
        items.add(new WidgetModel("TabBar style2", "底部控制器实现方式2", NavigationActivity.class));
        items.add(new WidgetModel("TabBar style3", "底部控制器实现方式3", NavigationActivity.class));
        items.add(new WidgetModel("TabBar style4", "底部控制器实现方式4", NavigationActivity.class));

        return items;
    }

    @Override
    public void initListeners() {
        super.initListeners();
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                WidgetModel model= (WidgetModel) adapter.getItem(position);
                Intent intent=new Intent(mContext,model.activity);
                startActivity(intent);
            }
        });
    }
}
