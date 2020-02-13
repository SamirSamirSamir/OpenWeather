/**
 * @file WhaterAdapter.java
 * @brief This is an adapter class responsible for showing movies data.
 * @author Samir
 * @date 12/02/2020
 */
package com.example.weather.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import com.example.weather.R;
import com.example.weather.model.Main;
import com.example.weather.movie_list.WeatherListActivity;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.MyViewHolder> {

    private WeatherListActivity movieListActivity;
    private List<Main> movieList;
    private List<Main> originalMovieList;

    public WeatherAdapter(WeatherListActivity movieListActivity, List<Main> movieList) {
        this.movieListActivity = movieListActivity;
        this.movieList = movieList;
        this.originalMovieList = movieList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.weather_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        Calendar c = Calendar.getInstance();
        Date date = c.getTime(); //current date and time in UTC
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setTimeZone(TimeZone.getTimeZone("Istanbul")); //format in given timezone
        String strDate = df.format(date);

        Log.i("time zone",""+strDate);

        Main weather = movieList.get(position);

        BufferedReader br;
        // Get the console input for the temperature in Kelvin
        System.out.println("Temperature in Kelvin:");
        br = new BufferedReader(new InputStreamReader(System.in));
        // assign to float variable the temperature in Kelvin
        float kelvin = Float.parseFloat(String.valueOf(weather.getTemp()));

        float millibars = Float.parseFloat(String.valueOf(weather.getPressure()));
        // Kelvin to Degree Celsius Conversion
        float celsius = kelvin - 273.15F;

        float millimeters = millibars * 0.75006F;
        int pressure = (int) millimeters;

        int temp = (int) celsius;
        holder.tvTemp.setText(Integer.toString(temp));

        holder.tvDate.setText(strDate);

        holder.tvPressure.setText(Integer.toString(pressure));

        holder.tvHumidity.setText(Integer.toString(weather.getHumidity()));


    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tvPressure;

        public TextView tvTemp;

        public TextView tvHumidity;

        public TextView tvDate;


        public MyViewHolder(View itemView) {
            super(itemView);

            tvPressure = itemView.findViewById(R.id.tv_pressure);
            tvTemp = itemView.findViewById(R.id.tv_temp);
            tvHumidity = itemView.findViewById(R.id.tv_humidity);
            tvDate = itemView.findViewById(R.id.tv_date);
           // pbLoadImage = itemView.findViewById(R.id.pb_load_image);
        }
    }
}
