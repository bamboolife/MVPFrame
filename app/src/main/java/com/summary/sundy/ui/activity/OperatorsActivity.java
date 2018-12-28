package com.summary.sundy.ui.activity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.TextView;

import com.summary.common.base.BaseActivity;
import com.summary.sundy.R;
import com.summary.sundy.model.PersonModel;
import com.summary.sundy.model.UserModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * 操作符的各种使用
 */
public class OperatorsActivity extends BaseActivity {
    @BindView(R.id.textView)
    TextView textView;
    private final CompositeDisposable disposables = new CompositeDisposable();


    @Override
    protected int getLayoutId() {
        return R.layout.sy_operators_layout;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }

    @OnClick(R.id.btn)
    public void doSomeWork() {
//         getObservable()
//                 .subscribeOn(Schedulers.io())
//                 .observeOn(AndroidSchedulers.mainThread())
//                 .subscribe(getObserver());

//         getMapObservable()
//                 .subscribeOn(Schedulers.io())
//                 .observeOn(AndroidSchedulers.mainThread())
//                 .map(new Function<List<PersonModel>, List<UserModel>>() {
//                     @Override
//                     public List<UserModel> apply(List<PersonModel> personModels) throws Exception {
//                         List<UserModel> userModels=new ArrayList<>();
//                         for (PersonModel model:personModels) {
//                              UserModel userModel=new UserModel();
//                              userModel.setName(model.getName());
//                              userModel.setAge(model.getAge());
//                              userModels.add(userModel);
//                         }
//                         return userModels;
//                     }
//                 })
//                 .subscribe(getMapObserver());

//        Observable.zip(getUserObservable(), getPersonObservable(),
//                new BiFunction<List<UserModel>, List<PersonModel>, List<UserModel>>() {
//                    @Override
//                    public List<UserModel> apply(List<UserModel> userModels, List<PersonModel> personModels) throws Exception {
//                        for (PersonModel person : personModels) {
//                            UserModel model = new UserModel();
//                            model.setName(person.getName());
//                            model.setAge(person.getAge());
//                            userModels.add(model);
//                        }
//                        return userModels;
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(getZipObserver());
//              disposables.add(sampleObservable()
//                      .subscribeOn(Schedulers.io())
//                      .observeOn(AndroidSchedulers.mainThread())
//                      .subscribeWith(new DisposableObserver<String>() {
//                          @Override
//                          public void onNext(String value) {
//                              textView.append(" onNext : value : " + value);
//                              textView.append("\n");
//                              Log.i("log_observer", " onNext value : " + value);
//                          }
//
//                          @Override
//                          public void onError(Throwable e) {
//                              textView.append(" onError : " + e.getMessage());
//                              textView.append("\n");
//                              Log.i("log_observer", " onError : " + e.getMessage());
//                          }
//
//                          @Override
//                          public void onComplete() {
//                              textView.append(" onComplete");
//                              textView.append("\n");
//                              Log.i("log_observer", " onComplete");
//                          }
//                      }));

//                         getTakeObservable().subscribeOn(Schedulers.io())
//                                 .observeOn(AndroidSchedulers.mainThread())
//                                 .subscribe(getTakeObserver());

                           getTakeObservable().subscribeOn(Schedulers.io())
                                   .observeOn(AndroidSchedulers.mainThread())
                                   .subscribe(getTakeObserver());
    }

    /**
     * 创建被观察者
     *
     * @return
     */
    private Observable<String> getObservable() {
        return Observable.just("测试一", "测试二");
    }

    /**
     * 创建观察者
     *
     * @return
     */
    private Observer<String> getObserver() {
        return new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i("log_observer", "onSubscribe: =" + d.isDisposed());
            }

            @Override
            public void onNext(String value) {
                textView.append(" onNext : value : " + value);
                textView.append("\n");
                Log.d("log_observer", " onNext : value : " + value);
            }

            @Override
            public void onError(Throwable e) {
                textView.append(" onError : " + e.getMessage());
                textView.append("\n");
                Log.d("log_observer", " onError : " + e.getMessage());
            }

