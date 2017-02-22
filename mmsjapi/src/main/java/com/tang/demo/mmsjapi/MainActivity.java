package com.tang.demo.mmsjapi;

import android.app.Activity;
import android.os.Bundle;

import com.tang.demo.mmsjapi.bean.TestEntity;
import com.tang.demo.mmsjapi.service.MyApiEndpointInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Introduce:
 * Author  : tangchao
 * Date   :2017/2/14
 * Time   :14:49
 */

public class MainActivity extends Activity {
    String BASE_URL = "http://www.izaodao.com/Api/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firstTest();//纯Retrofit形式
        secondTest();//rxjava + retrofit
    }

    private void secondTest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//添加rxjava
                .build();
        MyApiEndpointInterface apiService = retrofit.create(MyApiEndpointInterface.class);
        Observable<TestEntity> observable = apiService.getAllVedio(true);
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<TestEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(TestEntity testEntity) {

                    }
                });
    }

    /**
     * 第一次添加
     */
    private void firstTest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyApiEndpointInterface apiService = retrofit.create(MyApiEndpointInterface.class);
//        Call<TestEntity> call = apiService.getAllVedio(true);
//        call.enqueue(new Callback<TestEntity>() {
//            @Override
//            public void onResponse(Call<TestEntity> call, Response<TestEntity> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<TestEntity> call, Throwable t) {
//
//            }
//        });
    }
}
