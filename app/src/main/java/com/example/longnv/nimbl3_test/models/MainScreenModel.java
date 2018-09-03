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
    //private static String sToken = "5f0d6176a9e9434d5d2b4e839a4d77445c9250d452ab466073d508d9f0a5a593";

    private static String sScope = "community";

    public static final String TOKEN = "TOKEN";
    public static final String PREFERENCE_KEY = "PREFERENCE_KEY";

    public static final String DATA_SUCCES_STATUS = "DataResponse Success";
    public static final String TOKEN_SUCCES_STATUS = "Token Success";
    public static final String DATA_ERROR_STATUS = "DataResponse Error";
    public static final String TOKEN_ERROR_STATUS = "Token Error";

    public static final String CONECTION_ERROR_STATUS = "DataResponse";

    public MainScreenModel(Context context) {
        super(context);
    }

    public void getAllData(String scope){
        mService = ApiUtils.getAPIService();

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
                    getmICallBackPresenter().onCallBackModel(DATA_SUCCES_STATUS, response.body());
                }else {
                    int statusCode  = response.code();
                    getmICallBackPresenter().onCallBackModel(DATA_ERROR_STATUS, statusCode);
                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                getmICallBackPresenter().onCallBackModel(CONECTION_ERROR_STATUS, t.toString());
            }
        });



    }

    public void getTokenFromServer(){
        mService = ApiUtils.getAPIService();

        mService.getTokenAPI().enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                if(response.isSuccessful()) {
                    setTokenToDB(response.body().getAccessToken());
                    getmICallBackPresenter().onCallBackModel(TOKEN_SUCCES_STATUS, response.body().getAccessToken());
                }else {
                    int statusCode  = response.code();
                    getmICallBackPresenter().onCallBackModel(TOKEN_ERROR_STATUS, statusCode);
                }
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                Log.d("15081991 ---","onFailure" + t.toString());
                getmICallBackPresenter().onCallBackModel(CONECTION_ERROR_STATUS, t.toString());
            }
        });
    }


    private String getTokenFromDB(){
        Context context = getContext();
        SharedPreferences sharedPref = context.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE);
        String token = sharedPref.getString(TOKEN, null);
        return token;
    }

    private String setTokenToDB(String token){
        SharedPreferences sharedPref = getContext().getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(TOKEN, token);
        editor.apply();
        return token;
    }
}
