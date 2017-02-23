package com.sxkj.a0550.apitest;

import com.tang.demo.mmsjapi.api.BaseApi;
import com.tang.demo.mmsjapi.listener.HttpOnNextListener;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Introduce:
 * Author：mac
 * Date：2017/2/23
 * Time: 上午10:15
 */

public class SubjectPostApi extends BaseApi {
    //接口需要的参数
    private boolean all;

    public SubjectPostApi(HttpOnNextListener listener, RxAppCompatActivity rxAppCompatActivity) {
        super(listener, rxAppCompatActivity);
        setShowProgress(true);
        setCache(true);
        setCancel(true);
        setMethod("AppFiftyToneGraph/videoLink");
        setCookieNetWorkTime(60);
        setCookieNoNetWorkTime(24 * 60 * 60);
    }

    @Override
    public Observable getObservable(Retrofit retrofit) {
        HttpPostService service = retrofit.create(HttpPostService.class);
        return service.getAllVideoBys(true);
    }

}
