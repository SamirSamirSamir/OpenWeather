/**
 * @file ApiInterface.java
 * @brief This is the api interface class, it will contain all the Api call references
 * @author Samir
 * @date 12/02/2020
 */
package com.example.weather.network;

import com.example.weather.model.Main;
import com.example.weather.model.WResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/data/2.5/weather")
    Call<WResponse> getPopularMovies(@Query("q") String city, @Query("appid") String apiKey);

    @GET("movie/{movie_id}")
    Call<Main> getMovieDetails(@Path("movie_id") int movieId, @Query("api_key") String apiKey, @Query("append_to_response") String credits);

}
