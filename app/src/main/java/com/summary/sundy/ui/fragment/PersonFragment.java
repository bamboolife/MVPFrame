package com.summary.sundy.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.summary.common.base.BaseFragment;
import com.summary.common.view.CustomSwitchView;
import com.summary.common.view.ofomenuview.OfoMenuManager;
import com.summary.common.view.ofomenuview.drawable.MenuBrawable;
import com.summary.common.view.ofomenuview.view.OfoContentLayout;
import com.summary.common.view.ofomenuview.view.OfoMenuLayout;
import com.summary.sundy.R;

import butterknife.BindView;

public class PersonFragment extends BaseFragment {
    @BindView(R.id.csv)
    CustomSwitchView view;
    @BindView(R.id.start_ofo)
    Button btnStart;
    @BindView(R.id.editText)
    EditText mEditText;
    OfoMenuManager ofoMenuManager;
    private int count;
    @Override
    protected int getLayoutId() {
        return R.layout.frame_main_layout;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
       view.setOnScrollCompletedListener(new CustomSwitchView.ScrollCompletedListener() {
           @Override
           public void scrollCompleted() {

           }
       });
       initOfoMenu();
       mEditText.setHint("sadfasdfasdfasd");
       mEditText.setText("你好！！！");
    }

    private void initOfoMenu() {
        ofoMenuManager = new OfoMenuManager.Builder(mContext)
                //CONCAVE：凹进去；CONVEX：凸出来
                .setRadian(MenuBrawable.CONVEX)
                .setOfoBackColor(android.R.color.holo_blue_light)
                .setOfoPosition(R.dimen.ofo_menu_height)
                .addItemContentView(R.layout.item_huiyuan)
                .addItemContentView(R.layout.item_qianbao)
                .addItemContentView(R.layout.item_xiaoxi)
                .addItemContentView(R.layout.item_xingcheng)
                .addItemContentView(R.layout.item_ziliao)
                .build();
        ((ViewGroup) mActivity.findViewById(android.R.id.content)).addView(ofoMenuManager.getRootView());
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ofoMenuManager.open();
            }
        });
        ofoMenuManager.setOfoMenuStatusListener(new OfoMenuLayout.OfoMenuStatusListener() {
            @Override
            public void onOpen() {
                btnStart.setVisibility(View.GONE);
            }

            @Override
            public void onClose() {
                btnStart.setVisibility(View.VISIBLE);
            }
        });
        ofoMenuManager.setOfoUsesrIconListener(new OfoMenuLayout.OfoUserIconListener() {
            @Override
            public void onClick() {
                count++;
                if (count % 2 == 0) {
                    ofoMenuManager.setUserIcon(R.mipmap.single);
                } else {
                    ofoMenuManager.setUserIcon(R.mipmap.timg);
                }
            }
        });
        ofoMenuManager.setOnItemClickListener(new OfoContentLayout.OnItemClickListener() {
            @Override
            public void onClick(int position) {

            }
        });
    }

}
