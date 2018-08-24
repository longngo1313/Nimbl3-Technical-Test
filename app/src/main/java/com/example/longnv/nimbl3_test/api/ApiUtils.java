package com.example.longnv.nimbl3_test.api;

/**
 * Created by Vu Long on 8/24/2018.
 * nguyenvulong2002@gmail.com
 */
public class ApiUtils {
    public static final String BASE_URL = "https://staging.travelbook.com/api/v1/";

    public static ApiService getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(ApiService.class);
    }
}
