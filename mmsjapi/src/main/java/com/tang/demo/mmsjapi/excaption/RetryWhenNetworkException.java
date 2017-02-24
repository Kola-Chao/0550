package com.tang.demo.mmsjapi.excaption;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;

/**
 * Introduce:
 * Author：mac
 * Date：2017/2/24
 * Time: 上午10:25
 */

public class RetryWhenNetworkException implements Func1<Observable<? extends Throwable>, Observable<?>> {
    //retry次数
    private int count = 3;
    //延迟时间
    private long delay = 3000;
    //叠加延迟
    private long increaseDelay = 3000;

    public RetryWhenNetworkException() {
    }

    public RetryWhenNetworkException(int count, long delay) {
        this.count = count;
        this.delay = delay;
    }

    public RetryWhenNetworkException(int count, long delay, long increaseDelay) {
        this.count = count;
        this.delay = delay;
        this.increaseDelay = increaseDelay;
    }

    @Override
    public Observable<?> call(Observable<? extends Throwable> observable) {
        return observable.zipWith(Observable.range(1, count + 1), new Func2<Throwable, Integer, Wrapper>() {

            @Override
            public Wrapper call(Throwable throwable, Integer integer) {
                return new Wrapper(integer, throwable);
            }
        }).flatMap(new Func1<Wrapper, Observable<?>>() {
            @Override
            public Observable<?> call(Wrapper wrapper) {
                if ((wrapper.throwable instanceof ConnectException
                        || wrapper.throwable instanceof SocketTimeoutException
                        || wrapper.throwable instanceof TimeoutException)
                        && wrapper.index < count + 1) {//如果超出重试的次数也抛异常推出
                    return Observable.timer(delay + (wrapper.index - 1) * increaseDelay, TimeUnit.MILLISECONDS);
                }
                return Observable.error(wrapper.throwable);
            }
        });
    }

    private class Wrapper {
        private int index;
        private Throwable throwable;

        public Wrapper(int index, Throwable throwable) {
            this.index = index;
            this.throwable = throwable;
        }
    }
}
