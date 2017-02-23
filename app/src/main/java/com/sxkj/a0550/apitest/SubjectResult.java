package com.sxkj.a0550.apitest;

/**
 * Introduce:
 * Author：mac
 * Date：2017/2/23
 * Time: 上午10:30
 */

public class SubjectResult {
    private int id;
    private String name;
    private String title;


    @Override
    public String toString() {
        return "name ->" + name + "\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
