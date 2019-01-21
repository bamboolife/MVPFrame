package com.summary.network.utils;

import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.Relay;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 使用Rxrelay实现数据传递
 * Rxrelay简单说明
 * 1、Rxrelay:既是一个Observable 也是 一个Consumer的RxJava。使用它的好处就是不必担心事件在onComplete或者onError后终止事件订阅关系，
 * 它允许将非Rx API连接到Rx，而不用担心意外触发终端状态（onComplete或者onError）。
 * <p>
 * 2、Rxrelay:有3个子类：
 * <p>
 * BehaviorRelay：他会接收订阅之前的最后一个事件和订阅之后的事件。
 * PublishRelay：只接受订阅后的事件。
 * ReplayRelay：接受订阅前和订阅后的所有事件。
 */
public class RxBus {
    private Relay<Object> rxBus = null;
    private static RxBus instance;

    private static class IRxBusHolder {
        private static final RxBus INSTANCE = new RxBus();
    }

    private RxBus() {
        rxBus = BehaviorRelay.create().toSerialized();
    }

    public static final RxBus getInstance() {
        return IRxBusHolder.INSTANCE;
    }

    /**
     * 发送一个事件消息
     *
     * @param event
     */
    public void post(Object event) {
        rxBus.accept(event);
    }

    private <T> Observable<T> register(Class<T> eventType) {
        return rxBus.ofType(eventType);
    }
    public <T> Disposable toObservable(Class<T> eventType, Consumer<T> onNext) {
        return register(eventType)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext);
    }

    public <T> Disposable toObservable( Class<T> eventType, Scheduler subScheduler, Scheduler obsScheduler, Consumer<T> onNext) {
        return register(eventType).subscribeOn(subScheduler).observeOn(obsScheduler).subscribe(onNext);
    }

    public <T> Disposable toObservable(Class<T> eventType, Consumer<T> onNext, Consumer onError) {
        return register(eventType)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext, onError);
    }

    public <T> Disposable toObservable(
            Class<T> eventType,
            Scheduler subScheduler,
            Scheduler obsScheduler,
            Consumer<T> onNext,
            Consumer onError) {
        return register(eventType)
                .subscribeOn(subScheduler)
                .observeOn(obsScheduler)
                .subscribe(onNext, onError);
    }

    public <T> Disposable toObservable(
            Class<T> eventType, Consumer<T> onNext, Consumer onError, Action onComplete) {
        return register(eventType)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext, onError, onComplete);
    }

    public <T> Disposable toObservable(
            Class<T> eventType,
            Scheduler subScheduler,
            Scheduler obsScheduler,
            Consumer<T> onNext,
            Consumer onError,
            Action onComplete) {
        return register(eventType)
                .subscribeOn(subScheduler)
                .observeOn(obsScheduler)
                .subscribe(onNext, onError, onComplete);
    }

    public <T> Disposable toObservable(
            Class<T> eventType,
            Consumer<T> onNext,
            Consumer onError,
            Action onComplete,
            Consumer onSubscribe) {
        return register(eventType)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext, onError, onComplete, onSubscribe);
    }

    public <T> Disposable toObservable(
            Class<T> eventType,
            Scheduler subScheduler,
            Scheduler obsScheduler,
            Consumer<T> onNext,
            Consumer onError,
            Action onComplete,
            Consumer onSubscribe) {
        return register(eventType)
                .subscribeOn(subScheduler)
                .observeOn(obsScheduler)
                .subscribe(onNext, onError, onComplete, onSubscribe);
    }

    public boolean isObserver() {
        return rxBus.hasObservers();
    }

    public void unregister(Disposable disposable) {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
