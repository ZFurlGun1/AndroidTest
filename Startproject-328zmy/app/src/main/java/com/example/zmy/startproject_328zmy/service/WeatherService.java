package com.example.zmy.startproject_328zmy.service;

import com.example.zmy.startproject_328zmy.bean.WeatherResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by zmy on 2017/3/14.
 */
//
public interface WeatherService {
 @GET("data/sk/{cityNumber}.html")
    Call<WeatherResult> getResult(@Path("cityNumber")String cityNumber);

}
