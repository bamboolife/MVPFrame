package com.summary.sundy.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.summary.sundy.R;
import com.summary.sundy.model.PopupModel;

import java.util.List;

public class PopupStyleAdapter extends BaseQuickAdapter<PopupModel,BaseViewHolder> {
    public PopupStyleAdapter( @Nullable List<PopupModel> data) {
        super(R.layout.sy_popup_window_item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PopupModel item) {
        helper.setText(R.id.tv_popup_name,item.title);
        helper.setText(R.id.tv_popup_des,item.content);
    }
}
