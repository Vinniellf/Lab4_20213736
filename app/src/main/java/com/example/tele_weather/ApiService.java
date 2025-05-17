package com.example.tele_weather;

import com.example.tele_weather.Model.Location;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("search.json")
    Call<List<Location>> searchLocations(
            @Query("key") String apiKey,
            @Query("q") String query
    );

    @GET("forecast.json")
    Call<PronosticoResponse> getForecast(
            @Query("key") String apiKey,
            @Query("q") String locationId,
            @Query("days") Integer days
    );

    @GET("future.json")
    Call<HoraResponse> getFuturo(
            @Query("key") String apiKey,
            @Query("q") String locationId,
            @Query("dt") String day
    );

}
