package com.neyogiry.android.sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_date.*


class DateActivity : AppCompatActivity(), DateInterfaces.View {

    private var adapter: DateAdapter? = null
    private var mPresenter: DatePresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)

        mPresenter = DatePresenter(this)

        setupRecyclerView()

        fab_add_date.setOnClickListener { mPresenter?.addDate() }
    }

    private fun setupRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_dates.layoutManager = linearLayoutManager
        adapter = DateAdapter(ArrayList())
        rv_dates.adapter = adapter
    }

    override fun showDateList(dates: ArrayList<String>) {
        adapter?.updateList(dates)
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

}
