package com.sxkj.a0550;

import android.app.Application;
import android.content.Context;

import com.sxkj.a0550.utils.Utils;
import com.tang.demo.mmsjapi.RxRetrofitApp;

/**
 * Introduce:
 * Author：mac
 * Date：2017/2/24
 * Time: 下午2:01
 */

public class MyApplication extends Application {
    public static Context app;

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.mcxt = this;
        app = getApplicationContext();
        RxRetrofitApp.init(this);
    }
}
