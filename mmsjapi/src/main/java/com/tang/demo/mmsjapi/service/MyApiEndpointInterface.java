package com.tang.demo.mmsjapi.service;

import com.tang.demo.mmsjapi.bean.TestEntity;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Introduce:
 * Author  : tangchao
 * Date   :2017/2/14
 * Time   :14:52
 */

public interface MyApiEndpointInterface {
//    @POST("AppFiftyToneGraph/videoLink")
//    Call<TestEntity> getAllVedio(@Body boolean once_no);
    @POST("AppFiftyToneGraph/videoLink")
    Observable<TestEntity> getAllVedio(@Body boolean once_no);
}
