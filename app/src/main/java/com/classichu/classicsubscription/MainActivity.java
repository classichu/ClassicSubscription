package com.classichu.classicsubscription;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.classichu.subscription.SubscriptionFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.id_frame_layout_content,SubscriptionFragment.newInstance("",""))
                .commitAllowingStateLoss();
    }
}
