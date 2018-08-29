package com.example.longnv.nimbl3_test.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RelationshipsData {
    @SerializedName("data")
    @Expose
    private IncludedData data;

    public IncludedData getData() {
        return data;
    }

    public void setData(IncludedData data) {
        this.data = data;
    }
}
