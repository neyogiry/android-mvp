package com.neyogiry.android.sample;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class DateActivity extends AppCompatActivity implements DateInterfaces.View{

    private FloatingActionButton fab;
    private RecyclerView rvDates;
    private DateAdapter adapter;

    private DatePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        mPresenter = new DatePresenter(this);

        rvDates = (RecyclerView)findViewById(R.id.rv_dates);
        fab = (FloatingActionButton)findViewById(R.id.fab_add_date);

        setupRecyclerView();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDate();
            }
        });
    }

    private void setupRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvDates.setLayoutManager(linearLayoutManager);
        adapter = new DateAdapter(new ArrayList<String>());
        rvDates.setAdapter(adapter);
    }

    public void addDate(){
        mPresenter.addDate();
    }

    @Override
    public void showDateList(ArrayList<String> dates) {
        adapter.updateList(dates);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

}
