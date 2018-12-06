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
import com.summary.sundy.adapter.EditTextStyleAdapter;
import com.summary.sundy.model.WidgetModel;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 各种样式的EditText
 */
public class EditTextStyleActivity extends BaseActivity {
    @BindView(R.id.rv_content)
    RecyclerView mRecyclerView;
    EditTextStyleAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.sy_edit_text_style_layout;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        initRecyclerView();
    }

    private void initRecyclerView() {
        adapter = new EditTextStyleAdapter(getData());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext));
        mRecyclerView.setAdapter(adapter);
    }

    private List<WidgetModel> getData() {
        List<WidgetModel> items = new ArrayList<>();
        items.add(new WidgetModel("XEditText", "XEditText的各种使用用例", XEditTextActivity.class));
        return items;
    }

    @Override
    public void initListeners() {
        super.initListeners();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                WidgetModel model = (WidgetModel) adapter.getItem(position);
                Intent intent = new Intent(mContext, model.activity);
                startActivity(intent);
            }
        });
    }
}
