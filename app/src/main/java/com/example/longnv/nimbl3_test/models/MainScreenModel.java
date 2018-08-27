package com.example.longnv.nimbl3_test.models;

import android.content.Context;
import android.util.Log;

import com.example.longnv.nimbl3_test.api.ApiService;
import com.example.longnv.nimbl3_test.api.ApiUtils;
import com.example.longnv.nimbl3_test.base.BaseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Vu Long on 8/27/2018.
 * nguyenvulong2002@gmail.com
 */
public class MainScreenModel extends BaseModel {

    private ApiService mService;

    public MainScreenModel(Context context) {
        super(context);
    }

    public void getAllData(){
        mService = ApiUtils.getSOService();
        mService.getAnswers().enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if(response.isSuccessful()) {
                    getmICallBackPresenter().onCallBackModel("DataResponse", response.body());
                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                Log.d("MainActivity", "error loading from API");
            }
        });



    }
}
