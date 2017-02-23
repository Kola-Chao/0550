package com.sxkj.a0550.apitest;

import java.util.List;

/**
 * Introduce:
 * Author：mac
 * Date：2017/2/23
 * Time: 上午10:29
 */

public class RetrofitEntity {
    private int ret;
    private String msg;
    private List<SubjectResult> data;

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

    public List<SubjectResult> getData() {
        return data;
    }

    public void setData(List<SubjectResult> data) {
        this.data = data;
    }
}
