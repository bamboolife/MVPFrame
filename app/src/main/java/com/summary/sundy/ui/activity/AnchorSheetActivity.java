package com.summary.sundy.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.summary.common.base.BaseActivity;
import com.summary.common.behavior.AnchorSheetBehavior;
import com.summary.sundy.R;

import butterknife.BindView;

public class AnchorSheetActivity extends BaseActivity {
    private AnchorSheetBehavior<View> anchorBehavior;
    @BindView(R.id.panel_content)
    TextView content;
    @Override
    protected int getLayoutId() {
        return R.layout.sy_anchor_sheet_layout;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        anchorBehavior = AnchorSheetBehavior.from(findViewById(R.id.anchor_panel));
        anchorBehavior.setHideable(true);
        anchorBehavior.setState(AnchorSheetBehavior.STATE_HIDDEN);
        anchorBehavior.setAnchorSheetCallback(new AnchorSheetBehavior.AnchorSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, @AnchorSheetBehavior.State int newState) {
               // content.setText(newState == AnchorSheetBehavior.STATE_EXPANDED ? R.string.slide_me_down : R.string.slide_me_up);
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }

    public void onTap(View view) {
        switch (anchorBehavior.getState()) {
            case AnchorSheetBehavior.STATE_ANCHOR:
                anchorBehavior.setState(AnchorSheetBehavior.STATE_EXPANDED);
                break;
            case AnchorSheetBehavior.STATE_COLLAPSED:
                anchorBehavior.setState(AnchorSheetBehavior.STATE_ANCHOR);
                break;
            case AnchorSheetBehavior.STATE_HIDDEN:
                anchorBehavior.setState(AnchorSheetBehavior.STATE_COLLAPSED);
                break;
            case AnchorSheetBehavior.STATE_EXPANDED:
                anchorBehavior.setState(AnchorSheetBehavior.STATE_ANCHOR);
                break;
            default:
                break;
        }
    }
}
