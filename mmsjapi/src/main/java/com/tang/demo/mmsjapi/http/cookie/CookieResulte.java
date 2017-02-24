package com.tang.demo.mmsjapi.http.cookie;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;


/**
 * Introduce:
 * Author  : tangchao
 * Date   :2017/2/15
 * Time   :17:39
 */
@Entity
public class CookieResulte {
    @Id
    private long id;
    //url
    private String url;
    //返回结果
    private String result;
    //时间
    private long time;

    public long getTime() {
        return this.time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CookieResulte(String url, String result, long time) {
        this.url = url;
        this.result = result;
        this.time = time;
    }

    @Generated(hash = 1542439357)
    public CookieResulte(long id, String url, String result, long time) {
        this.id = id;
        this.url = url;
        this.result = result;
        this.time = time;
    }

    @Generated(hash = 2104390000)
    public CookieResulte() {
    }

}
