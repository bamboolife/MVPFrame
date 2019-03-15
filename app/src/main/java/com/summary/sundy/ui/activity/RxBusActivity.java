package com.summary.sundy.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.common.eventbus.EventBus;
import com.summary.common.base.BaseActivity;
import com.summary.network.model.EventMsg;
import com.summary.network.utils.RxBus;
import com.summary.network.utils.RxBusEvent;
import com.summary.sundy.R;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class RxBusActivity extends BaseActivity {
    @BindView(R.id.tv_one)
    TextView tvOne;
    @BindView(R.id.tv_two)
    TextView tvTwo;
    @BindView(R.id.button)
    Button button;
    private Disposable disposable;

    @Override
    protected int getLayoutId() {
        return R.layout.sy_rx_bus_layout;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
//        disposable = RxBus.getInstance()
//                .toObservable(EventMsg.class,
//                        AndroidSchedulers.mainThread(),
//                        AndroidSchedulers.mainThread(),
//                        new Consumer<EventMsg>() {
//                            @Override
//                            public void accept(EventMsg eventMsg) throws Exception {
//                                if (eventMsg.getTag().equals("2")) {
//                                    String data = (String) eventMsg.getData();
//                                    tvOne.setText(data);
//                                }
//                            }
//                        });

//        disposable=  RxBusEvent.getInstance().toObservable(this, EventMsg.class)
//                .subscribe(new Consumer<EventMsg>() {
//                    @Override
//                    public void accept(EventMsg eventMsg) throws Exception {
//                        final String data = (String) eventMsg.getData();
//                        tvTwo.setText(data);
//                    }
//                });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxBus.getInstance().post(new EventMsg<String>("1","这是Rxbus的一个测试"));
              //  RxBusEvent.getInstance().post(new EventMsg<String>("这是RxbusEvent的一个测试"));
                RxBusEvent.getInstance().postSticky(new EventMsg<String>("这是RxbusEvent的一个测试"));

                EventBus eventBus=new EventBus("test");
                eventBus.register(RxBusTestActivity.class);
                eventBus.post("111111111111111111111111111111");
                Intent intent=new Intent(mContext,RxBusTestActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (RxBus.getInstance().isObserver()) {
            RxBus.getInstance().unregister(disposable);
        }
    }
}
