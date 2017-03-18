package com.classichu.subscription.bean;

import com.classichu.subscription.adapter.SubscriptionRecyclerViewAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by louisgeek on 2017/3/18.
 */

public class SubscriptionDataWrapper implements Serializable {

    private List<ItemBean> mItemBeanList = new ArrayList<>();
    private List<ItemBean> mItemBeanMoreList = new ArrayList<>();
    private String mItemTitle = "我的订阅";
    private String mItemSubTitle = "单击增删订阅，长按拖拽排序";
    private String mMoreItemTitle = "更多订阅";
    private String mMoreItemSubTitle = "";

    public SubscriptionDataWrapper addMoreItemBean(ItemBean itemBean) {
        mItemBeanMoreList.add(itemBean);
        return this;
    }

    public SubscriptionDataWrapper setItemTitle(String title) {
        mItemTitle = title;
        return this;
    }

    public SubscriptionDataWrapper setItemSubTitle(String title) {
        mItemSubTitle = title;
        return this;
    }

    public SubscriptionDataWrapper setMoreItemTitle(String title) {
        mMoreItemTitle = title;
        return this;
    }

    public SubscriptionDataWrapper setMoreItemSubTitle(String title) {
        mMoreItemSubTitle = title;
        return this;
    }

    public SubscriptionDataWrapper addItemBean(ItemBean itemBean) {
        mItemBeanList.add(itemBean);
        return this;
    }

    public List<SubscriptionBean> generateData() {
        List<SubscriptionBean> subscriptionBeanAllList = new ArrayList<>();
        SubscriptionBean subscriptionBean = new SubscriptionBean();
        subscriptionBean.setId(0);
        subscriptionBean.setText(mItemTitle);
        subscriptionBean.setText_sub(mItemSubTitle);
        subscriptionBean.setViewType(SubscriptionRecyclerViewAdapter.VIEW_TYPE_MY_TITLE);
        subscriptionBeanAllList.add(subscriptionBean);

        if (mItemBeanList != null && mItemBeanList.size() > 0) {
            for (int i = 0; i < mItemBeanList.size(); i++) {
                SubscriptionBean subscriptionBean_List = new SubscriptionBean();
                subscriptionBean_List.setId(i + 1);
                subscriptionBean_List.setText(mItemBeanList.get(i).getTitle());
                //  subscriptionBean_List.setText_sub(key + i);
                subscriptionBean_List.setViewType(SubscriptionRecyclerViewAdapter.VIEW_TYPE_MY_LIST);
                subscriptionBeanAllList.add(subscriptionBean_List);
            }
        }
        int itemBeanListCount = mItemBeanList == null ? 0 : mItemBeanList.size();
        //
        SubscriptionBean subscriptionBean_MORE = new SubscriptionBean();
        subscriptionBean_MORE.setId(1 + itemBeanListCount);
        subscriptionBean_MORE.setText(mMoreItemTitle);
        subscriptionBean_MORE.setText_sub(mMoreItemSubTitle);
        subscriptionBean_MORE.setViewType(SubscriptionRecyclerViewAdapter.VIEW_TYPE_MORE_TITLE);
        subscriptionBeanAllList.add(subscriptionBean_MORE);
        if (mItemBeanMoreList != null && mItemBeanMoreList.size() > 0) {
            for (int i = 0; i < mItemBeanMoreList.size(); i++) {
                SubscriptionBean subscriptionBean_MORE_List = new SubscriptionBean();
                subscriptionBean_MORE_List.setId(i + 1 + itemBeanListCount);
                subscriptionBean_MORE_List.setText(mItemBeanMoreList.get(i).getTitle());
                //  subscriptionBean_List.setText_sub(key + i);
                subscriptionBean_MORE_List.setViewType(SubscriptionRecyclerViewAdapter.VIEW_TYPE_MORE_LIST);
                subscriptionBeanAllList.add(subscriptionBean_MORE_List);
            }
        }
        return subscriptionBeanAllList;
    }
}
