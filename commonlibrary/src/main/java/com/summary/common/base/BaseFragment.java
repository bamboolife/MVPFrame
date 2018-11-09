package com.summary.common.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;

/**
 * mvp fragment基类
 * Created by sundy.jiang on 2018/9/29.
 */
public abstract class BaseFragment extends Fragment {
    protected Context mContext;
    protected Activity mActivity;
    /**
     * 当前视图
     */
    protected View mView;
    Unbinder unbinder;
    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        mContext=getContext();
        mActivity=getActivity();
    }

    protected abstract int getLayoutId();

    protected  void initData(Bundle bundle){}

    protected abstract void initViews(Bundle savedInstanceState);

    protected  void initListeners(){}

    protected  void loadData(){}
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    if (mView != null) {
        ViewGroup parent = (ViewGroup) mView.getParent();
        if (parent != null) {
            parent.removeView(mView);
        }
        return mView;
    }
    mView = inflater.inflate(getLayoutId(), container, false);
    unbinder = ButterKnife.bind(this, mView);
    Bundle bundle = getArguments();
    initData(bundle);
    initViews(savedInstanceState);
    initListeners();
    loadData();

    /**
     * 点击其他部位隐藏软键盘
     */
    mView.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            InputMethodManager manager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                if (getActivity().getCurrentFocus() != null && getActivity().getCurrentFocus().getWindowToken() != null) {
                    manager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                }
            }
            return false;
        }
    });
    return mView;
}
}
