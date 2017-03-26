package com.classichu.subscription;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.classichu.subscription.bean.SubscriptionDataBackWrapper;
import com.classichu.subscription.bean.SubscriptionDataWrapper;

public class ClassicSubscriptionActivity extends AppCompatActivity {

    private   ClassicSubscriptionFragment  mClassicSubscriptionFragment ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classic_subscription);

        if (getIntent()!=null&&getIntent().getExtras()!=null);
        {
            Bundle bundle=getIntent().getExtras();
            SubscriptionDataWrapper subscriptionDataWrapper = (SubscriptionDataWrapper) bundle.getSerializable("subscriptionDataWrapper");
            mIsToolbarTitleCenter =bundle.getBoolean("isTitleCenter");

            mClassicSubscriptionFragment = ClassicSubscriptionFragment.newInstance("", "",subscriptionDataWrapper
            );
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.id_frame_layout_content, mClassicSubscriptionFragment)
                    .commitAllowingStateLoss();
        }


        initToolbar();
    }


    private TextView mToolbarTitleView;
    private Toolbar mToolbar;
    private boolean mIsToolbarTitleCenter=true;

    protected void setToolbarTitle(String string) {
        if (mIsToolbarTitleCenter) {
            if (mToolbarTitleView != null) {
                mToolbarTitleView.setText(string);
                mToolbar.setTitle("");
                mToolbarTitleView.setVisibility(View.VISIBLE);
            }
        } else {
            if (mToolbarTitleView != null) {
                mToolbarTitleView.setText("");
                mToolbar.setTitle(string);
                mToolbarTitleView.setVisibility(View.GONE);
            }
        }
    }
    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.id_toolbar);
        if (mToolbar == null) {
            return;
        }
        mToolbarTitleView = (TextView) mToolbar.findViewById(R.id.id_toolbar_title);

        /**
         * setToolbarTitle
         */
        this.setToolbarTitle(mToolbar.getTitle() != null ? mToolbar.getTitle().toString() : "");

        mToolbar.setVisibility(View.VISIBLE);
        //替换ActionBar
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        //必须设置在setSupportActionBar(mToolbar);后才有效
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                finishSubscriptionOperator();
            }
        });
    }

    private void finishSubscriptionOperator() {
        SubscriptionDataBackWrapper subscriptionDataBackWrapper=
                new SubscriptionDataBackWrapper(mClassicSubscriptionFragment.getSubscriptionItemBeanList());
        Intent intent = new Intent();
        intent.putExtra("subscriptionDataBackWrapper",subscriptionDataBackWrapper );
        setResult(RESULT_OK, intent);
        finish();
    }


}
