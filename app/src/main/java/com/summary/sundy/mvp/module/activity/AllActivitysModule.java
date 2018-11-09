package com.summary.sundy.mvp.module.activity;

import com.summary.sundy.MainActivity;
import com.summary.sundy.mvp.component.activity.BaseActivityComponent;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(subcomponents = BaseActivityComponent.class)
public abstract class AllActivitysModule {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributeMainActivityInjector();
}
