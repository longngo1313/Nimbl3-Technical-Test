package com.example.longnv.nimbl3_test.api;

import com.example.longnv.nimbl3_test.models.DataResponse;
import com.example.longnv.nimbl3_test.models.Token;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Vu Long on 8/24/2018.
 * nguyenvulong2002@gmail.com
 */
public interface ApiService {
    
    @GET("feeds?access_token=2d45d05ab379427f9d00387e3a43a80360174530aacff2a7dbc5a1de4d62d642&page=1&filter[scope]=community")
    Call<DataResponse> getAnswers();


    @GET("feeds")
    Call<DataResponse> getAnswersWithFilter(@Query("access_token") String token,@Query("page") String page, @Query("filter[scope]") String scope);

    @POST("token?client_id=3bb0640f3232379a9e07c0c44f9ef5e764eefb9ba0e1d31168a90ecebe2bc67d&client_secret=073177b5f4f3489d46921c62629a42aa7b2bbdf57fc578bf2c61917957d037cc&grant_type=password&email=olivier@nimbl3.com&password=12345678")
    Call<Token> getTokenAPI();

}
