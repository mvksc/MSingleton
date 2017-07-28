package com.mdev.msingleton.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mdev.msingleton.BuildConfig;
import com.mdev.msingleton.R;
import com.mdev.msingleton.adapter.CustomAdapterTableBall;
import com.mdev.msingleton.bus.BusProvider;
import com.mdev.msingleton.manager.CheckIDSingleton;
import com.mdev.msingleton.manager.HTSingleton;
import com.mdev.msingleton.model.BusUpdateAdapter;
import com.mdev.msingleton.model.ModelDataBall;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;


public class HTFragment extends Fragment {
    private RecyclerView reyHT;
    private CustomAdapterTableBall adapter;
    private List<ModelDataBall> dataSet;
    private GridLayoutManager gridLayoutManager;
    public HTFragment() {}
    public static HTFragment newInstance() {
        HTFragment fragment = new HTFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BusProvider.getInstance().register(this);
        dataSet = new ArrayList<>();
        if (savedInstanceState != null){
            dataSet = savedInstanceState.getParcelableArrayList("dataSet");
        }
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("dataSet", (ArrayList<? extends Parcelable>) dataSet);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ht, container, false);
        initView(rootView);
        return rootView;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dataSet = HTSingleton.getInstance().getDataBall();
        adapter = new CustomAdapterTableBall(getActivity(),dataSet,1);
        reyHT.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        adapter.setOnClickItem(new CustomAdapterTableBall.onClickItem() {
            @Override
            public void onClickItem(int position, String add, String no, int subClick, String subTypeTangBall, String billID, String playStep) {
                onShowLogCat("Check On Click HT = > " + position + " : " + subClick + " : " + subTypeTangBall + " : " + no + " : " + billID + " : " + playStep);
                if (position < dataSet.size()){
                    CheckIDSingleton.getInstance().onCheckIdTang(2,position,add,no,subClick,subTypeTangBall,billID,playStep);
                }
                adapter.notifyDataSetChanged();
                BusUpdateAdapter upDate = new BusUpdateAdapter();
                upDate.setUpdateAdapter(true);
                BusProvider.getInstance().post(upDate);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        BusProvider.getInstance().unregister(this);
    }

    @Subscribe
    public void onBusUpdateAdapter(BusUpdateAdapter upDate){
        if (upDate != null && upDate.isUpdateAdapter()){
            adapter.notifyDataSetChanged();
        }
    }

    private void initView(View rootView) {
        reyHT = (RecyclerView) rootView.findViewById(R.id.reyHT);
        gridLayoutManager = new GridLayoutManager(getActivity(),1);
        reyHT.setLayoutManager(gridLayoutManager);
    }
    private void onShowLogCat(String msg){
        if (BuildConfig.DEBUG){
            Log.e("***HTFragment***",msg);
        }
    }
}
