package com.summary.sundy.model;

import android.app.Activity;

/**
 * 树根互联科技有限公司
 * Created by sundy.jiang on 2018/12/4.
 */
public class NavigationModel {
    public String title;
    public String content;
    public Class<? extends Activity> activity;

    public NavigationModel(String title, String content, Class<? extends Activity> activity) {
        this.title = title;
        this.content = content;
        this.activity = activity;
    }
}
