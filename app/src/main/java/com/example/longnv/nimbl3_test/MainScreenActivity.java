package com.example.longnv.nimbl3_test;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.longnv.nimbl3_test.adapter.TravellogueListAdapter;
import com.example.longnv.nimbl3_test.api.ApiService;
import com.example.longnv.nimbl3_test.api.ApiUtils;
import com.example.longnv.nimbl3_test.base.BaseActivity;
import com.example.longnv.nimbl3_test.models.Data;
import com.example.longnv.nimbl3_test.models.DataResponse;
import com.example.longnv.nimbl3_test.models.IncludedData;
import com.example.longnv.nimbl3_test.models.MainScreenModel;
import com.example.longnv.nimbl3_test.models.Places;
import com.example.longnv.nimbl3_test.models.Travelogue;
import com.example.longnv.nimbl3_test.presenters.MainScreenPresenter;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainScreenActivity extends BaseActivity<MainScreenPresenter> {

    private RecyclerView mListTravelLogue;

    private SwipeRefreshLayout mRefreshLayout;

    private ExpandableRelativeLayout mExpandableLayout;

    private ImageButton mBtnFilter;

    private Button mBtnFriend, mBtnComunity;

    public static String sScope = "community";

    public static final String COMUNITY_SCOPE = "community";
    public static final String FRIENDS_SCOPE = "friends";

    @Override
    protected int setViewLayout() {
        return R.layout.activity_main_screen;
    }

    @Override
    protected void onSetupLayout() {
        mListTravelLogue = findViewById(R.id.ls_travelogue);
        mRefreshLayout = findViewById(R.id.layout_swipe_refresh);
        mExpandableLayout = findViewById(R.id.expandableLayout);
        mBtnFilter = findViewById(R.id.btn_dropdown);
        mBtnComunity = findViewById(R.id.btn_community);
        mBtnFriend = findViewById(R.id.btn_friend);

        mRefreshLayout.setColorSchemeResources(R.color.colorPrimary,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);

        if(mRefreshLayout != null){
            mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    loadData();
                }
            });
        }

        mExpandableLayout.collapse();

        mBtnComunity.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.btn_pressed_color));

        mBtnComunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mRefreshLayout.isRefreshing()){
                    return;
                }

                mBtnComunity.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.btn_pressed_color));
                mBtnFriend.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.btn_normal_color));
                switchSortMethod(COMUNITY_SCOPE);
            }
        });

        mBtnFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mRefreshLayout.isRefreshing()){
                    return;
                }

                mBtnFriend.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.btn_pressed_color));
                mBtnComunity.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.btn_normal_color));
                switchSortMethod(FRIENDS_SCOPE);
            }
        });

        mBtnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mExpandableLayout.isExpanded()){
                    mBtnFilter.setImageResource(R.drawable.icon_dropdown2x);
                }else {
                    mBtnFilter.setImageResource(R.drawable.icon_dropup2x);
                }

                mExpandableLayout.toggle();
            }
        });

        loadData();
    }

    @NonNull
    @Override
    protected MainScreenPresenter setPresenter() {
        return new MainScreenPresenter(getApplicationContext());
    }

    @Override
    public void onCallBackPresenter(String key, Object data) {
        mRefreshLayout.setRefreshing(false);
        if(key.equals(MainScreenModel.DATA_SUCCES_STATUS)){
            ArrayList<Travelogue> travelogueList = (ArrayList<Travelogue>) data;
            showListData(travelogueList);
        }else if(key.equals(MainScreenModel.DATA_ERROR_STATUS)) {
            showRequestTokenPopup();
        }else if(key.equals(MainScreenModel.TOKEN_ERROR_STATUS)){
            showErrorPopup("Getting Token Error", String.valueOf(data));
        }else if(key.equals(MainScreenModel.CONECTION_ERROR_STATUS)){
            showErrorPopup("Get Data Error", String.valueOf(data));
        }

    }

    private void loadData(){
        Log.d("15081991", "LOAD DATA");
        mRefreshLayout.setRefreshing(true);

        getPresenter().getAllData(sScope);
    }

    private void showErrorPopup(String title, String message){
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);

        builder.setTitle(title)
                .setMessage(message)
                .setNeutralButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //DO nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    private void showRequestTokenPopup(){
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);

        builder.setTitle("Failed Loading")
                .setMessage("Trying to get new token?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("15081991", "Get new tokken");
                        getPresenter().getAccessToken();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //Do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    private void showListData(ArrayList<Travelogue> travelogueList ){

        TravellogueListAdapter questionListAdapter = new TravellogueListAdapter(travelogueList, this);

        mListTravelLogue.setAdapter(questionListAdapter);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mListTravelLogue.setLayoutManager(layoutManager);

        mListTravelLogue.setItemAnimator(new DefaultItemAnimator());

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mListTravelLogue.getContext(),
                layoutManager.getOrientation());
        mListTravelLogue.addItemDecoration(dividerItemDecoration);

    }

    private void switchSortMethod(String changeScope){

        if(changeScope == null && !changeScope.equals(COMUNITY_SCOPE) && !changeScope.equals(FRIENDS_SCOPE)){
            return;
        }

        if (!changeScope.equals(sScope) ){
            sScope = changeScope;
            loadData();
        }
    }


}
