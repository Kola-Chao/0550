package com.tang.demo.mmsjapi.api;

import com.tang.demo.mmsjapi.bean.BaseResultEntity;
import com.tang.demo.mmsjapi.excaption.HttpTimeException;
import com.tang.demo.mmsjapi.listener.HttpOnNextListener;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.lang.ref.SoftReference;

import retrofit2.Retrofit;
import rx.Observable;
import rx.functions.Func1;

/**
 * Introduce:
 * Author  : tangchao
 * Date   :2017/2/14
 * Time   :16:53
 */

public abstract class BaseApi<T> implements Func1<BaseResultEntity<T>, T> {
    //rx生命周期管理
    private SoftReference<RxAppCompatActivity> rxAppCompatActivity;
    //回调监听
    private SoftReference<HttpOnNextListener> listener;
    //是否能取消加载框
    private boolean cancel;
    //是否要显示加载框
    private boolean showProgress;
    //是否需要缓存
    private boolean cache;
    //基础ＵＲＬ
    private String baseUrl = "http://www.izaodao.com/Api/";
    /*方法-如果需要缓存必须设置这个参数；不需要不用設置*/
    private String method;
    //超时时间，默认6秒
    private int connectionTime = 6;
    //有网络的时候本地缓存时间，默认60s
    private int cookieNetWorkTime = 60;
    //无网络的时候本地缓存时间，默认30天
    private int cookieNoNetWorkTime = 24 * 60 * 60 * 30;

    public BaseApi(HttpOnNextListener listener, RxAppCompatActivity rxAppCompatActivity) {
        setListener(listener);
        setRxAppCompatActivity(rxAppCompatActivity);
        setShowProgress(true);
        setCache(true);
    }

    /**
     * 设置参数
     *
     * @param retrofit
     * @return
     */
    public abstract Observable getObservable(Retrofit retrofit);

    @Override
    public T call(BaseResultEntity<T> httpResult) {
        if (httpResult.getRet() == 0) {//如果判断码==0，表示请求失败了
            throw new HttpTimeException(httpResult.getMsg());
        }
        return httpResult.getData();
    }

    /**
     * 得到rx生命周期
     *
     * @return
     */
    public RxAppCompatActivity getRxAppCompatActivity() {
        return rxAppCompatActivity.get();
    }

    public void setRxAppCompatActivity(RxAppCompatActivity rxAppCompatActivity) {
        this.rxAppCompatActivity = new SoftReference(rxAppCompatActivity);
    }

    public SoftReference<HttpOnNextListener> getListener() {
        return listener;
    }

    public void setListener(HttpOnNextListener listener) {
        this.listener = new SoftReference(listener);
    }

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    public boolean isShowProgress() {
        return showProgress;
    }

    public void setShowProgress(boolean showProgress) {
        this.showProgress = showProgress;
    }

    public boolean isCache() {
        return cache;
    }

    public void setCache(boolean cache) {
        this.cache = cache;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getConnectionTime() {
        return connectionTime;
    }

    public void setConnectionTime(int connectionTime) {
        this.connectionTime = connectionTime;
    }

    public int getCookieNetWorkTime() {
        return cookieNetWorkTime;
    }

    public void setCookieNetWorkTime(int cookieNetWorkTime) {
        this.cookieNetWorkTime = cookieNetWorkTime;
    }

    public int getCookieNoNetWorkTime() {
        return cookieNoNetWorkTime;
    }

    public void setCookieNoNetWorkTime(int cookieNoNetWorkTime) {
        this.cookieNoNetWorkTime = cookieNoNetWorkTime;
    }

    /**
     * 得到请求的全路径
     *
     * @return
     */
    public String getUrl() {
        return baseUrl + method;
    }
}

