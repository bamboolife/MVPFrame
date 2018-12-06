package com.summary.sundy.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.summary.common.base.BaseActivity;
import com.summary.sundy.R;

import butterknife.BindView;

public class WebActivity extends BaseActivity {
    @BindView(R.id.rv_content)
    RecyclerView mRecyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.sy_web_layout;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
      initRecyclerView();
    }

    private void initRecyclerView() {

    }

}
