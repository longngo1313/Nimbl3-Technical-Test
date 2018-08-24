package com.example.longnv.nimbl3_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.longnv.nimbl3_test.api.ApiService;
import com.example.longnv.nimbl3_test.api.ApiUtils;
import com.example.longnv.nimbl3_test.models.DataResponse;
import com.example.longnv.nimbl3_test.models.IncludedData;
import com.example.longnv.nimbl3_test.models.Places;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainScreenActivity extends AppCompatActivity {

    private ApiService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mService = ApiUtils.getSOService();

        mService.getAnswers().enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if(response.isSuccessful()) {
                    for(IncludedData data : response.body().getItems()){
                        Log.d("MainActivity", "Data getType " + data.getType());
                        Log.d("MainActivity", "Data getCity " + data.getAttributes().getCity());
                        Log.d("MainActivity", "Data getName " + data.getAttributes().getName());
                        Log.d("MainActivity", "Data getCountry " + data.getAttributes().getCountry());
                        Log.d("MainActivity", "Data getCoverImage " + data.getAttributes().getCoverImage());
                    }
                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                }
                Log.d("MainActivity", "posts loaded from API ------------------SIZE---------"  + response.body().getItems().size() );
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                Log.d("MainActivity", "error loading from API");
            }
        });
        setContentView(R.layout.activity_main_screen);
    }
}
