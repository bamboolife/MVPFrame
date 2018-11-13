package com.summary.sundy.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.summary.sundy.R;
import com.summary.sundy.model.EditStyleModel;

import java.util.List;

/**
 * EditText适配器
 */
public class EditTextStyleAdapter extends BaseQuickAdapter<EditStyleModel,BaseViewHolder> {

    public EditTextStyleAdapter(@Nullable List<EditStyleModel> data) {
        super(R.layout.sy_edit_text_style_item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, EditStyleModel item) {
        helper.setText(R.id.tv_widget_name, item.title);
        helper.setText(R.id.tv_widget_des, item.content);
    }
}
