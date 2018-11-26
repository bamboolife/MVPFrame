package com.summary.sundy.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.summary.common.base.BaseActivity;
import com.summary.sundy.R;
import com.summary.tabview.model.BasicItem;
import com.summary.tabview.model.ViewItem;
import com.summary.tabview.widget.UITableView;

import butterknife.BindView;

public class UITabViewActivity extends BaseActivity {
    @BindView(R.id.tableView)
    UITableView tableView;

    @Override
    protected int getLayoutId() {
        return R.layout.sy_uitab_view_layout;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        createList();
        tableView.commit();
    }

    private void createList() {
        CustomClickListener listener = new CustomClickListener();
        tableView.setClickListener(listener);
        tableView.addBasicItem(R.drawable.user_image, "Example 1", "Summary text 1");
        tableView.addBasicItem("Example 2", "Summary text 2");
        tableView.addBasicItem(R.drawable.user_image, "Example 3", "Summary text 3");
        tableView.addBasicItem("Example 4", "Summary text 4");
        tableView.addBasicItem(R.drawable.user_image, "Example 5", "Summary text 5");
        tableView.addBasicItem("Example 6", "Summary text 6");
        tableView.addBasicItem(R.drawable.user_image, "Example 7", "Summary text 7");
        tableView.addBasicItem("Example 8", "Summary text 8");
        tableView.addBasicItem(R.drawable.user_image, "Example 9", "Summary text 9");
        tableView.addBasicItem("Example 10", "Summary text 10");
        tableView.addBasicItem("Example 11");
        tableView.addBasicItem(new BasicItem("Disabled item", "this is a disabled item", false));
        tableView.addBasicItem(new BasicItem("Disabled item", "this is a disabled item", true));

        LayoutInflater mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        RelativeLayout view = (RelativeLayout) mInflater.inflate(R.layout.custom_view, null);
        ViewItem viewItem = new ViewItem(view);
        tableView.addViewItem(viewItem);
        RelativeLayout v = (RelativeLayout) mInflater.inflate(R.layout.custom_view2, null);
        ViewItem v2 = new ViewItem(v);
        v2.setClickable(false);
        tableView.addViewItem(v2);
    }

    private class CustomClickListener implements UITableView.ClickListener {

        @Override
        public void onClick(int index) {
            Toast.makeText(mContext, "item clicked: " + index, Toast.LENGTH_SHORT).show();
        }

    }
}
