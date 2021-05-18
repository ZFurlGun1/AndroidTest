package com.example.zmy.startproject_328zmy.model;

import com.example.zmy.startproject_328zmy.bean.WeatherInfo;
import com.example.zmy.startproject_328zmy.bean.WeatherResult;
import com.example.zmy.startproject_328zmy.iface.WeatherListener;
import com.example.zmy.startproject_328zmy.iface.Weatheriface;
import com.example.zmy.startproject_328zmy.service.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zmy on 2017/3/14.
 */

public class WeatherModel implements Weatheriface{
  private Retrofit retrofit;
    private String BASEURL="http://www.weather.com.cn/";
    public WeatherModel() {
      System.out.print("----构造函数");
        //Retrofit 实例化
        retrofit=new Retrofit.Builder()
                .baseUrl(BASEURL)//主机地址
         .addConverterFactory(GsonConverterFactory.create())//解析方式
        .build();

    }

    @Override
    public void getWeather(String cityno, final WeatherListener listener) {
//Retrofit接口使用3-2
      WeatherService weatherService=retrofit.create(WeatherService.class);
      Call<WeatherResult> call=weatherService.getResult(cityno);
      //Retrofit 接口使用3--3
      call.enqueue(new Callback<WeatherResult>() {
        @Override
        public void onResponse(Call<WeatherResult> call, Response<WeatherResult> response) {
          if (response.isSuccessful() && response.body() != null)
            listener.onResponse(response.body().getWeatherinfo());
          else
            listener.onFail("onResponse error");
        }
        @Override
        public void onFailure(Call<WeatherResult> call, Throwable t) {
       listener.onFail(t.toString());
        }
      });
    }
}
