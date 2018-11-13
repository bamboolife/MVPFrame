package com.summary.sundy.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.summary.sundy.R;
import com.summary.sundy.model.CoordinatorModel;

import java.util.List;

public class CoordinatorAdapter extends BaseQuickAdapter<CoordinatorModel,BaseViewHolder> {
    public CoordinatorAdapter( @Nullable List<CoordinatorModel> data) {
        super(R.layout.sy_coordinator_item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CoordinatorModel item) {

    }
}
