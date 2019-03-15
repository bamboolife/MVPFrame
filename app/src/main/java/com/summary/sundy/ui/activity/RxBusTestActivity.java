package com.summary.sundy.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.common.eventbus.Subscribe;
import com.summary.network.model.EventMsg;
import com.summary.network.utils.RxBus;
import com.summary.network.utils.RxBusEvent;
import com.summary.sundy.R;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class RxBusTestActivity extends AppCompatActivity {
    private Disposable disposable;
    @BindView(R.id.tv_one_test)
    TextView tvOne;
    @BindView(R.id.tv_two_text)
    TextView tvTwo;
    @BindView(R.id.button2)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sy_rx_bus_test_layout);
        tvOne=findViewById(R.id.tv_one_test);
        tvTwo=findViewById(R.id.tv_two_text);
        button=findViewById(R.id.button2);
//        disposable = RxBus.getInstance()
//                .toObservable(EventMsg.class,
//                        new Consumer<EventMsg>() {
//                            @Override
//                            public void accept(EventMsg eventMsg) throws Exception {
//                                if (eventMsg!=null&&eventMsg.getTag().equals("1")) {
//                                    final String data = (String) eventMsg.getData();
//                                    tvOne.setText(data);
//                                }
//                            }
//                        });
       RxBusEvent.getInstance().toObservable(this, EventMsg.class)
                .subscribe(new Consumer<EventMsg>() {
                    @Override
                    public void accept(EventMsg eventMsg) throws Exception {
                        final String data = (String) eventMsg.getData();
                        tvTwo.setText(data);
                    }
                });
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               RxBusEvent.getInstance().postSticky(new EventMsg<String>("这是RxbusEvent的一个测试"));
           }
       });
    }
    @Subscribe
    public void msgEvent(String msg){
        Log.i("log_msg", "msgEvent:= "+msg);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (RxBus.getInstance().isObserver()){
            RxBus.getInstance().unregister(disposable);
        }
    }
}
