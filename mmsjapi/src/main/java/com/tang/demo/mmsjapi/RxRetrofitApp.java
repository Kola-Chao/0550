package com.tang.demo.mmsjapi;

import android.app.Application;

/**
 * Introduce: 全局的Application
 * Author  : tangchao
 * Date   :2017/2/15
 * Time   :17:44
 */

public class RxRetrofitApp {
    private static Application application;

    public static void init(Application app) {
        setApplication(app);
    }

    public static Application getApplication() {
        return application;
    }

    public static void setApplication(Application application) {
        RxRetrofitApp.application = application;
    }
}
