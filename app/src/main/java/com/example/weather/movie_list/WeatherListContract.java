/**
 * @file WeatherListContract.java
 * @brief This is the contract class, it will have interfaces for model, view and presenter.
 * @author Samir
 * @date 12/02/2020
 */

package com.example.weather.movie_list;

import java.util.List;

import com.example.weather.model.Main;

public interface WeatherListContract {

    interface Model {

        interface OnFinishedListener {
            void onFinished(List<Main> movieArrayList);

            void onFailure(Throwable t);
        }

        void getMovieList(OnFinishedListener onFinishedListener, int pageNo);

    }

    interface View {

        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(List<Main> movieArrayList);

        void onResponseFailure(Throwable throwable);

    }

    interface Presenter {

        void onDestroy();

        void getMoreData(int pageNo);

        void requestDataFromServer();

    }
}
