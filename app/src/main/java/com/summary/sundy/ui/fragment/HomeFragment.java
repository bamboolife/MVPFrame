package com.summary.sundy.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.summary.common.base.BaseFragment;
import com.summary.common.utils.DensityUtils;
import com.summary.common.view.itemdecoration.RecyclerViewDividerTool;
import com.summary.sundy.R;
import com.summary.sundy.adapter.WidgetAdapter;
import com.summary.sundy.model.WidgetModel;
import com.summary.sundy.ui.activity.BlurActivity;
import com.summary.sundy.ui.activity.CustomViewActivity;
import com.summary.sundy.ui.activity.DialogActivity;
import com.summary.sundy.ui.activity.DrawerLayoutActivity;
import com.summary.sundy.ui.activity.EditTextStyleActivity;
import com.summary.sundy.ui.activity.GuavaActivity;
import com.summary.sundy.ui.activity.InputLayoutActivity;
import com.summary.sundy.ui.activity.ItemTouchHelperActivity;
import com.summary.sundy.ui.activity.NavigationActivity;
import com.summary.sundy.ui.activity.PopupWindowActivity;
import com.summary.sundy.ui.activity.ProgressActivity;
import com.summary.sundy.ui.activity.RxBusActivity;
import com.summary.sundy.ui.activity.Segmented2Activity;
import com.summary.sundy.ui.activity.SegmentedActivity;
import com.summary.sundy.ui.activity.SheetViewActivity;
import com.summary.sundy.ui.activity.ShopWidgetActivity;
import com.summary.sundy.ui.activity.SwitchMapActivity;
import com.summary.sundy.ui.activity.TitleBarActivity;
import com.summary.sundy.ui.activity.ToastActivity;
import com.summary.sundy.ui.activity.UITabViewActivity;
import com.summary.sundy.ui.activity.WebActivity;
import com.sundy.map.SmoothActivity;

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
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext,3));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new RecyclerViewDividerTool(DensityUtils.dp2px(mContext,5f)));
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
        widgetModels.add(new WidgetModel("NavigationTabBar","底部导航控制器",NavigationActivity.class));
        widgetModels.add(new WidgetModel("Progress","各种样式的进度条",ProgressActivity.class));
        widgetModels.add(new WidgetModel("商城控件","各种样式的商城控件",ShopWidgetActivity.class));
        widgetModels.add(new WidgetModel("分段控制器","不同方式实现的分段控制器",SegmentedActivity.class));
        widgetModels.add(new WidgetModel("分段控制器2","不同方式实现的分段控制器", Segmented2Activity.class));
        widgetModels.add(new WidgetModel("MapView","地图的各种使用",SmoothActivity.class));
        widgetModels.add(new WidgetModel("聊天界面","聊天界面的各种实现",InputLayoutActivity.class));
        widgetModels.add(new WidgetModel("RxBus","Rxbus的实现和使用用例",RxBusActivity.class));
        widgetModels.add(new WidgetModel("Guava","Google guava的使用用例",GuavaActivity.class));
        widgetModels.add(new WidgetModel("Blur","使控件模糊的容器", BlurActivity.class));
        widgetModels.add(new WidgetModel("Dialog","各种方式实现的Dialog样式", DialogActivity.class));
        widgetModels.add(new WidgetModel("SheetView","各种方式实现的底部弹窗", SheetViewActivity.class));
        widgetModels.add(new WidgetModel("Drawer","android侧滑的实现", DrawerLayoutActivity.class));
        widgetModels.add(new WidgetModel("地图切换","高德地图和google地图切换", SwitchMapActivity.class));
        widgetModels.add(new WidgetModel("ItemTouchHelper","item拖动和位置交换", ItemTouchHelperActivity.class));
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
