package com.classichu.subscription;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.classichu.classichu.classic.ClassicFragment;
import com.classichu.subscription.adapter.SubscriptionRecyclerViewAdapter;
import com.classichu.subscription.bean.SubscriptionDataWrapper;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ClassicSubscriptionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClassicSubscriptionFragment extends ClassicFragment {

    protected static final String ARG_PARAM4 = "param4";
    private SubscriptionDataWrapper mParam4 = null;

    public ClassicSubscriptionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ClassicSubscriptionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ClassicSubscriptionFragment newInstance(String param1, String param2,SubscriptionDataWrapper subscriptionDataWrapper) {
        ClassicSubscriptionFragment fragment = new ClassicSubscriptionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putSerializable(ARG_PARAM4,subscriptionDataWrapper);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam4 = (SubscriptionDataWrapper)getArguments().getSerializable(ARG_PARAM4);
        }
    }

    @Override
    protected int setupLayoutResId() {
        return R.layout.fragment_classic_subscription;
    }
    SubscriptionRecyclerViewAdapter mAdapter;
    @Override
    protected void initView(View view) {

        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 4));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //##id_recycler_view.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this).build());

        mAdapter = new SubscriptionRecyclerViewAdapter(mParam4.getSubscriptionBeanList(),
                mRecyclerView, R.layout.item_grid_classic);

        mRecyclerView.setAdapter(mAdapter);



    }


    @Override
    protected int configRecyclerViewResId()
    {
        return R.id.id_recycler_view;
    }

    @Override
    protected void initListener() {

    }

}
