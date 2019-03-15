package com.summary.sundy.ui.activity;

import android.os.Bundle;

import com.summary.common.base.BaseActivity;
import com.summary.common.view.UIActionSheetDialog;
import com.summary.sundy.R;

import butterknife.OnClick;

public class SheetViewActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.sy_sheet_view_layout;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }

    @OnClick(R.id.btn1)
    public void showSheetView(){
        new UIActionSheetDialog(mActivity)
                .builder()
                .setCancelable(false)
                .setCanceledOnTouchOutside(false)
                .addSheetItem("发送给好友", UIActionSheetDialog.SheetItemColor.Blue,
                        new UIActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {

                            }
                        })
                .addSheetItem("转载到空间相册", UIActionSheetDialog.SheetItemColor.Blue,
                        new UIActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {

                            }
                        })
                .addSheetItem("上传到群相册", UIActionSheetDialog.SheetItemColor.Blue,
                        new UIActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {

                            }
                        })
                .addSheetItem("保存到手机", UIActionSheetDialog.SheetItemColor.Blue,
                        new UIActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {

                            }
                        })
                .addSheetItem("收藏", UIActionSheetDialog.SheetItemColor.Blue,
                        new UIActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {

                            }
                        })
                .addSheetItem("查看聊天图片", UIActionSheetDialog.SheetItemColor.Blue,
                        new UIActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {

                            }
                        }).show();
    }
}