            @Override
            public void onComplete() {
                textView.append(" onComplete");
                textView.append("\n");
                Log.d("log_observer", " onComplete");
            }
        };
    }
    /////////////////////////////////////////////////////////////////////////

    /**
     * 创建被观察者
     *
     * @return
     */
    private Observable<List<PersonModel>> getMapObservable() {
        return Observable.create(new ObservableOnSubscribe<List<PersonModel>>() {
            @Override
            public void subscribe(ObservableEmitter<List<PersonModel>> e) throws Exception {
                if (!e.isDisposed()) {
                    e.onNext(getPersons());
                    e.onComplete();
                }
            }
        });
    }

    private List<PersonModel> getPersons() {
        List<PersonModel> datas = new ArrayList<>();
        PersonModel model1 = new PersonModel();
        model1.setName("sundy");
        model1.setAge(30);
        datas.add(model1);
        return datas;
    }


    /**
     * 创建观察者
     *
     * @return
     */
    private Observer<List<UserModel>> getMapObserver() {
        return new Observer<List<UserModel>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i("log_observer", "onSubscribe: =" + d.isDisposed());
            }

            @Override
            public void onNext(List<UserModel> userModels) {
                textView.append("onNext");
                textView.append("\n");
                for (UserModel model : userModels) {
                    textView.append("名字：" + model.getName());
                    textView.append("\n");
                    textView.append("年龄：" + model.getAge());
                    textView.append("\n");
                }
                Log.i("log_observer", "onNext: =" + userModels.size());
            }

            @Override
            public void onError(Throwable e) {
                textView.append(" onError : " + e.getMessage());
                textView.append("\n");
                Log.i("log_observer", " onError : " + e.getMessage());
            }

            @Override
            public void onComplete() {
                textView.append(" onComplete");
                textView.append("\n");
                Log.d("log_observer", " onComplete");
            }
        };
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////


    private Observable<List<UserModel>> getUserObservable() {
        return Observable.create(new ObservableOnSubscribe<List<UserModel>>() {
            @Override
            public void subscribe(ObservableEmitter<List<UserModel>> e) throws Exception {
                if (!e.isDisposed()) {
                    e.onNext(getUsers());
                    e.onComplete();
                }
            }
        });
    }

    private List<UserModel> getUsers() {
        List<UserModel> userModels = new ArrayList<>();
        UserModel model = new UserModel();
        model.setAge(11);
        model.setName("sdfasdfasdf");
        userModels.add(model);
        return userModels;
    }

    private Observable<List<PersonModel>> getPersonObservable() {
        return Observable.create(new ObservableOnSubscribe<List<PersonModel>>() {
            @Override
            public void subscribe(ObservableEmitter<List<PersonModel>> e) throws Exception {
                if (!e.isDisposed()) {
                    e.onNext(getPersons());
                    e.onComplete();
                }
            }
        });
    }

    private Observer<List<UserModel>> getZipObserver() {
        return new Observer<List<UserModel>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i("log_observer", "onSubscribe: =" + d.isDisposed());
            }

            @Override
            public void onNext(List<UserModel> userModels) {
                textView.append("onNext");
                textView.append("\n");
                for (UserModel model : userModels) {
                    textView.append("名字：" + model.getName());
                    textView.append("\n");
                    textView.append("年龄：" + model.getAge());
                    textView.append("\n");
                }
                Log.i("log_observer", "onNext: =" + userModels.size());
            }

            @Override
            public void onError(Throwable e) {
                textView.append(" onError : " + e.getMessage());
                textView.append("\n");
                Log.i("log_observer", " onError : " + e.getMessage());
            }

            @Override
            public void onComplete() {
                textView.append(" onComplete");
                textView.append("\n");
                Log.i("log_observer", " onComplete");
            }
        };
    }
/////////////////////////////////////////////////////////////////////////////////////////////
  static   Observable<String> sampleObservable(){
        return Observable.defer(new Callable<ObservableSource<? extends String>>() {
            @Override
            public ObservableSource<? extends String> call() throws Exception {
                SystemClock.sleep(2000);
                return Observable.just("one", "two", "three", "four", "five");
            }
        });
    }
////////////////////////////////////////////////////////////////////////////////////

    private Observable<Integer> getTakeObservable(){
        return Observable.just(1,2,3,4,5,6,7);
    }

    private Observer<Integer> getTakeObserver(){
       return new Observer<Integer>(){

           @Override
           public void onSubscribe(Disposable d) {

           }

           @Override
           public void onNext(Integer integer) {

           }

           @Override
           public void onError(Throwable e) {

           }

           @Override
           public void onComplete() {

           }
       };
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private Observable<? extends Long> getTimerObservable(){
        return Observable.timer(2,TimeUnit.SECONDS);
    }

    private Observer<Long> getTimerObserver(){
        return new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long aLong) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposables.clear();
    }
}
