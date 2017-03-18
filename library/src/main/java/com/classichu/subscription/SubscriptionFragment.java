package com.classichu.subscription;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.classichu.classichu.classic.ClassicFragment;
import com.classichu.subscription.adapter.SubscriptionRecyclerViewAdapter;
import com.classichu.subscription.model.SubscriptionModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SubscriptionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SubscriptionFragment extends ClassicFragment {



    public SubscriptionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SubscriptionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SubscriptionFragment newInstance(String param1, String param2) {
        SubscriptionFragment fragment = new SubscriptionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    protected int setupLayoutResId() {
        return R.layout.fragment_subscription;
    }
    SubscriptionRecyclerViewAdapter mAdapter;
    @Override
    protected void initView(View view) {

        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 4));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //##id_recycler_view.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this).build());
        List<Integer> canNotMovePosList=new ArrayList<>();
        canNotMovePosList.add(0);
        canNotMovePosList.add(1);
        canNotMovePosList.add(2);
        mAdapter = new SubscriptionRecyclerViewAdapter(new SubscriptionModel().gainData(),canNotMovePosList,
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
