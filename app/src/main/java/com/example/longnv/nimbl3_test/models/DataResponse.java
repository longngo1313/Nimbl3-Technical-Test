package com.example.longnv.nimbl3_test.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Vu Long on 8/24/2018.
 * nguyenvulong2002@gmail.com
 */
public class DataResponse {

    @SerializedName("included")
    @Expose
    private List<IncludedData> items = null;

    public List<IncludedData> getItems() {
        return items;
    }

    public void setItems(List<IncludedData> items) {
        this.items = items;
    }
}
