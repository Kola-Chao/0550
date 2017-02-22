package com.tang.demo.mmsjapi.http.cookie;

import com.tang.demo.mmsjapi.utils.CookieDbUtil;

import java.io.IOException;

import okhttp3.Cookie;
import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Introduce:
 * Author  : tangchao
 * Date   :2017/2/15
 * Time   :10:46
 */

public class CookieInterceptor implements Interceptor{
    private CookieDbUtil dbUtil;
    @Override
    public Response intercept(Chain chain) throws IOException {
        return null;
    }
}
