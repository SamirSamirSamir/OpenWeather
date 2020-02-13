/**
 * @file WeatherListPresenter.java
 * @brief This is a presentation class, handles the communication between list view and list model
 * @author Samir
 * @date 12/02/2020
 */
package com.example.weather.movie_list;

import android.util.Log;

import java.util.List;

import com.example.weather.model.Main;

public class WeatherListPresenter implements WeatherListContract.Presenter, WeatherListContract.Model.OnFinishedListener {

    private WeatherListContract.View movieListView;

    private WeatherListContract.Model movieListModel;

    public WeatherListPresenter(WeatherListContract.View movieListView) {
        this.movieListView = movieListView;
        movieListModel = new WeatherListModel();
    }

    @Override
    public void onDestroy() {
        this.movieListView = null;
    }

    @Override
    public void getMoreData(int pageNo) {

        if (movieListView != null) {
            movieListView.showProgress();
        }
        movieListModel.getMovieList(this, pageNo);
    }

    @Override
    public void requestDataFromServer() {

        if (movieListView != null) {
            movieListView.showProgress();
        }
        movieListModel.getMovieList(this, 1);
    }

    @Override
    public void onFinished(List<Main> movieArrayList) {
        movieListView.setDataToRecyclerView(movieArrayList);
        if (movieListView != null) {
            movieListView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {

        movieListView.onResponseFailure(t);
        if (movieListView != null) {
            movieListView.hideProgress();
        }
    }
}
