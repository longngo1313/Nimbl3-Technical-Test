package com.example.longnv.nimbl3_test.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Vu Long on 8/26/2018.
 * nguyenvulong2002@gmail.com
 */
public class User {

    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("points_count")
    @Expose
    private String pointsCount;
    @SerializedName("friendships_count")
    @Expose
    private Integer friendshipsCount;
    @SerializedName("countries_count")
    @Expose
    private Integer countriesCount;

    @SerializedName("is_friend")
    @Expose
    private Boolean isFriend;
    @SerializedName("name")
    @Expose
    private String name;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPointsCount() {
        return pointsCount;
    }

    public void setPointsCount(String pointsCount) {
        this.pointsCount = pointsCount;
    }

    public Integer getFriendshipsCount() {
        return friendshipsCount;
    }

    public void setFriendshipsCount(Integer friendshipsCount) {
        this.friendshipsCount = friendshipsCount;
    }

    public Integer getCountriesCount() {
        return countriesCount;
    }

    public void setCountriesCount(Integer countriesCount) {
        this.countriesCount = countriesCount;
    }

    public Boolean getIsFriend() {
        return isFriend;
    }

    public void setIsFriend(Boolean isFriend) {
        this.isFriend = isFriend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
