package com.classichu.subscription.bean;

/**
 * Created by louisgeek on 2017/3/18.
 */

public class ItemBean {
    private String code;

    public ItemBean(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getCode() {
        return code;
    }


    public String getTitle() {
        return title;
    }


    private String title;
}
