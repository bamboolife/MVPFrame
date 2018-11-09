package com.summary.sundy.mvp.module.fragment;

import com.summary.sundy.mvp.component.fragment.BaseFragmentSubcomponent;
import com.summary.sundy.ui.fragment.FindFragment;
import com.summary.sundy.ui.fragment.HomeFragment;
import com.summary.sundy.ui.fragment.MomentsFragment;
import com.summary.sundy.ui.fragment.PersonFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(subcomponents = BaseFragmentSubcomponent.class)
public abstract class AllFragmentsModule {
    @ContributesAndroidInjector(modules = HomeFragmentModule.class)
    abstract HomeFragment contributeHomeFragmentInjector();

    @ContributesAndroidInjector(modules = MomentsFragmentModule.class)
    abstract MomentsFragment contributeMomentsFragmentInjector();

    @ContributesAndroidInjector(modules = FindFragmentModule.class)
    abstract FindFragment contributeFindFragmentInjector();

    @ContributesAndroidInjector(modules = PersonFragmentModule.class)
    abstract PersonFragment contributePersonFragmentInjector();
}
