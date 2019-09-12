package com.neyogiry.android.sample

interface DateInterfaces {

    interface View {
        fun showDateList(dates: ArrayList<String>)
        fun showError(error: String)
    }

    interface Model {
        fun onResponse(any: Any)
        fun onError(error: String)
    }

}