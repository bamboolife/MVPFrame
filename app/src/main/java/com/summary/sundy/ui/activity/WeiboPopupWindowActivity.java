package com.summary.sundy.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.summary.common.base.BaseActivity;
import com.summary.common.view.popmenu.PopMenu;
import com.summary.common.view.popmenu.PopMenuItem;
import com.summary.common.view.popmenu.PopMenuItemListener;
import com.summary.sundy.R;

import butterknife.BindView;

public class WeiboPopupWindowActivity extends BaseActivity {
    @BindView(R.id.btn_menu)
    Button btnMenu;
    private PopMenu mPopMenu;

    @Override
    protected int getLayoutId() {
        return R.layout.sy_weibo_popup_window_layout;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        mPopMenu = new PopMenu.Builder().attachToActivity(mActivity)
                .addMenuItem(new PopMenuItem("广场", getResources().getDrawable(R.mipmap.tabbar_compose_idea)))
                .addMenuItem(new PopMenuItem("私密", getResources().getDrawable(R.mipmap.tabbar_compose_photo)))
                .addMenuItem(new PopMenuItem("家庭圈", getResources().getDrawable(R.mipmap.tabbar_compose_headlines)))
                .addMenuItem(new PopMenuItem("地图", getResources().getDrawable(R.mipmap.tabbar_compose_lbs)))
                .addMenuItem(new PopMenuItem("朋友圈", getResources().getDrawable(R.mipmap.tabbar_compose_review)))
                .addMenuItem(new PopMenuItem("更多", getResources().getDrawable(R.mipmap.tabbar_compose_more)))
                .setOnItemClickListener(new PopMenuItemListener() {
                    @Override
                    public void onItemClick(PopMenu popMenu, int position) {
                        Toast.makeText(mContext, "你点击了第" + (position+1) + "个位置", Toast.LENGTH_SHORT).show();
                    }
                })
                .build();
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPopMenu!=null){
                    mPopMenu.show();
                }
            }
        });
    }
}
