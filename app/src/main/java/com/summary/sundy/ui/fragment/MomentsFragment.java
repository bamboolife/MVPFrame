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
import com.summary.sundy.adapter.LayoutAdapter;
import com.summary.sundy.model.WidgetModel;
import com.summary.sundy.ui.activity.CoordinatorActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class MomentsFragment extends BaseFragment {
    @BindView(R.id.rv_content)
    RecyclerView mRecyclerView;
     LayoutAdapter adapter;
    @Override
    protected int getLayoutId() {
        return R.layout.frame_main_layout;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
      initRecyclerView();
    }
    private void initRecyclerView() {
        adapter=new LayoutAdapter(getdata());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext));
        mRecyclerView.setAdapter(adapter);
    }

    private List<WidgetModel> getdata() {
        List<WidgetModel> items=new ArrayList<>();
        items.add(new WidgetModel("CoordinatorLayout","CoordinatorLayout布局各种的使用",CoordinatorActivity.class));
        items.add(new WidgetModel("VLayout","Vlayout的使用",CoordinatorActivity.class));
        return items;
    }

    @Override
    protected void initListeners() {
        super.initListeners();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                WidgetModel model= (WidgetModel) adapter.getItem(position);
                Intent intent=new Intent(mContext,model.activity);
                startActivity(intent);
            }
        });
    }
}
