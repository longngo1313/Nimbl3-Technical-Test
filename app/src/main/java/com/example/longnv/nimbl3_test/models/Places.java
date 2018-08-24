package com.example.longnv.nimbl3_test.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Vu Long on 8/24/2018.
 * nguyenvulong2002@gmail.com
 */
public class Places {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("type")
    @Expose
    private String type;
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
}