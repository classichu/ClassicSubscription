package com.classichu.subscription.helper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.classichu.subscription.ClassicSubscriptionActivity;
import com.classichu.subscription.bean.ItemBean;
import com.classichu.subscription.bean.SubscriptionBean;
import com.classichu.subscription.bean.SubscriptionBeanParse;
import com.classichu.subscription.bean.SubscriptionDataBackWrapper;
import com.classichu.subscription.bean.SubscriptionDataWrapper;

import java.util.List;

import static android.app.Activity.RESULT_OK;

/**
 * Created by louisgeek on 2017/3/26.
 */

public class ClassicSubscriptionDataHelper {

    public static final int REQUEST_CODE_SUBSCRIPTION = 1214;

    public static void setDataAndToSubscription(FragmentActivity fragmentActivity, List<ItemBean> myItemBeanList, List<ItemBean> moreItemBeanList, boolean isTitleCenter) {
        Intent intent = new Intent(fragmentActivity, ClassicSubscriptionActivity.class);
        //
        List<SubscriptionBean> subscriptionBeanList;
        SubscriptionBeanParse subscriptionBeanParse = new SubscriptionBeanParse();
        if (myItemBeanList != null && myItemBeanList.size() > 0) {

            subscriptionBeanParse.addMyItemBeans(myItemBeanList);
        }
        if (moreItemBeanList != null && moreItemBeanList.size() > 0) {
            subscriptionBeanParse.addMoreItemBeans(moreItemBeanList);

        }
        subscriptionBeanList = subscriptionBeanParse.generateData();
        SubscriptionDataWrapper subscriptionDataWrapper = new SubscriptionDataWrapper(subscriptionBeanList);

        Bundle bundle = new Bundle();
        bundle.putSerializable("subscriptionDataWrapper", subscriptionDataWrapper);
        bundle.putBoolean("isTitleCenter", isTitleCenter);
        intent.putExtras(bundle);
        //
        fragmentActivity.startActivityForResult(intent, REQUEST_CODE_SUBSCRIPTION);
    }

    public static void setDataAndToSubscription(FragmentActivity fragmentActivity, List<ItemBean> myItemBeanList, List<ItemBean> moreItemBeanList) {
        setDataAndToSubscription(fragmentActivity, myItemBeanList, moreItemBeanList, true);
    }


    public static List<ItemBean> callAtOnActivityResultBackSubscriptionData(int requestCode, int resultCode, Intent data) {
        if (requestCode == ClassicSubscriptionDataHelper.REQUEST_CODE_SUBSCRIPTION
                && resultCode == RESULT_OK
                ) {
            SubscriptionDataBackWrapper wrapper = (SubscriptionDataBackWrapper) data.getSerializableExtra("subscriptionDataBackWrapper");
            if (wrapper != null) {
                return wrapper.getmItemBeanSelectedList();
            }
        }
        return null;
    }
}
