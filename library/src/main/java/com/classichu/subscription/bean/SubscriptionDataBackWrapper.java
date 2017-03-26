package com.classichu.subscription.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by louisgeek on 2017/3/18.
 */

public class SubscriptionDataBackWrapper implements Serializable {


    public SubscriptionDataBackWrapper(List<ItemBean> mItemBeanSelectedList) {
        this.mItemBeanSelectedList = mItemBeanSelectedList;
    }

    public List<ItemBean> getmItemBeanSelectedList() {
        return mItemBeanSelectedList;
    }

    private List<ItemBean> mItemBeanSelectedList;

}
