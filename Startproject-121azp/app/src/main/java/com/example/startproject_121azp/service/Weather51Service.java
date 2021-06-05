package com.example.startproject_121azp.service;

import com.example.startproject_121azp.bean.WeatherResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by azp on 2017/3/14.
 */

public interface Weather51Service {
    @GET("GetMoreWeather")
    Call<WeatherResult> getResult(
            @Query("cityCode") String cityNumber,
            @Query("weatherType") int weatherType
    );
}
