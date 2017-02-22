package com.tang.demo.mmsjapi.bean;

/**
 * Introduce: 最基础的请求结果类封装
 * Author  : tangchao
 * Date   :2017/2/14
 * Time   :16:57
 */

public class BaseResultEntity<T> {
    //返回码
    private int ret;
    //返回信息
    private String msg;
    //返回数据
    private T data;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
