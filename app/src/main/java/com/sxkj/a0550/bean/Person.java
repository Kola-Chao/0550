package com.sxkj.a0550.bean;

import cn.bmob.v3.BmobObject;

/**
 *
 */
public class Person extends BmobObject {
    private String name;
    private String address;


    public Person() {
        //可自定义后台表名
        //也可在代码里动态设置
        this.setTableName("user");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
