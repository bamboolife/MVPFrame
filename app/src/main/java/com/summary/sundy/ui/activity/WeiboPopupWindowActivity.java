package com.summary.sundy.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.summary.common.base.BaseActivity;
import com.summary.common.view.popmenu.PopMenu;
import com.summary.common.view.popmenu.PopMenuItem;
import com.summary.common.view.popmenu.PopMenuItemListener;
import com.summary.common.view.topmenu.MenuItem;
import com.summary.common.view.topmenu.TopRightMenu;
import com.summary.sundy.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class WeiboPopupWindowActivity extends BaseActivity {
    @BindView(R.id.btn_menu)
    Button btnMenu;
    @BindView(R.id.more)
    ImageView imgMenu;
    private PopMenu mPopMenu;
    private TopRightMenu mTopRightMenu;
    private boolean showIcon = true;
    private boolean dimBg = true;
    private boolean needAnim = true;
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

    }
    @OnClick({R.id.btn_menu,R.id.more})
    public void openMenu(View v){
        switch (v.getId()){
            case R.id.btn_menu:
                if (mPopMenu!=null){
                    mPopMenu.show();
                }
                break;
            case  R.id.more:
                mTopRightMenu = new TopRightMenu(WeiboPopupWindowActivity.this);
                List<MenuItem> menuItems = new ArrayList<>();
                menuItems.add(new MenuItem(R.mipmap.multichat, "发起多人聊天"));
                menuItems.add(new MenuItem(R.mipmap.addmember, "加好友"));
                menuItems.add(new MenuItem(R.mipmap.qr_scan, "扫一扫"));
                mTopRightMenu
                        .setHeight(650)     //默认高度480
                        .setWidth(420)      //默认宽度wrap_content
                        .showIcon(showIcon)     //显示菜单图标，默认为true
                        .dimBackground(dimBg)           //背景变暗，默认为true
                        .needAnimationStyle(needAnim)   //显示动画，默认为true
                        .setAnimationStyle(R.style.TRM_ANIM_STYLE)  //默认为R.style.TRM_ANIM_STYLE
                        .addMenuList(menuItems)
                        .addMenuItem(new MenuItem(R.mipmap.facetoface, "面对面快传"))
                        .addMenuItem(new MenuItem(R.mipmap.pay, "付款"))
                        .setOnMenuItemClickListener(new TopRightMenu.OnMenuItemClickListener() {
                            @Override
                            public void onMenuItemClick(int position) {
                                Toast.makeText(mContext, "点击菜单:" + position, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .showAsDropDown(imgMenu, -250, 0);
//                        .showAsDropDown(moreBtn);
                break;
        }
    }
}
