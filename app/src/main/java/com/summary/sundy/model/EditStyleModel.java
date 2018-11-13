package com.summary.sundy.model;

import android.app.Activity;

public class EditStyleModel {
    public String title;
    public String content;
    public Class<? extends Activity> activity;

    public EditStyleModel(String title, String content, Class<? extends Activity> activity) {
        this.title = title;
        this.content = content;
        this.activity = activity;
    }
}
