package com.tang.demo.mmsjapi.listener;

/**
 * Introduce:
 * Author  : tangchao
 * Date   :2017/2/14
 * Time   :17:05
 */

public abstract class HttpOnNextListener<T> {
    /**
     * 成功后的回调
     *
     * @param t
     */
    public abstract void onNext(T t);

    /**
     * 缓存回调
     *
     * @param string
     */
    public void onCacheNext(String string) {

    }

    /**
     * 失败或者出现错误
     *
     * @param e
     */
    public void onError(Throwable e) {

    }

    /**
     * 取消的回调
     */
    public void onCancel() {

    }
}
