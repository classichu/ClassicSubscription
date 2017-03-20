package com.classichu.subscription.bean;

import com.classichu.subscription.adapter.SubscriptionRecyclerViewAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by louisgeek on 2017/3/18.
 */

public class SubscriptionBeanParse implements Serializable {

    private List<ItemBean> mMyItemBeanList = new ArrayList<>();
    private List<ItemBean> mMoreItemBeanList = new ArrayList<>();
    private String mMyItemTitle = "我的订阅";
    private String mMyItemSubTitle = "单击增删订阅，长按拖拽排序";
    private String mMoreItemTitle = "更多订阅";
    private String mMoreItemSubTitle = "";

    public SubscriptionBeanParse addMoreItemBean(ItemBean itemBean) {
        mMoreItemBeanList.add(itemBean);
        return this;
    }

    public SubscriptionBeanParse setMyItemTitle(String title) {
        mMyItemTitle = title;
        return this;
    }

    public SubscriptionBeanParse setMyItemSubTitle(String title) {
        mMyItemSubTitle = title;
        return this;
    }

    public SubscriptionBeanParse setMoreItemTitle(String title) {
        mMoreItemTitle = title;
        return this;
    }

    public SubscriptionBeanParse setMoreItemSubTitle(String title) {
        mMoreItemSubTitle = title;
        return this;
    }

    public SubscriptionBeanParse addMyItemBean(ItemBean itemBean) {
        mMyItemBeanList.add(itemBean);
        return this;
    }
    public SubscriptionBeanParse addMyItemBeans(List<ItemBean>  myItemBeanList) {
        mMyItemBeanList.addAll(myItemBeanList);
        return this;
    }
    public SubscriptionBeanParse addMoreItemBeans(List<ItemBean>  moreItemBeanList) {
        mMoreItemBeanList.addAll(moreItemBeanList);
        return this;
    }

    public List<SubscriptionBean> generateData() {
        List<SubscriptionBean> subscriptionBeanAllList = new ArrayList<>();
        SubscriptionBean subscriptionBean = new SubscriptionBean();
        subscriptionBean.setId(0);
        subscriptionBean.setText(mMyItemTitle);
        subscriptionBean.setText_sub(mMyItemSubTitle);
        subscriptionBean.setCanNotDrag(true);
        subscriptionBean.setViewType(SubscriptionRecyclerViewAdapter.VIEW_TYPE_MY_TITLE);
        subscriptionBeanAllList.add(subscriptionBean);

        if (mMyItemBeanList != null && mMyItemBeanList.size() > 0) {
            for (int i = 0; i < mMyItemBeanList.size(); i++) {
                SubscriptionBean subscriptionBean_List = new SubscriptionBean();
                subscriptionBean_List.setId(i + 1);
                subscriptionBean_List.setText(mMyItemBeanList.get(i).getTitle());
                //  subscriptionBean_List.setText_sub(key + i);
                subscriptionBean_List.setCanNotDrag(mMyItemBeanList.get(i).isSubscriptionAndCanNoMove());
                subscriptionBean_List.setViewType(SubscriptionRecyclerViewAdapter.VIEW_TYPE_MY_LIST);
                subscriptionBeanAllList.add(subscriptionBean_List);
            }
        }
        int itemBeanListCount = mMyItemBeanList == null ? 0 : mMyItemBeanList.size();
        //
        SubscriptionBean subscriptionBean_MORE = new SubscriptionBean();
        subscriptionBean_MORE.setId(1 + itemBeanListCount);
        subscriptionBean_MORE.setText(mMoreItemTitle);
        subscriptionBean_MORE.setText_sub(mMoreItemSubTitle);
        subscriptionBean_MORE.setCanNotDrag(true);
        subscriptionBean_MORE.setViewType(SubscriptionRecyclerViewAdapter.VIEW_TYPE_MORE_TITLE);
        subscriptionBeanAllList.add(subscriptionBean_MORE);
        if (mMoreItemBeanList != null && mMoreItemBeanList.size() > 0) {
            for (int i = 0; i < mMoreItemBeanList.size(); i++) {
                SubscriptionBean subscriptionBean_MORE_List = new SubscriptionBean();
                subscriptionBean_MORE_List.setId(i + 1 + itemBeanListCount);
                subscriptionBean_MORE_List.setText(mMoreItemBeanList.get(i).getTitle());
                //  subscriptionBean_List.setText_sub(key + i);
                subscriptionBean_MORE_List.setCanNotDrag(mMoreItemBeanList.get(i).isSubscriptionAndCanNoMove());
                subscriptionBean_MORE_List.setViewType(SubscriptionRecyclerViewAdapter.VIEW_TYPE_MORE_LIST);
                subscriptionBeanAllList.add(subscriptionBean_MORE_List);
            }
        }
        return subscriptionBeanAllList;
    }
}
