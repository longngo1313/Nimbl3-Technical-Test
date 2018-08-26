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
    private List<IncludedData> includedData = null;

    @SerializedName("data")
    @Expose
    private List<Data> data = null;


    public List<IncludedData> getIncludedData() {
        return includedData;
    }

    public void setIncludedData(List<IncludedData> includedData) {
        this.includedData = includedData;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
