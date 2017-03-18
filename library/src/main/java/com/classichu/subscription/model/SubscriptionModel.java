package com.classichu.subscription.model;

import com.classichu.subscription.bean.ItemBean;
import com.classichu.subscription.bean.SubscriptionBean;
import com.classichu.subscription.bean.SubscriptionDataWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by louisgeek on 2017/3/18.
 */

public class SubscriptionModel {

    public List<SubscriptionBean> gainData() {
        List<SubscriptionBean> subscriptionBeanList = new ArrayList<>();
        subscriptionBeanList=new SubscriptionDataWrapper()
                .setMoreItemSubTitle("999")
                .addItemBean(new ItemBean("test1","测试1"))
                .addItemBean(new ItemBean("test2","测试2"))
                .addItemBean(new ItemBean("test3","测试3"))
                .addMoreItemBean(new ItemBean("dsada1","dasdas"))
                .addMoreItemBean(new ItemBean("dsada2","dasdas"))
                .addMoreItemBean(new ItemBean("dsada3","dasdas"))
                .generateData();
        return subscriptionBeanList;
    }
}
