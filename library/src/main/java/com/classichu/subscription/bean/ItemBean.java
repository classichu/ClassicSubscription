package com.classichu.subscription.bean;

import java.io.Serializable;

/**
 * Created by louisgeek on 2017/3/18.
 */

public class ItemBean implements Serializable {
    private String code;
    private String title;
    private boolean isSubscriptionAndCanNoMove;

    public ItemBean(String code, String title, boolean isSubscriptionAndCanNoMove) {
        this.code = code;
        this.title = title;
        this.isSubscriptionAndCanNoMove = isSubscriptionAndCanNoMove;
    }

    public ItemBean(String code, String title) {
        this(code, title, false);
    }

    public String getCode() {
        return code;
    }


    public String getTitle() {
        return title;
    }

    public boolean isSubscriptionAndCanNoMove() {
        return isSubscriptionAndCanNoMove;
    }
}
