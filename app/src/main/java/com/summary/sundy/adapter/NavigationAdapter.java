package com.summary.sundy.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.summary.sundy.R;
import com.summary.sundy.model.NavigationModel;

import java.util.List;

/**
 * 树根互联科技有限公司
 * Created by sundy.jiang on 2018/12/4.
 */
public class NavigationAdapter extends BaseQuickAdapter<NavigationModel,BaseViewHolder> {

    public NavigationAdapter( @Nullable List<NavigationModel> data) {
        super(R.layout.sy_navigation_item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NavigationModel item) {
        helper.setText(R.id.tv_widget_name, item.title);
        helper.setText(R.id.tv_widget_des, item.content);
    }
}
