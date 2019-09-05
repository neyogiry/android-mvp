package com.neyogiry.android.sample;

import java.util.ArrayList;

public interface DateInterfaces {

    interface View {
        void showDateList(ArrayList<String> dates);
        void showError(String error);
    }

    interface Model {
        void onResponse(ArrayList<String> dates);
        void onError(String error);
    }

}
