package com.summary.sundy.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.summary.common.base.BaseActivity;
import com.summary.common.view.UIAlertDialog;
import com.summary.sundy.R;

import butterknife.OnClick;

public class DialogActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.sy_dialog_layout;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }

    @OnClick(R.id.btn1)
    public void showDialog(){
      new  UIAlertDialog(mActivity).builder().setTitle("退出当前账号")
              .setMsg("再连续登陆15天，就可变身为QQ达人。退出QQ可能会使你现有记录归零，确定退出？")
              .setPositiveButton("确认退出", new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {

                  }
              })
              .setNegativeButton("取消", new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {

                  }
              }).show();
    }
}
