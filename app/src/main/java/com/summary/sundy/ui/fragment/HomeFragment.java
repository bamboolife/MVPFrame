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
import com.summary.sundy.MainActivity;
import com.summary.sundy.R;
import com.summary.sundy.adapter.WidgetAdapter;
import com.summary.sundy.model.WidgetModel;
import com.summary.sundy.ui.activity.CustomViewActivity;
import com.summary.sundy.ui.activity.EditTextStyleActivity;
import com.summary.sundy.ui.activity.PopupWindowActivity;
import com.summary.sundy.ui.activity.TitleBarActivity;
import com.summary.sundy.ui.activity.ToastActivity;
import com.summary.sundy.ui.activity.UITabViewActivity;
import com.summary.sundy.ui.activity.WebActivity;

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
        widgetModels.add(new WidgetModel("TitleBar","各种样式的顶部titlebar",TitleBarActivity.class));
        widgetModels.add(new WidgetModel("EditText","EditText的各种风格个自定义样式",EditTextStyleActivity.class));
        widgetModels.add(new WidgetModel("PopupWindow","PopupWinodw的各种使用",PopupWindowActivity.class));
        widgetModels.add(new WidgetModel("自定义View","多种自定义view的方式",CustomViewActivity.class));
        widgetModels.add(new WidgetModel("UITabView","自定义UITabView",UITabViewActivity.class));
        widgetModels.add(new WidgetModel("Toast","可以修改样式的Toast",ToastActivity.class));
        widgetModels.add(new WidgetModel("WebView","WebView的使用",WebActivity.class));
        widgetModels.add(new WidgetModel("NavigationTabBar","底部导航控制器",WebActivity.class));
        return widgetModels;
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
