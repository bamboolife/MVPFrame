package com.summary.sundy.mvp.module.activity;

import com.summary.sundy.helper.LoginHelper;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class MainActivityModule {

    @Provides
    static LoginHelper provideLoginHelper(){
        return new LoginHelper();
    }
}
