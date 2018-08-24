package com.example.longnv.nimbl3_test.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Vu Long on 8/24/2018.
 * nguyenvulong2002@gmail.com
 */
public class IncludedData {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("attributes")
    @Expose
    private Places attributes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Places getAttributes() {
        return attributes;
    }

    public void setAttributes(Places attributes) {
        this.attributes = attributes;
    }
}
