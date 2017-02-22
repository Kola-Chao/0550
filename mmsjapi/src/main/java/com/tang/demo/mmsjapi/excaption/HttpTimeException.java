package com.tang.demo.mmsjapi.excaption;

/**
 * Introduce:
 * Author  : tangchao
 * Date   :2017/2/14
 * Time   :17:14
 */

public class HttpTimeException extends RuntimeException {
    public static final int NO_DATA = 0x2;

    public HttpTimeException(int resultCode) {
        this(getApiExceptionMessage(resultCode));
    }

    public HttpTimeException(String message) {
        super(message);
    }

    private static String getApiExceptionMessage(int code) {
        String message = "";
        switch (code) {
            case NO_DATA:
                message = "无数据";
                break;
            default:
                message = "error";
                break;
        }
        return message;
    }
}
