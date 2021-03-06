package com.classichu.classicsubscription;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.classichu.subscription.ClassicSubscriptionFragment;
import com.classichu.subscription.bean.ItemBean;
import com.classichu.subscription.helper.ClassicSubscriptionDataHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ClassicSubscriptionFragment mClassicSubscriptionFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  List<SubscriptionBean> subscriptionBeanList = new SubscriptionBeanParse()
                .addMyItemBean(new ItemBean("test1", "测试1", true))
                .addMyItemBean(new ItemBean("test2", "测试2", true))
                .addMyItemBean(new ItemBean("test3", "测试3"))
                .addMyItemBean(new ItemBean("test4", "测试4"))
                .addMyItemBean(new ItemBean("test5", "测试5"))
                .addMoreItemBean(new ItemBean("dsada1", "测试6"))
                .addMoreItemBean(new ItemBean("dsada2", "测试7"))
                .addMoreItemBean(new ItemBean("dsada3", "测试8"))
                .addMoreItemBean(new ItemBean("dsada4", "测试9"))
                .addMoreItemBean(new ItemBean("dsada5", "测试10"))
                .addMoreItemBean(new ItemBean("dsada5", "测试11"))
                .addMoreItemBean(new ItemBean("dsada5", "测试12"))
                .generateData();*/

        List<ItemBean> my = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            my.add(new ItemBean(String.valueOf(i), "tut" + i));
        }

        List<ItemBean> more = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            more.add(new ItemBean(String.valueOf(i), "dsa" + i));
        }
    /*    mClassicSubscriptionFragment = ClassicSubscriptionFragment.newInstance("", "",
                new SubscriptionDataWrapper(subscriptionBeanList));
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.id_frame_layout_content, mClassicSubscriptionFragment)
                .commitAllowingStateLoss();*/


        ClassicSubscriptionDataHelper.setDataAndToSubscription(this, my, more);
    }

/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_finish, menu);
        return super.onCreateOptionsMenu(menu);
    }*/

  /*  @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.id_menu_finish:
                getData(mClassicSubscriptionFragment.getSubscriptionItemBeanList());
                break;
        }
        return super.onOptionsItemSelected(item);
    }*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        getData(ClassicSubscriptionDataHelper.callAtOnActivityResultBackSubscriptionData(requestCode, resultCode, data));

    }

    private void getData(List<ItemBean> itemBeanList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < itemBeanList.size(); i++) {
            sb.append(itemBeanList.get(i).getTitle());
        }
        Toast.makeText(MainActivity.this, "订阅：" + sb.toString(), Toast.LENGTH_SHORT).show();
    }
}
