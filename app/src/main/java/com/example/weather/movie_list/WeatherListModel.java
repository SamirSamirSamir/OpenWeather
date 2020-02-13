/**
 * @file WeatherListModel.java
 * @brief This is model class for list screen, it will handle all business logic.
 * @author Samir
 * @date 12/02/2020
 * */

package com.example.weather.movie_list;

import android.content.Context;
import android.util.Log;

import java.util.Collections;
import java.util.List;

import com.example.weather.model.Main;
import com.example.weather.model.WResponse;
import com.example.weather.network.ApiClient;
import com.example.weather.network.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.weather.network.ApiClient.API_KEY;

public class WeatherListModel implements WeatherListContract.Model {

    private final String TAG = "WeatherListModel";
    private Context context;



    @Override
    public void getMovieList(final OnFinishedListener onFinishedListener, int pageNo) {

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<WResponse> call = apiService.getPopularMovies("London",API_KEY);

        call.enqueue(new Callback<WResponse>() {
            @Override
            public void onResponse(Call<WResponse> call, Response<WResponse> response) {
                List<Main> weatherItems = Collections.singletonList(response.body().getMain());


                onFinishedListener.onFinished(weatherItems);
            }

            @Override
            public void onFailure(Call<WResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
                onFinishedListener.onFailure(t);
            }
        });
    }


}
