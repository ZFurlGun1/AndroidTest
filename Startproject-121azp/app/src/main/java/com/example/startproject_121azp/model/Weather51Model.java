package com.example.startproject_121azp.model;

import com.example.startproject_121azp.bean.WeatherResult;
import com.example.startproject_121azp.iface.WeatherListener;
import com.example.startproject_121azp.iface.Weatheriface;
import com.example.startproject_121azp.service.Weather51Service;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tony on 2017/3/14.
 */

public class Weather51Model implements Weatheriface{
    private Weather51Service service;
    private Retrofit retrofit;
    private static final String BASE_URL="http://weather.51wnl.com/weatherinfo/";

    public Weather51Model() {
        retrofit =new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    @Override
    public void getWeather(String cityNumber, final WeatherListener listener) {
        service=retrofit.create(Weather51Service.class);
        Call<WeatherResult> call=service.getResult(cityNumber,1);
        call.enqueue(new Callback<WeatherResult>(){
            @Override
            public void onResponse(Call<WeatherResult> call, Response<WeatherResult> response) {
                if(response.isSuccessful()&&response.body()!=null){
                    listener.onResponse(response.body().getWeatherinfo());
                }
                else{
                    listener.onFail("解析错误！");
                }
            }

            @Override
            public void onFailure(Call<WeatherResult> call, Throwable t) {
                listener.onFail(t.toString());
            }
        });
    }
}
