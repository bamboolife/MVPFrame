package com.summary.sundy.model;

import android.app.Activity;

public class UITabViewModel {
    public String title;
    public String content;
    public Class<? extends Activity> activity;

    public UITabViewModel(String title, String content, Class<? extends Activity> activity) {
        this.title = title;
        this.content = content;
        this.activity = activity;
    }
}
