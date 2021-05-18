package com.example.zmy.startproject_328zmy.service;

import com.example.zmy.startproject_328zmy.bean.WeatherResult;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by zmy on 2017/3/14.
 */

public interface Weather51Service {
    @GET("GetMoreWeather")
    Call<WeatherResult> getResult(
     @Query("cityCode") String cityNumber,
     @Query("weatherType")int weatherType
    );
}
