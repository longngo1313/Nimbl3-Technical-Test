package com.example.longnv.nimbl3_test.presenters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import com.example.longnv.nimbl3_test.base.BasePresenter;
import com.example.longnv.nimbl3_test.models.Data;
import com.example.longnv.nimbl3_test.models.DataResponse;
import com.example.longnv.nimbl3_test.models.IncludeDataAttributes;
import com.example.longnv.nimbl3_test.models.IncludedData;
import com.example.longnv.nimbl3_test.models.MainScreenModel;
import com.example.longnv.nimbl3_test.models.Places;
import com.example.longnv.nimbl3_test.models.Travelogue;
import com.example.longnv.nimbl3_test.models.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Response;

/**
 * Created by Vu Long on 8/27/2018.
 * nguyenvulong2002@gmail.com
 */
public class MainScreenPresenter extends BasePresenter<MainScreenModel> {

    public MainScreenPresenter(Context context) {
        super(context);
    }

    private ArrayList<User> mUserList;
    private ArrayList<Places> mPlaceList;

    @Override
    protected MainScreenModel setModel() {
        return new MainScreenModel(getContext());
    }

    public void getAllData(String scope){
        if(mModel == null){
            return;
        }
        mModel.getAllData(scope);

    }

    @Override
    public void onCallBackModel(String key, Object data) {

        if(data == null){
            return;
        }

        if(!(data instanceof  DataResponse)){
            return;
        }

        DataResponse response = (DataResponse) data;

        List<Data> dataList = response.getData();
        List<IncludedData> includedDataList = response.getIncludedData();

        if(dataList == null || dataList.isEmpty()){
            return;
        }

        if(includedDataList == null || includedDataList.isEmpty()){
            return;
        }

        mUserList = new ArrayList<>();
        mPlaceList = new ArrayList<>();

        for(IncludedData includedData: includedDataList){
            if (includedData.getType().equals("places")){
                mPlaceList.add(convertIncludeDataToPlace(includedData));
            }else if(includedData.getType().equals("users")){
                mUserList.add(convertIncludeDataToUser(includedData));
            }
        }

        ArrayList<Travelogue> travelogueArrayList = new ArrayList<>();

        for(Data singleData : dataList){
            if(singleData == null || singleData.getRelationships() == null || singleData.getTravelogue() == null){
                continue;
            }

            travelogueArrayList.add(convertDataToTravelogue(singleData));
        }

        this.getmICallBackPresenter().onCallBackPresenter(key, travelogueArrayList);

    }

    private Travelogue convertDataToTravelogue(Data singleData){
        Travelogue travelogue = singleData.getTravelogue();
        travelogue.setStartDate(convertDate(travelogue.getStartDate()));

        User user = findUserById(singleData.getRelationships().getUser().getId());
        Log.d("15081991" , "findUserById(singleData.getRelationships().getUser().getId())" + findUserById(singleData.getRelationships().getUser().getId()).getName());
        travelogue.setUser(findUserById(singleData.getRelationships().getUser().getId()));
        travelogue.setPlaces(findPlaceById(singleData.getId()));

        return travelogue;
    }

    private User convertIncludeDataToUser(IncludedData includedData){
        User user = new User();

        if(includedData == null){
            return user;
        }

        IncludeDataAttributes attributes = includedData.getIncludeDataAttributes();

        if (attributes == null){
            return user;
        }
        user.setId(includedData.getId());
        user.setFirstName(attributes.getFirstName());
        user.setLastName(attributes.getLastName());
        user.setUsername(attributes.getUsername());
        user.setAvatar(attributes.getAvatar());
        user.setLocation(attributes.getLocation());
        user.setPointsCount(attributes.getPointsCount());
        user.setFriendshipsCount(attributes.getFriendshipsCount());
        user.setCountriesCount(attributes.getCountriesCount());
        user.setIsFriend(attributes.getFriend());
        user.setName(attributes.getName());

        return user;
    }

    private Places convertIncludeDataToPlace(IncludedData includedData){
        Places place = new Places();

        if(includedData == null){
            return place;
        }

        IncludeDataAttributes attributes = includedData.getIncludeDataAttributes();

        if (attributes == null){
            return place;
        }
        place.setId(includedData.getId());
        place.setProvider(attributes.getProvider());
        place.setProviderPlaceId(attributes.getProviderPlaceId());
        place.setCountry(attributes.getCountry());
        place.setGeolocation(attributes.getGeolocation());
        place.setName(attributes.getName());
        place.setCoverImage(attributes.getCoverImage());
        place.setCityloguesCount(attributes.getCityloguesCount());
        place.setCity(attributes.getCity());
        place.setLocality(attributes.getLocality());
        place.setCityguideSlug(attributes.getCityguideSlug());
        return place;
    }


    private String convertDate(String rawDate){


        if(rawDate.isEmpty() || rawDate.length() < 10){
            return "";
        }

        SimpleDateFormat monthDate = new SimpleDateFormat("MMM \n yyyy", Locale.ENGLISH);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String actualDate = rawDate.substring(0, 10);
        Date date = null;

        try {
            date = sdf.parse(actualDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return monthDate.format(date).toUpperCase();
    }

    private User findUserById(String id){

        if(mUserList == null || mUserList.isEmpty()){
            return null;
        }
        for(User checkUser : mUserList){
            if(checkUser.getId().equals(id)){
                return checkUser;
            }
        }

        return null;
    }

    private Places findPlaceById(String id){
        Places places = new Places();

        if(mPlaceList == null || mPlaceList.isEmpty()){
            return places;
        }

        for(Places checkPlace: mPlaceList){
            if(checkPlace.getId().equals(id)){
                return places;
            }
        }

        return places;
    }


}
