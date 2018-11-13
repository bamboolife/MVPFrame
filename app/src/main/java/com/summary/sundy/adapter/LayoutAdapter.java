package com.summary.sundy.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.summary.sundy.R;
import com.summary.sundy.model.LayoutModel;

import java.util.List;

public class LayoutAdapter extends BaseQuickAdapter<LayoutModel, BaseViewHolder> {
    public LayoutAdapter( @Nullable List<LayoutModel> data) {
        super(R.layout.sy_layout_item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, LayoutModel item) {
        helper.setText(R.id.tv_layout_name, item.title);
        helper.setText(R.id.tv_layout_des, item.content);
    }
}
