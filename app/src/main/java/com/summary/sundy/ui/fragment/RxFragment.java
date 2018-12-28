package com.summary.sundy.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.summary.common.base.BaseFragment;
import com.summary.common.view.itemdecoration.DividerItemDecoration;
import com.summary.sundy.R;
import com.summary.sundy.adapter.WidgetAdapter;
import com.summary.sundy.model.WidgetModel;
import com.summary.sundy.ui.activity.OperatorsActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class RxFragment extends BaseFragment {
    @BindView(R.id.rv_content)
    RecyclerView mRecyclerView;
    WidgetAdapter adapter;
    @Override
    protected int getLayoutId() {
        return R.layout.sy_rx_layout;
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
        widgetModels.add(new WidgetModel("Rxjava操作符","Rxjava各种操作符的各种使用",OperatorsActivity.class));
        return widgetModels;
    }

    @Override
    protected void initListeners() {
        super.initListeners();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent=new Intent(mContext,OperatorsActivity.class);
                startActivity(intent);
            }
        });
    }
}
