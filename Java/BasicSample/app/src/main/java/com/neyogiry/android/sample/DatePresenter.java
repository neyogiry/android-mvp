package com.neyogiry.android.sample;

import java.util.ArrayList;
import java.util.Calendar;

public class DatePresenter implements DateInterfaces.Model {

    private DateInterfaces.View mView;
    private DateModel mModel;

    public DatePresenter(DateInterfaces.View view) {
        this.mView = view;
        this.mModel = new DateModel();
    }

    public void addDate() {
        String time = getTimeCurrent();
        mModel.saveDate(time, this);
    }

    private String getTimeCurrent() {
        String timeCurrent;
        Calendar calendar = Calendar.getInstance();
        timeCurrent = calendar.getTime().toString();
        return timeCurrent;
    }

    @Override
    public void onResponse(ArrayList<String> dates) {
        mView.showDateList(dates);
    }

    @Override
    public void onError(String error) {
        mView.showError(error);
    }
}
