package com.summary.common.base;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.summary.common.service.FloatingService;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;

/**
 * mvp activity基类
 * Created by sundy.jiang on 2018/9/26.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private Intent intent;
    protected Context mContext;
    protected Activity mActivity;
    protected FloatingService floatingService;
    private ServiceConnection connection;
    protected RecyclerView mRecyclerView;
    Unbinder unbinder = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        init(savedInstanceState);
        super.onCreate(savedInstanceState);
        mContext = getApplicationContext();
        mActivity = this;
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        // startFloatingService();
        initData(getIntent().getExtras());
        initViews(savedInstanceState);
        initListeners();
        loadData();
    }

    public void init(Bundle savedInstanceState) {//可实现，也可以不实现
    }

    protected abstract int getLayoutId();

    protected void initData(Bundle bundle) {//可实现，也可以不实现
    }

    protected abstract void initViews(Bundle savedInstanceState);

    public void initListeners() {//可实现，也可以不实现
    }

    public void initService() {//可实现，也可以不实现
    }

    protected void loadData() {//可实现，也可以不实现
    }

    private void initServiceConnection() {
        connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                floatingService = ((FloatingService.SubFloatingService) service).getService();
                if (floatingService != null) {
                    initService();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopFloatingService();
    }

    private void startFloatingService() {
        intent = new Intent(this, FloatingService.class);
        if (connection == null) {
            initServiceConnection();
        }
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    private void stopFloatingService() {
        if (connection != null) {
            unbindService(connection);
            connection = null;
        }
    }

//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        if (hasFocus) {
//            startFloatingService();
//        } else {
//            stopFloatingService();
//        }
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
