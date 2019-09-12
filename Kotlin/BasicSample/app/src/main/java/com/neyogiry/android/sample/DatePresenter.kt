package com.neyogiry.android.sample

import java.util.*
import kotlin.collections.ArrayList


class DatePresenter(onView: DateInterfaces.View): DateInterfaces.Model {

    private var mView: DateInterfaces.View
    private var mModel: DateModel

    init {
        mView = onView
        mModel = DateModel()
    }

    fun addDate() {
        val time = getTimeCurrent()
        mModel.saveDate(time, this)
    }

    private fun getTimeCurrent(): String {
        val timeCurrent: String
        val calendar = Calendar.getInstance()
        timeCurrent = calendar.time.toString()
        return timeCurrent
    }

    override fun onResponse(any: Any) {
        mView.showDateList(any as ArrayList<String>)
    }

    override fun onError(error: String) {
        mView.showError(error)
    }


}