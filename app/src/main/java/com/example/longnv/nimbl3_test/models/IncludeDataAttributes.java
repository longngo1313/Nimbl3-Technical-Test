package com.example.longnv.nimbl3_test.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Vu Long on 8/26/2018.
 * nguyenvulong2002@gmail.com
 */
public class IncludeDataAttributes {

    @SerializedName("provider")
    @Expose
    private String provider;
    @SerializedName("provider_place_id")
    @Expose
    private String providerPlaceId;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("geolocation")
    @Expose
    private Geolocation geolocation;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("cover_image")
    @Expose
    private String coverImage;
    @SerializedName("citylogues_count")
    @Expose
    private Integer cityloguesCount;
    @SerializedName("city")
    @Expose
    private Object city;
    @SerializedName("locality")
    @Expose
    private Object locality;
    @SerializedName("cityguide_slug")
    @Expose
    private String cityguideSlug;
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


    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProviderPlaceId() {
        return providerPlaceId;
    }

    public void setProviderPlaceId(String providerPlaceId) {
        this.providerPlaceId = providerPlaceId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Geolocation getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(Geolocation geolocation) {
        this.geolocation = geolocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public Integer getCityloguesCount() {
        return cityloguesCount;
    }

    public void setCityloguesCount(Integer cityloguesCount) {
        this.cityloguesCount = cityloguesCount;
    }

    public Object getCity() {
        return city;
    }

    public void setCity(Object city) {
        this.city = city;
    }

    public Object getLocality() {
        return locality;
    }

    public void setLocality(Object locality) {
        this.locality = locality;
    }

    public String getCityguideSlug() {
        return cityguideSlug;
    }

    public void setCityguideSlug(String cityguideSlug) {
        this.cityguideSlug = cityguideSlug;
    }

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

    public Boolean getFriend() {
        return isFriend;
    }

    public void setFriend(Boolean friend) {
        isFriend = friend;
    }
}
