package com.summary.common.base;

import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class BaseBindingActivity<V extends ViewDataBinding,VM extends BaseViewModel> extends AppCompatActivity {
    protected V binding;
    protected VM viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
