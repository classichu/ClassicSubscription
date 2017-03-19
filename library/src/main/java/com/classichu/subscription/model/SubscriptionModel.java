package com.classichu.subscription.model;

import com.classichu.subscription.bean.ItemBean;
import com.classichu.subscription.bean.SubscriptionBean;
import com.classichu.subscription.bean.SubscriptionBeanParse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by louisgeek on 2017/3/18.
 */

public class SubscriptionModel {

    public List<SubscriptionBean> gainData() {
        List<SubscriptionBean> subscriptionBeanList = new ArrayList<>();
        subscriptionBeanList=new SubscriptionBeanParse()
                .setMoreItemSubTitle("999")
                .addMyItemBean(new ItemBean("test1","测试1"))
                .addMyItemBean(new ItemBean("test2","测试2"))
                .addMyItemBean(new ItemBean("test3","测试3"))
                .addMyItemBean(new ItemBean("test4","测试4"))
                .addMyItemBean(new ItemBean("test5","测试5"))
                .addMoreItemBean(new ItemBean("dsada1","dasdas1"))
                .addMoreItemBean(new ItemBean("dsada2","dasdas2"))
                .addMoreItemBean(new ItemBean("dsada3","dasdas3"))
                .addMoreItemBean(new ItemBean("dsada4","dasdas4"))
                .addMoreItemBean(new ItemBean("dsada5","dasdas5"))
                .addMoreItemBean(new ItemBean("dsada5","dasdas6"))
                .addMoreItemBean(new ItemBean("dsada5","dasdas7"))
                .generateData();
        return subscriptionBeanList;
    }
}
