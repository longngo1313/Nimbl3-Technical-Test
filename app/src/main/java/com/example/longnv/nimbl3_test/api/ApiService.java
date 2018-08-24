package com.example.longnv.nimbl3_test.api;

import com.example.longnv.nimbl3_test.models.DataResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Vu Long on 8/24/2018.
 * nguyenvulong2002@gmail.com
 */
public interface ApiService {

    @GET("feeds?access_token=2d45d05ab379427f9d00387e3a43a80360174530aacff2a7dbc5a1de4d62d642&page=1&filter[scope]=community")
    Call<DataResponse> getAnswers();
}
