package com.fernandocejas.android10.sample.domain;

import javax.inject.Inject;

/**
 * Created by wolf on 8/17/2016.
 */

/*
 * Class that represents a user in the presentation layer
 */
public class UserModel {

    private String mUserName;
    private String mUserPassword; //This application assumes there will be a secure password system
    private long mLatitude;
    private long mLongitude;

    @Inject
    public UserModel(){}

    public UserModel( String userName, String userPassword){
        mUserName = userName;
        mUserPassword = userPassword;
    }

    public void setLatLngCoordinatesOnRequest(String latitude, String longitude){
        mLatitude = Long.valueOf(latitude);
        mLongitude = Long.valueOf(longitude);
    }

    public String getmUserPassword() {
        return mUserPassword;
    }

    public void setmUserPassword(String mUserPassword) {
        this.mUserPassword = mUserPassword;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getmUserName() {
        return mUserName;
    }

}
