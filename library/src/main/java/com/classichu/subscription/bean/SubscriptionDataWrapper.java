package com.classichu.subscription.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by louisgeek on 2017/3/18.
 */

public class SubscriptionDataWrapper implements Serializable {
    public List<SubscriptionBean> getSubscriptionBeanList() {
        return subscriptionBeanList;
    }

    public SubscriptionDataWrapper(List<SubscriptionBean> subscriptionBeanList) {
        this.subscriptionBeanList = subscriptionBeanList;
    }

    private List<SubscriptionBean> subscriptionBeanList;

}
