package com.example.longnv.nimbl3_test.models;

import android.content.Context;
import android.content.SharedPreferences;
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

    private static String sToken = "2d45d05ab379427f9d00387e3a43a80360174530aacff2a7dbc5a1de4d62d642";

    private static String sScope = "community";

    public static final String TOKEN = "TOKEN";
    public static final String PREFERENCE_KEY = "PREFERENCE_KEY";

    public MainScreenModel(Context context) {
        super(context);
    }

    public void getAllData(String scope){
        mService = ApiUtils.getSOService();

        String token = getTokenFromDB();

        if (token != null && !token.isEmpty()){
            sToken = token;
        }

        if (scope != null && !scope.isEmpty()){
            sScope = scope;
        }

        mService.getAnswersWithFilter(sToken, "1", sScope).enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if(response.isSuccessful()) {
                    Log.d("15081991" , "statusCode succes");
                    getmICallBackPresenter().onCallBackModel("DataResponse", response.body());
                }else {
                    int statusCode  = response.code();
                    Log.d("15081991" , "statusCode not succes" + response.raw().request().url());
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                Log.d("15081991", "error loading from API");
            }
        });



    }


    private String getTokenFromDB(){
        Context context = getContext();
        SharedPreferences sharedPref = context.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE);
        String token = sharedPref.getString(TOKEN, null);
        return token;
    }
}
