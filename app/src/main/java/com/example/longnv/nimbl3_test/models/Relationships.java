package com.example.longnv.nimbl3_test.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Vu Long on 8/26/2018.
 * nguyenvulong2002@gmail.com
 */
public class Relationships {


    @SerializedName("user")
    @Expose
    private RelationshipsData user;
    @SerializedName("destination")
    @Expose
    private RelationshipsData destination;

    public IncludedData getUser() {
        return user.getData();
    }

    public void setUser(IncludedData user) {
        this.user.setData(user);
    }

    public IncludedData getDestination() {
        return destination.getData();
    }

    public void setDestination(IncludedData destination) {
        this.destination.setData(destination);
    }

}
