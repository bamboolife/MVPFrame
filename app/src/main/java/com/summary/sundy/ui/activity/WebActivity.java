package com.summary.sundy.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.summary.common.base.BaseActivity;
import com.summary.common.view.itemdecoration.DividerItemDecoration;
import com.summary.sundy.R;
import com.summary.sundy.adapter.WebWidgetAdapter;
import com.summary.sundy.model.WidgetModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class WebActivity extends BaseActivity {
    @BindView(R.id.rv_content)
    RecyclerView mRecyclerView;
    WebWidgetAdapter mAdapter;
    @Override
    protected int getLayoutId() {
        return R.layout.sy_web_layout;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
      initRecyclerView();
    }

    private void initRecyclerView() {
       mAdapter=new WebWidgetAdapter(getData());
       mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
       mRecyclerView.setItemAnimator(new DefaultItemAnimator());
       mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext));
       mRecyclerView.setAdapter(mAdapter);
    }

    private List<WidgetModel> getData() {
        List<WidgetModel> items=new ArrayList<>();
        items.add(new WidgetModel("Activity 使用 AgentWeb","",WebActivity.class));
        items.add(new WidgetModel("Fragment 使用 AgentWeb","",WebActivity.class));
        items.add(new WidgetModel("文件下载","",WebActivity.class));
        items.add(new WidgetModel("input标签文件上传","",WebActivity.class));
        items.add(new WidgetModel("Js 通信文件上传,兼用Android 4.4Kitkat","",WebActivity.class));
        items.add(new WidgetModel("Js 通信","",WebActivity.class));
        items.add(new WidgetModel("Video 视频全屏播放","",WebActivity.class));
        items.add(new WidgetModel("自定义进度条","",WebActivity.class));
        items.add(new WidgetModel("自定义设置","",WebActivity.class));
        items.add(new WidgetModel("电话 ， 信息 ， 邮件","",WebActivity.class));
        items.add(new WidgetModel("自定义 WebView","",WebActivity.class));
        items.add(new WidgetModel("下拉回弹效果","",WebActivity.class));
        items.add(new WidgetModel("Jsbridge 例子","",WebActivity.class));
        items.add(new WidgetModel("继承 BaseAgentWebActivity","",WebActivity.class));
        items.add(new WidgetModel("继承 BaseAgentWebFragment","",WebActivity.class));
        items.add(new WidgetModel(" 下拉刷新","",WebActivity.class));
        items.add(new WidgetModel("地图","",WebActivity.class));
        items.add(new WidgetModel("VasSonic 首屏秒开","",WebActivity.class));
        items.add(new WidgetModel("与ToolBar联动","",WebActivity.class));
        return items;
    }

}
