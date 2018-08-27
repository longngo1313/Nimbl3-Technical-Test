package com.example.longnv.nimbl3_test;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;

import com.example.longnv.nimbl3_test.adapter.TravellogueListAdapter;
import com.example.longnv.nimbl3_test.api.ApiService;
import com.example.longnv.nimbl3_test.api.ApiUtils;
import com.example.longnv.nimbl3_test.base.BaseActivity;
import com.example.longnv.nimbl3_test.models.Data;
import com.example.longnv.nimbl3_test.models.DataResponse;
import com.example.longnv.nimbl3_test.models.IncludedData;
import com.example.longnv.nimbl3_test.models.Places;
import com.example.longnv.nimbl3_test.models.Travelogue;
import com.example.longnv.nimbl3_test.presenters.MainScreenPresenter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainScreenActivity extends BaseActivity<MainScreenPresenter> {

    private RecyclerView mListTravelLogue;

    @Override
    protected int setViewLayout() {
        return R.layout.activity_main_screen;
    }

    @Override
    protected void onSetupLayout() {
        mListTravelLogue = findViewById(R.id.ls_travelogue);

        getPresenter().getAllData();
    }

    @NonNull
    @Override
    protected MainScreenPresenter setPresenter() {
        return new MainScreenPresenter(getApplicationContext());
    }

    @Override
    public void onCallBackPresenter(String key, Object data) {


        ArrayList<Travelogue> travelogueList = (ArrayList<Travelogue>) data;

        Log.d("15081991 ", "travelogueList   " + travelogueList.size());
        Log.d("15081991 ", "travelogueList  getCoverImageUrl " + travelogueList.get(0).getCoverImageUrl());
        Log.d("15081991 ", "travelogueList  Main thread " + Thread.currentThread().getName());

        TravellogueListAdapter questionListAdapter = new TravellogueListAdapter(travelogueList, this);

        mListTravelLogue.setAdapter(questionListAdapter);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mListTravelLogue.setLayoutManager(layoutManager);

//        SnapHelper helper = new LinearSnapHelper();
//        helper.attachToRecyclerView(mListTravelLogue);
        mListTravelLogue.setItemAnimator(new DefaultItemAnimator());

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mListTravelLogue.getContext(),
                layoutManager.getOrientation());
        mListTravelLogue.addItemDecoration(dividerItemDecoration);

    }
}
