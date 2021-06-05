package com.example.startproject_121azp.iface;

/**
 * Created by azpon 2017/3/14.
 */
//不同方式获取天气，定义接口
public interface Weatheriface {
    void getWeather(String cityno, WeatherListener listener);

}
