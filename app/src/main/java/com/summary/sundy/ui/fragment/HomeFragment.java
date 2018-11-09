package com.summary.sundy.ui.fragment;


import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.summary.common.base.BaseFragment;
import com.summary.common.view.itemdecoration.DividerItemDecoration;
import com.summary.sundy.MainActivity;
import com.summary.sundy.R;
import com.summary.sundy.adapter.WidgetAdapter;
import com.summary.sundy.model.WidgetModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 控件集合
 */
public class HomeFragment extends BaseFragment {
    @BindView(R.id.rv_content)
    RecyclerView mRecyclerView;
    WidgetAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.sy_home_widget_layout;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
       initRecyclerView();
    }

    private void initRecyclerView() {
        adapter=new WidgetAdapter(getData());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext));
        mRecyclerView.setAdapter(adapter);
    }

    private List<WidgetModel> getData() {
        List<WidgetModel> widgetModels=new ArrayList<>();
        widgetModels.add(new WidgetModel("Toobar","afdadfasdfasdfasdfasd",MainActivity.class));
        return widgetModels;
    }

}
