package com.neyogiry.android.sample;

import java.util.ArrayList;

public class DateModel {

    ArrayList<String> mDates = new ArrayList<>();

    public DateModel() {
    }

    public void saveDate(String date, DateInterfaces.Model callback) {
        try{
            mDates.add(0, date);
            onSuccess(callback);
        }catch (Exception e){
            onError(callback, e.toString());
        }
    }

    public void onSuccess(DateInterfaces.Model callback) {
        callback.onResponse(mDates);
    }

    public void onError(DateInterfaces.Model callback, String error) {
        callback.onError(error);
    }

}
