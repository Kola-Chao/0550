package com.sxkj.a0550.apitest;

import com.tang.demo.mmsjapi.bean.BaseResultEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Introduce:
 * Author：mac
 * Date：2017/2/23
 * Time: 上午10:28
 */

public interface HttpPostService {
    @POST("AppFiftyToneGraph/videoLink")
    Call<RetrofitEntity> getAllVideo(@Body boolean once_no);


    @POST("AppFiftyToneGraph/videoLink/{once_no}")
    rx.Observable<BaseResultEntity<List<SubjectResult>>> getAllVideoBys(@Query("once_no") boolean once_no);
}
