package com.summary.sundy.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.summary.sundy.R;
import com.summary.sundy.model.WidgetModel;

import java.util.List;

public class LayoutAdapter extends BaseQuickAdapter<WidgetModel, BaseViewHolder> {
    public LayoutAdapter( @Nullable List<WidgetModel> data) {
        super(R.layout.sy_widget_item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WidgetModel item) {
        helper.setText(R.id.tv_widget_name, item.title);
        helper.setText(R.id.tv_widget_des, item.content);
    }
}
