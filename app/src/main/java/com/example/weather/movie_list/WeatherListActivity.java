/**
 * @file WeatherListActivity.java
 * @brief This activity is responsible for showing all movies data in the list format.
 * @author Samir
 * @date 12/02/2020
 */

package com.example.weather.movie_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.example.weather.R;
import com.example.weather.adapter.WeatherAdapter;
import com.example.weather.model.Main;
//import com.example.weather.movie_details.MovieDetailsActivity;


public class WeatherListActivity extends AppCompatActivity implements WeatherListContract.View, ShowEmptyView {

    private static final String TAG = "WeatherListActivity";
    private WeatherListPresenter weatherListPresenter;
    private RecyclerView rvWeatherList;
    private List<Main> weatherList;
    private WeatherAdapter weatherAdapter;
    private ProgressBar pbLoading;
    private TextView tvEmptyView;

    private int pageNo = 1;

    //Constants for load more
    private int previousTotal = 0;
    private boolean loading = true;
    private int visibleThreshold = 5;
    int firstVisibleItem, visibleItemCount, totalItemCount;
    private GridLayoutManager mLayoutManager;
    private Button save;
    // Constants for filter functionality
    private String fromReleaseFilter = "";
    private String toReleaseFilter = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_list);

        getSupportActionBar().setTitle(getString(R.string.app_title));
        initUI();
        startGetWeather();

            save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                weatherList.clear();
                weatherAdapter.notifyDataSetChanged();

                startGetWeather();
            }
        });

    }

    public void startGetWeather(){

        //Initializing presenter
        weatherListPresenter = new WeatherListPresenter(this);

        weatherListPresenter.requestDataFromServer();

    }
    /**
     * This method will initialize the UI components
     */
    private void initUI() {
        save = (Button)findViewById(R.id.button1);
        rvWeatherList = findViewById(R.id.rv_weather_list);

        weatherList = new ArrayList<Main>();
        weatherAdapter = new WeatherAdapter(this, weatherList);
        // mLayoutManager = new GridLayoutManager(this, 2);
        rvWeatherList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvWeatherList.setItemAnimator(new DefaultItemAnimator());
        rvWeatherList.setAdapter(weatherAdapter);

        pbLoading = findViewById(R.id.pb_loading);


    }

    @Override
    public void showProgress() {

        pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {

        pbLoading.setVisibility(View.GONE);
    }

    @Override
    public void setDataToRecyclerView(List<Main> movieArrayList) {
        Log.i("movieArrayList",""+movieArrayList.toString());
        weatherList.addAll(movieArrayList);
        weatherAdapter.notifyDataSetChanged();
    }


    @Override
    public void onResponseFailure(Throwable throwable) {

        Log.e(TAG, throwable.getMessage());
        Toast.makeText(this, getString(R.string.communication_error), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        weatherListPresenter.onDestroy();
    }


    @Override
    public void showEmptyView() {

        rvWeatherList.setVisibility(View.GONE);
        tvEmptyView.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideEmptyView() {
        rvWeatherList.setVisibility(View.VISIBLE);
        tvEmptyView.setVisibility(View.GONE);
    }
}
