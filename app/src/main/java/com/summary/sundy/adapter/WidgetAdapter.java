package com.summary.sundy.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.summary.sundy.R;
import com.summary.sundy.model.WidgetModel;

import java.util.List;

/**
 * 控件适配器
 */
public class WidgetAdapter extends BaseQuickAdapter<WidgetModel, BaseViewHolder> {
    public WidgetAdapter(List<WidgetModel> data) {
        super(R.layout.sy_widget_item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WidgetModel item) {
        helper.setText(R.id.tv_widget_name, item.title);
        helper.setText(R.id.tv_widget_des, item.content);
    }
}
