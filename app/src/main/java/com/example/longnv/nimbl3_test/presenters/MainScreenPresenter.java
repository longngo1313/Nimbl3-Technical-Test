package com.example.longnv.nimbl3_test.presenters;

import android.content.Context;

import com.example.longnv.nimbl3_test.base.BasePresenter;
import com.example.longnv.nimbl3_test.models.Data;
import com.example.longnv.nimbl3_test.models.DataResponse;
import com.example.longnv.nimbl3_test.models.IncludeDataAttributes;
import com.example.longnv.nimbl3_test.models.IncludedData;
import com.example.longnv.nimbl3_test.models.MainScreenModel;
import com.example.longnv.nimbl3_test.models.Places;
import com.example.longnv.nimbl3_test.models.Travelogue;
import com.example.longnv.nimbl3_test.models.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

/**
 * Created by Vu Long on 8/27/2018.
 * nguyenvulong2002@gmail.com
 */
public class MainScreenPresenter extends BasePresenter<MainScreenModel> {

    public MainScreenPresenter(Context context) {
        super(context);
    }

    @Override
    protected MainScreenModel setModel() {
        return new MainScreenModel(getContext());
    }

    public void getAllData(){
        if(mModel == null){
            return;
        }
        mModel.getAllData();

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

        ArrayList<User> users  = new ArrayList<>();
        ArrayList<Places> places = new ArrayList<>();

        for(IncludedData includedData: includedDataList){
            if (includedData.getType().equals("places")){
                places.add(convertIncludeDataToPlace(includedData));
            }else if(includedData.getType().equals("users")){
                users.add(convertIncludeDataToUser(includedData));
            }
        }

        ArrayList<Travelogue> travelogueArrayList = new ArrayList<>();

        for(Data singleData : dataList){

            Travelogue travelogue = singleData.getTravelogue();
            travelogue.setUser(users.get(0));
            travelogue.setPlaces(places.get(0));

            travelogueArrayList.add(travelogue);
        }

        this.getmICallBackPresenter().onCallBackPresenter(key, travelogueArrayList);

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



}
