package com.example.startproject_121azp.service;

import com.example.startproject_121azp.bean.WeatherResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by azp on 2017/3/14.
 */
//
public interface WeatherService {
 @GET("data/sk/{cityNumber}.html")
    Call<WeatherResult> getResult(@Path("cityNumber") String cityNumber);

}
