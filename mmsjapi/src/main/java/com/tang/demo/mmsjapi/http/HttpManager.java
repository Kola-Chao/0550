package com.tang.demo.mmsjapi.http;

import android.app.ProgressDialog;

import com.tang.demo.mmsjapi.api.BaseApi;
import com.tang.demo.mmsjapi.subscribers.ProgressSubscriber;
import com.trello.rxlifecycle.android.ActivityEvent;

import java.util.Observable;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Introduce:
 * Author  : tangchao
 * Date   :2017/2/15
 * Time   :9:59
 */

public class HttpManager {
    private volatile static HttpManager INSTANCE;

    private HttpManager() {

    }

    public static HttpManager getInstance() {
        if (INSTANCE == null) {
            synchronized (HttpManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HttpManager();
                }
            }
        }
        return INSTANCE;
    }

    public void doHttpDeal(BaseApi baseApi) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(baseApi.getConnectionTime(), TimeUnit.SECONDS);//设置超时时间
        if (baseApi.isCache()) {
//            builder.addInterceptor(new );
        }
        //创建retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(baseApi.getBaseUrl())
                .build();

        //rx
        ProgressSubscriber subscriber = new ProgressSubscriber(baseApi);
        rx.Observable observable = baseApi.getObservable(retrofit)
                //失败处理
//                .retryWhen(new RetryWh)
                //生命周期管理
                .compose(baseApi.getRxAppCompatActivity().bindUntilEvent(ActivityEvent.DESTROY))
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                //结果判断
                .map(baseApi);

        //数据回调
        observable.subscribe(subscriber);
    }
}
