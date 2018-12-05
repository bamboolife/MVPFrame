package com.summary.sundy.ui.activity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.summary.common.base.BaseActivity;
import com.summary.common.view.FloatMenu;
import com.summary.common.view.itemdecoration.DividerItemDecoration;
import com.summary.sundy.R;
import com.summary.sundy.adapter.PopupStyleAdapter;
import com.summary.sundy.model.PopupModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class PopupWindowActivity extends BaseActivity {
    @BindView(R.id.rv_content)
    RecyclerView mRecyclerView;
    PopupStyleAdapter adapter;
    private Point point = new Point();

    @Override
    protected int getLayoutId() {
        return R.layout.sy_popup_window_layout;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        initRecycleView();
    }

    public void initRecycleView() {
        adapter = new PopupStyleAdapter(getData());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext));
        mRecyclerView.setAdapter(adapter);
    }

    private List<PopupModel> getData() {
        List<PopupModel> items = new ArrayList<>();
        items.add(new PopupModel("WeiboPopupWindow", "微博样式的popupwiondow", WeiboPopupWindowActivity.class));
        items.add(new PopupModel("WeiboPopupWindow", "微博样式的popupwiondow", WeiboPopupWindowActivity.class));
        items.add(new PopupModel("WeiboPopupWindow", "微博样式的popupwiondow", WeiboPopupWindowActivity.class));
        items.add(new PopupModel("WeiboPopupWindow", "微博样式的popupwiondow", WeiboPopupWindowActivity.class));
        items.add(new PopupModel("WeiboPopupWindow", "微博样式的popupwiondow", WeiboPopupWindowActivity.class));
        items.add(new PopupModel("WeiboPopupWindow", "微博样式的popupwiondow", WeiboPopupWindowActivity.class));
        items.add(new PopupModel("WeiboPopupWindow", "微博样式的popupwiondow", WeiboPopupWindowActivity.class));
        items.add(new PopupModel("WeiboPopupWindow", "微博样式的popupwiondow", WeiboPopupWindowActivity.class));
        items.add(new PopupModel("WeiboPopupWindow", "微博样式的popupwiondow", WeiboPopupWindowActivity.class));
        items.add(new PopupModel("WeiboPopupWindow", "微博样式的popupwiondow", WeiboPopupWindowActivity.class));
        items.add(new PopupModel("WeiboPopupWindow", "微博样式的popupwiondow", WeiboPopupWindowActivity.class));
        items.add(new PopupModel("WeiboPopupWindow", "微博样式的popupwiondow", WeiboPopupWindowActivity.class));
        items.add(new PopupModel("WeiboPopupWindow", "微博样式的popupwiondow", WeiboPopupWindowActivity.class));
        items.add(new PopupModel("WeiboPopupWindow", "微博样式的popupwiondow", WeiboPopupWindowActivity.class));
        items.add(new PopupModel("WeiboPopupWindow", "微博样式的popupwiondow", WeiboPopupWindowActivity.class));
        items.add(new PopupModel("WeiboPopupWindow", "微博样式的popupwiondow", WeiboPopupWindowActivity.class));

        return items;
    }

    @Override
    public void initListeners() {
        super.initListeners();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (position == 0) {
                    PopupModel model = (PopupModel) adapter.getItem(position);
                    Intent intent = new Intent(mContext, model.activity);
                    startActivity(intent);
                } else {
                    FloatMenu floatMenu = new FloatMenu(mActivity);
                    // floatMenu.items("菜单1", "菜单2", "菜单3");
                    floatMenu.inflate(R.menu.popup_menu);
                    floatMenu.show(point);
                }
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            point.x = (int) ev.getRawX();
            point.y = (int) ev.getRawY();
        }
        return super.dispatchTouchEvent(ev);
    }
}
