package com.summary.sundy;

import com.summary.common.base.BaseApplication;
import com.summary.sundy.mvp.component.DaggerAppComponent;

public class SundyApplication extends BaseApplication {


    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.create().inject(this);
    }


}

