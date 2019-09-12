package com.neyogiry.android.sample

class DateModel{

    var mDates: ArrayList<String> = ArrayList()

    fun saveDate(date: String, callback: DateInterfaces.Model) {
        try {
            mDates.add(0, date)
            onSuccess(callback)
        } catch (e: Exception) {
            onError(callback, e.toString())
        }

    }

    private fun onSuccess(callback: DateInterfaces.Model) {
        callback.onResponse(mDates)
    }

    private fun onError(callback: DateInterfaces.Model, error: String) {
        callback.onError(error)
    }

}