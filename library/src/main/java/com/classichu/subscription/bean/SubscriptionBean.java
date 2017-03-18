package com.classichu.subscription.bean;

import java.io.Serializable;

/**
 * Created by louisgeek on 2017/3/18.
 */

public class SubscriptionBean implements Serializable {
    private int id;
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText_sub() {
        return text_sub;
    }

    public void setText_sub(String text_sub) {
        this.text_sub = text_sub;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    private String text_sub;
    private int viewType;
}
