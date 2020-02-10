package com.summary.sundy.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.summary.common.base.BaseActivity;
import com.summary.sundy.R;
import com.summary.sundy.ui.fragment.MainFragment;
import com.summary.sundy.ui.fragment.RecyclerGridFragment;
import com.summary.sundy.ui.fragment.RecyclerListFragment;

public class ItemTouchHelperActivity extends BaseActivity implements MainFragment.OnListItemClickListener{


    @Override
    protected int getLayoutId() {
        return R.layout.sy_item_touch_helper_layout;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            MainFragment fragment = new MainFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content, fragment)
                    .commit();
        }
    }

    @Override
    public void onListItemClick(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new RecyclerListFragment();
                break;

            case 1:
                fragment = new RecyclerGridFragment();
                break;
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, fragment)
                .addToBackStack(null)
                .commit();
    }
}
